package br.com.duxusdesafio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.duxusdesafio.dto.TimeDTO;
import br.com.duxusdesafio.service.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeResource {
	
	@Autowired
	private TimeService service;
	
	@GetMapping
	public ResponseEntity<List<TimeDTO>> findAll(){
		List<TimeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{ano}")
	public ResponseEntity<List<TimeDTO>> findByYear(@PathVariable int ano){
		List<TimeDTO> list = service.findByYear(ano);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<TimeDTO> insert(@RequestBody TimeDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
