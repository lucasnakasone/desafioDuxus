package br.com.duxusdesafio.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.duxusdesafio.model.ComposicaoTime;

// DTO padrão para Composicao do Time

public class ComposicaoTimeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;
	private TimeDTO time;
	private IntegranteDTO integrante;
	
	public ComposicaoTimeDTO() {
		super();
	}

	public ComposicaoTimeDTO(ComposicaoTime entity) {
		this.id = entity.getId();
		this.time = new TimeDTO(entity.getTime());
		this.integrante = new IntegranteDTO(entity.getIntegrante());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TimeDTO getTime() {
		return time;
	}
	public void setTime(TimeDTO time) {
		this.time = time;
	}
	public IntegranteDTO getIntegrante() {
		return integrante;
	}
	public void setIntegrante(IntegranteDTO integrante) {
		this.integrante = integrante;
	}
		
}
