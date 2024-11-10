package br.com.duxusdesafio.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.dto.ContagemFranquiaDTO;
import br.com.duxusdesafio.dto.ContagemFuncaoDTO;
import br.com.duxusdesafio.dto.FranquiaMaisFamosaDTO;
import br.com.duxusdesafio.dto.IntegranteMaisUsadoDTO;
import br.com.duxusdesafio.dto.TimeDaDataDTO;
import br.com.duxusdesafio.repositories.TimeRepository;
import br.com.duxusdesafio.service.ApiService;

@RestController
@RequestMapping(value = "/api")
public class ApiResource {
	
	@Autowired
	private ApiService service;
	
	@Autowired
	private TimeRepository timeRepository;	
	
	@GetMapping("/times-da-data")
    public ResponseEntity<TimeDaDataDTO> timeDaData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
		TimeDaDataDTO timesDaData = service.timeDaData(data);
		return ResponseEntity.ok(timesDaData);
	}
	
	@GetMapping("/integrante-mais-usado")
	public ResponseEntity<IntegranteMaisUsadoDTO> integranteMaisUsado(
			@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        IntegranteMaisUsadoDTO integranteMaisUsado = service.integranteMaisUsado(dataInicial, dataFinal, timeRepository.findAll());
        if (integranteMaisUsado == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(integranteMaisUsado);
    }
	
	@GetMapping("/funcao-mais-comum")
	public ResponseEntity<String> funcaoMaisComum(
			@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        String funcaoMaisComum = service.funcaoMaisComum(dataInicial, dataFinal);
        if (funcaoMaisComum == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(funcaoMaisComum);
    }
	
	@GetMapping("/franquia-mais-famosa")
	public ResponseEntity<FranquiaMaisFamosaDTO>  franquiaMaisFamosa(
			@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		String franquia = service.franquiaMaisFamosa(dataInicial, dataFinal);
		FranquiaMaisFamosaDTO franquiaMaisFamosa = new FranquiaMaisFamosaDTO(franquia);
		if (franquia == null) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(franquiaMaisFamosa);
    }
	
	@GetMapping("/contagem-por-franquia")
    public ResponseEntity<List<ContagemFranquiaDTO>> contagemPorFranquia(
			@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		List<ContagemFranquiaDTO> contagemFranquia = service.contagemPorFranquia(dataInicial, dataFinal);
		if (contagemFranquia.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(contagemFranquia);
    }
	
	@GetMapping("/contagem-por-funcao")
    public ResponseEntity<List<ContagemFuncaoDTO>> contagemPorFuncao(
			@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		List<ContagemFuncaoDTO> contagemFuncao = service.contagemFuncao(dataInicial, dataFinal, timeRepository.findAll());
		if (contagemFuncao.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(contagemFuncao);
    }
	
}
