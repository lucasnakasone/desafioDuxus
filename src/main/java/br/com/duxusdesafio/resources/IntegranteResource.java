package br.com.duxusdesafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.service.IntegranteService;

@RestController
@RequestMapping(value = "/integrantes")
public class IntegranteResource {

	@Autowired
	private IntegranteService service;
	
	@GetMapping
	public ResponseEntity<List<Integrante>> findAll(){
		List<Integrante> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
