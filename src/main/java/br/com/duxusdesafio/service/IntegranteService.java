package br.com.duxusdesafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repositories.IntegranteRepository;

@Service
public class IntegranteService {

	@Autowired
	private IntegranteRepository repository;
	
	@Transactional(readOnly = true)
	public List<Integrante> findAll(){
		return repository.findAll();
	}
	
}
