package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.TimeDaDataDTO;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repositories.TimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * Assinatura original: public Time timeDaData(LocalDate data, List<Time> todosOsTimes){return null;}
     * TODO Implementar método seguindo as instruções!
	}
     */
	public List<TimeDaDataDTO> timeDaData(int ano){
		List<Time> times = timeRepository.findByYear(ano);
	    return times.stream().map(TimeDaDataDTO::new).collect(Collectors.toList());
	}
	
    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     * Assinatura original: public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){return null;}
     * TODO Implementar método seguindo as instruções!
     */
    public Integrante integranteMaisUsado(int dataInicial, int dataFinal){
    	List<Time> times = timeRepository.findTimesByYearRange(dataInicial, dataFinal);
    	Map<Integrante, Integer> contagemIntegrantes = new HashMap<>();
    	for (Time time : times) {
            for (ComposicaoTime composicao : time.getComposicaoTime()) {
                Integrante integrante = composicao.getIntegrante();
                contagemIntegrantes.put(integrante, contagemIntegrantes.getOrDefault(integrante, 0) + 1);
            }
        }
    	return contagemIntegrantes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }


    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
