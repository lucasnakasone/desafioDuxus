package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.ContagemFranquiaDTO;
import br.com.duxusdesafio.dto.ContagemFuncaoDTO;
import br.com.duxusdesafio.dto.FuncaoMaisComumDTO;
import br.com.duxusdesafio.dto.IntegranteDTO;
import br.com.duxusdesafio.dto.TimeDaDataDTO;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
@Service
public class ApiService {

	@Autowired
	private TimeRepository timeRepository;
	
	/**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data	
     * 
     * O retorno foi alterado para trazer uma DTO apenas com as informações pertinentes ao método, que:
     * - retorna todos os times (fornecido na resource) dentro de determinada data, filtrada na stream.	}
     */
	
	public TimeDaDataDTO timeDaData(LocalDate data) {
		List<Time> times = timeRepository.findAll();
		TimeDaDataDTO time = new TimeDaDataDTO(timeDaData(data, times));
		return time;
	}
		
	public Time timeDaData(LocalDate data, List<Time> todosOsTimes) {
	    return todosOsTimes.stream()
	        .filter(time -> time.getData().equals(data))
	        .findFirst()
	        .orElse(null);
	}
	
    
	public IntegranteDTO integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal) {
		
		Integrante integrante = integranteMaisUsado(dataInicial, dataFinal, timeRepository.findAll());
		
		return new IntegranteDTO(integrante);
		
	}
	
	/**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período:
     * 
     * Observação: No momento a função traz o integrante de maior contagem, porém caso hajam mais integrantes com mesma ocorrência,
     * 	será retornado apenas o primeiro integrante que atingiu aquela quantidade - pendente de melhoria na implementação.
     * 	Acabei seguindo essa lógica para obedecer a assinatura do método.
     */
	
	public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
		
    	List<Time> timesFiltrados = filterTimesByDateRange(dataInicial, dataFinal, todosOsTimes);
    	
    	Map<Integrante, Integer> contagemIntegrantes = new HashMap<>();
    	// Iteramos sobre a composição dos times, pegando cada integrante e contando sua ocorrência
    	for (Time time : timesFiltrados) {
            for (ComposicaoTime composicao : time.getComposicaoTime()) {
            	
                Integrante integrante = composicao.getIntegrante();
                
                contagemIntegrantes.put(integrante, contagemIntegrantes.getOrDefault(integrante, 0) + 1);
            }
        }
    	// Resgata o integrante de maior valor (que mais apareceu)
    	Map.Entry<Integrante, Integer> integranteMaisUsado = contagemIntegrantes.entrySet().stream()
    	        .max(Map.Entry.comparingByValue())
    	        .orElse(null);   
    	
    	return integranteMaisUsado.getKey();
    }

    
	
	public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal){
		List<Time> times = timeRepository.findAll();
		List<String> timeMaisComum = timeMaisComum(dataInicial, dataFinal, times);
		return timeMaisComum;
	}
	
	/**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
	
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
    	List<Time> times = filterTimesByDateRange(dataInicial, dataFinal, todosOsTimes);
    	
    	Map<Set<Integrante>, Integer> timesComum = new HashMap<>();
    	
    	// Iteramos sobre os integrantes de cada time e fazendo a contagem
    	for (Time t : times) {
    		// Convertendo para set para desconsiderar repetições
    		Set<Integrante> integrantes = t.getComposicaoTime().stream().map(c -> c.getIntegrante()).collect(Collectors.toSet());
    		timesComum.put(integrantes, timesComum.getOrDefault(integrantes, 0) + 1);
    	}
    	
    	Set<Integrante> integrante = timesComum.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);	
    	
    	return integrante.stream().map(x -> x.getNome()).collect(Collectors.toList());
    	
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     * 
     * Observação: O método abaixo tem o mesmo comportamento de integranteMaisUsado - pendente de melhoria na implementação.  
     */
    public FuncaoMaisComumDTO funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal) {
    	String funcao = funcaoMaisComum(dataInicial, dataFinal, timeRepository.findAll());
		return new FuncaoMaisComumDTO(funcao);
    }
    
     public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
    	List<Time> times = filterTimesByDateRange(dataInicial, dataFinal, todosOsTimes);
    	Map<String, Integer> contagemFuncao = new HashMap<>();
    	for (Time time : times) {
            for (ComposicaoTime composicao : time.getComposicaoTime()) {
                String funcao = composicao.getIntegrante().getFuncao();
                contagemFuncao.put(funcao, contagemFuncao.getOrDefault(funcao, 0) + 1);
            }
        }
    	return contagemFuncao.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);	
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     *       
     */
    
    
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal) {
    	List<Time> times = timeRepository.findAll();
    	return franquiaMaisFamosa(dataInicial, dataFinal, times);
    }
    
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) { 	
    	List<Time> times = filterTimesByDateRange(dataInicial, dataFinal, todosOsTimes);
    	Map<String, Integer> contagemFranquia = new HashMap<>();
    	for (Time time : times) {
            for (ComposicaoTime composicao : time.getComposicaoTime()) {
                String franquia = composicao.getIntegrante().getFranquia();
                contagemFranquia.put(franquia, contagemFranquia.getOrDefault(franquia, 0) + 1);
            }
        }
    	return contagemFranquia.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     * 
     */
    public List<ContagemFranquiaDTO> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal){
    	    	
    	Map<String, Long> contagemFranquia = contagemPorFranquia(dataInicial, dataFinal, timeRepository.findAll());
    	
    	List<ContagemFranquiaDTO> franquias = new ArrayList<>();
    	
    	for (Map.Entry<String, Long> entry : contagemFranquia.entrySet()) {
            ContagemFranquiaDTO dto = new ContagemFranquiaDTO(entry.getKey(), entry.getValue());
            franquias.add(dto);
        }
    	
    	return franquias;
    }

    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
    	List<Time> timesFiltrados = filterTimesByDateRange(dataInicial, dataFinal, todosOsTimes);
    	Map<String, Long> contagemFranquia = new HashMap<>();
    	for (Time time : timesFiltrados) {
    		List<ComposicaoTime> composicao = time.getComposicaoTime();
    		if (composicao.isEmpty()) {
    			continue;
    		}
    		// A franquia do time sempre será a mesma, sendo necessário verificar apenas a franquia do primeiro integrante
            String franquia = composicao.get(0).getIntegrante().getFranquia();
            contagemFranquia.put(franquia, contagemFranquia.getOrDefault(franquia, 0L) + 1);       
        }
    	
        return contagemFranquia;	
    }
    
    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     *    	
     */
    public List<ContagemFuncaoDTO> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal){
    	Map<String, Long> contagemFuncao = contagemPorFuncao(dataInicial, dataFinal, timeRepository.findAll());
    	
    	List<ContagemFuncaoDTO> funcoes = new ArrayList<>();
    	
    	for (Map.Entry<String, Long> entry : contagemFuncao.entrySet()) {
            ContagemFuncaoDTO dto = new ContagemFuncaoDTO(entry.getKey(), entry.getValue());
            funcoes.add(dto);
        }
    	
    	return funcoes;
    }
    
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
    	List<Time> times = filterTimesByDateRange(dataInicial, dataFinal, todosOsTimes);
    	Map<String, Long> contagemFuncao = new HashMap<>();
    	Set<Integrante> integrantes = new HashSet<>();
    	for (Time time : times) {
            for (ComposicaoTime composicao : time.getComposicaoTime()) {
                integrantes.add(composicao.getIntegrante());
            }
            
        }
    	for (Integrante i : integrantes) {
    		String funcao = i.getFuncao();
            contagemFuncao.put(funcao, contagemFuncao.getOrDefault(funcao, 0L) + 1);
    	}
        return contagemFuncao;
    }
    
    
    /*
     * 
     * 
     * 
     */
    
    public List<Time> filterTimesByDateRange(LocalDate dataInicial, LocalDate dataFinal, List<Time> times) {
        return times.stream()
        		// Verifica se a data está entre a data inicial e a final
                .filter(time -> (dataInicial == null || !time.getData().isBefore(dataInicial)) &&
                                (dataFinal == null || !time.getData().isAfter(dataFinal)))
                .collect(Collectors.toList());
    }

}
