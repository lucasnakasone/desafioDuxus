package br.com.duxusdesafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.dto.TimeDaDataDTO;
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
	
}
