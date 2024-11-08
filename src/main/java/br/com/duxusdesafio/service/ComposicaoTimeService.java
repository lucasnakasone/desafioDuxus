package br.com.duxusdesafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.duxusdesafio.dto.ComposicaoTimeDTO;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.repositories.ComposicaoTimeRepository;

@Service
public class ComposicaoTimeService {

	@Autowired
	private ComposicaoTimeRepository repository;
	
	@Transactional(readOnly = true)
	public List<ComposicaoTimeDTO> findAll(){
		List<ComposicaoTime> list = repository.findAll();
		return list.stream().map(x -> new ComposicaoTimeDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ComposicaoTimeDTO findById(Long id) {
		Optional<ComposicaoTime> optional = repository.findById(id);
		ComposicaoTime entity = optional.get();
		return new ComposicaoTimeDTO(entity);
	}
	
	@Transactional
	public ComposicaoTimeDTO insert(ComposicaoTimeDTO dto) {
		ComposicaoTime entity = new ComposicaoTime();
		entity.setIntegrante(dto.getIntegrante());
		entity.setTime(dto.getTime());
		entity = repository.save(entity);
		return new ComposicaoTimeDTO(entity);
	}
	
}
