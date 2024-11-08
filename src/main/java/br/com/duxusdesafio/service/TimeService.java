package br.com.duxusdesafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.duxusdesafio.dto.TimeDTO;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repositories.TimeRepository;

@Service
public class TimeService {

	@Autowired
	private TimeRepository repository;
	
	@Transactional(readOnly = true)
	public List<TimeDTO> findAll(){
		List<Time> list = repository.findAll();
		return list.stream().map(x -> new TimeDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public TimeDTO insert(TimeDTO dto) {
		Time entity = new Time();
		entity.setData(dto.getData());
		entity = repository.save(entity);
		return new TimeDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<TimeDTO> findByYear(int ano) {
		List<Time> times = repository.findByYear(ano);
		return times.stream().map(x -> new TimeDTO(x)).collect(Collectors.toList());
	}
	
}
