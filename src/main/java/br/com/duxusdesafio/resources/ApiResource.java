package br.com.duxusdesafio.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.dto.IntegranteDTO;
import br.com.duxusdesafio.dto.TimeDaDataDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.service.ApiService;

@RestController
@RequestMapping(value = "/api")
public class ApiResource {
	
	@Autowired
	private ApiService service;
	
	@GetMapping("/ano/{ano}")
    public ResponseEntity<List<TimeDaDataDTO>> buscarTimesPorAno(@PathVariable int ano) {
        List<TimeDaDataDTO> times = service.timeDaData(ano);
        return ResponseEntity.ok(times);
    }
	
	@GetMapping("/integrante-mais-usado")
	public ResponseEntity<IntegranteDTO> integranteMaisUsado(@RequestParam int dataInicial, @RequestParam int dataFinal) {
        Integrante integranteMaisUsado = service.integranteMaisUsado(dataInicial, dataFinal);
        if (integranteMaisUsado == null) {
            return ResponseEntity.noContent().build();
        }
        IntegranteDTO integranteDTO = new IntegranteDTO(integranteMaisUsado);
        return ResponseEntity.ok(integranteDTO);
    }
	
	@GetMapping("/funcao-mais-comum")
	public ResponseEntity<String> funcaoMaisComum(@RequestParam int dataInicial, @RequestParam int dataFinal) {
        String funcaoMaisComum = service.funcaoMaisComum(dataInicial, dataFinal);
        if (funcaoMaisComum == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(funcaoMaisComum);
    }
	
	@GetMapping("/franquia-mais-famosa")
	public ResponseEntity<String> franquiaMaisFamosa(@RequestParam int dataInicial, @RequestParam int dataFinal) {
        String franquiaMaisFamosa = service.franquiaMaisFamosa(dataInicial, dataFinal);
        if (franquiaMaisFamosa == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(franquiaMaisFamosa);
    }
	
	@GetMapping("/contagem-por-franquia")
    public ResponseEntity<Map<String, Integer>> contagemPorFranquia(@RequestParam int dataInicial, @RequestParam int dataFinal) {
		Map<String, Integer> contagemFranquia = service.contagemPorFranquia(dataInicial, dataFinal);
		if (contagemFranquia.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(contagemFranquia);
    }
	
	@GetMapping("/contagem-por-funcao")
    public ResponseEntity<Map<String, Integer>> contagemPorFuncao(@RequestParam int dataInicial, @RequestParam int dataFinal) {
		Map<String, Integer> contagemFuncao = service.contagemPorFuncao(dataInicial, dataFinal);
		if (contagemFuncao.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(contagemFuncao);
    }
	
}
