package br.com.duxusdesafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.duxusdesafio.dto.IntegranteDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repositories.IntegranteRepository;

@Service
public class IntegranteService {

	@Autowired
	private IntegranteRepository repository;
	
	@Transactional(readOnly = true)
	public List<IntegranteDTO> findAll(){
		List<Integrante> list = repository.findAll();
		return list.stream().map(x -> new IntegranteDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public IntegranteDTO findById(Long id) {
		Optional<Integrante> optional = repository.findById(id);
		Integrante entity = optional.get();
		return new IntegranteDTO(entity);
	}

	@Transactional
	public IntegranteDTO insert(IntegranteDTO dto) {
		Integrante entity = new Integrante();
		entity.setFranquia(dto.getFranquia());
		entity.setNome(dto.getNome());
		entity.setFuncao(dto.getFuncao());
		entity = repository.save(entity);
		return new IntegranteDTO(entity);
	}
	
}
