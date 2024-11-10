package br.com.duxusdesafio.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Time;

public class TimeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate data;
	private List<ComposicaoTime> composicaoTime;
	
	
	public TimeDTO(Time entity) {
		this.id = entity.getId();
		this.data = entity.getData();
		this.composicaoTime = entity.getComposicaoTime();
	}
	
	public TimeDTO() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ComposicaoTime> getComposicaoTime() {
		return composicaoTime;
	}

	public void setComposicaoTime(List<ComposicaoTime> composicaoTime) {
		this.composicaoTime = composicaoTime;
	}
	
}
