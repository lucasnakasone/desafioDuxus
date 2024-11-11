package br.com.duxusdesafio.dto;

import java.io.Serializable;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

public class ComposicaoTimeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private Time time;
	private Integrante integrante;
	
	public ComposicaoTimeDTO() {
		super();
	}

	public ComposicaoTimeDTO(ComposicaoTime entity) {
		this.id = entity.getId();
		this.time = entity.getTime();
		this.integrante = entity.getIntegrante();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Integrante getIntegrante() {
		return integrante;
	}
	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}
	
	
	
}
