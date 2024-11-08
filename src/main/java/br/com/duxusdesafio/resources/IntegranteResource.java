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

import br.com.duxusdesafio.dto.IntegranteDTO;
import br.com.duxusdesafio.service.IntegranteService;

@RestController
@RequestMapping(value = "/integrantes")
public class IntegranteResource {

	@Autowired
	private IntegranteService service;
	
	@GetMapping
	public ResponseEntity<List<IntegranteDTO>> findAll(){
		List<IntegranteDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IntegranteDTO> findById(@PathVariable Long id){
		IntegranteDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<IntegranteDTO> insert(@RequestBody IntegranteDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);				
	}
	
}
