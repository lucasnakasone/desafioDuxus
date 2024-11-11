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
import br.com.duxusdesafio.dto.FranquiaMaisComumDTO;
import br.com.duxusdesafio.dto.FuncaoMaisFamosaDTO;
import br.com.duxusdesafio.dto.IntegranteDTO;
import br.com.duxusdesafio.dto.TimeDaDataDTO;
import br.com.duxusdesafio.service.ApiService;

@RestController
@RequestMapping(value = "/api")
public class ApiResource {
	
	@Autowired
	private ApiService service;

	@GetMapping("/times-da-data")
    public ResponseEntity<TimeDaDataDTO> timeDaData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
		TimeDaDataDTO timesDaData = service.timeDaData(data);
		if (timesDaData == null) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(timesDaData);
	}
	
	@GetMapping("/integrante-mais-usado")
	public ResponseEntity<IntegranteDTO> integranteMaisUsado(
			@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        IntegranteDTO integranteMaisUsado = service.integranteMaisUsado(dataInicial, dataFinal);
        if (integranteMaisUsado == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(integranteMaisUsado);
    }
	
	@GetMapping("/time-mais-comum")
	public ResponseEntity<List<String>> timeMaisComum(
			@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal){
		List<String> timeMaisComum = service.timeMaisComum(dataInicial, dataFinal);
		if (timeMaisComum == null) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(timeMaisComum);
	}
	
	@GetMapping("/funcao-mais-comum")
	public ResponseEntity<FuncaoMaisFamosaDTO> funcaoMaisComum(
			@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        FuncaoMaisFamosaDTO funcaoMaisComum = service.funcaoMaisComum(dataInicial, dataFinal);
        if (funcaoMaisComum == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(funcaoMaisComum);
    }
	
	@GetMapping("/franquia-mais-famosa")
	public ResponseEntity<FranquiaMaisComumDTO>  franquiaMaisFamosa(
			@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		FranquiaMaisComumDTO franquia = service.franquiaMaisFamosa(dataInicial, dataFinal);
		if (franquia == null) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(franquia);
    }
	
	@GetMapping("/contagem-por-franquia")
    public ResponseEntity<List<ContagemFranquiaDTO>> contagemPorFranquia(
			@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		List<ContagemFranquiaDTO> contagemFranquia = service.contagemPorFranquia(dataInicial, dataFinal);
		if (contagemFranquia.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(contagemFranquia);
    }
	
	@GetMapping("/contagem-por-funcao")
    public ResponseEntity<List<ContagemFuncaoDTO>> contagemPorFuncao(
			@RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		List<ContagemFuncaoDTO> contagemFuncao = service.contagemPorFuncao(dataInicial, dataFinal);
		if (contagemFuncao.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
		return ResponseEntity.ok(contagemFuncao);
    }
	
}
