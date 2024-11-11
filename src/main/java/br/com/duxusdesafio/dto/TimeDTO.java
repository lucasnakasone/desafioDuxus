package br.com.duxusdesafio.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.duxusdesafio.model.Time;

// DTO padrão para o Time

public class TimeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;
	private LocalDate data;
	private List<ComposicaoTimeDTO> composicaoTime;	
	
	public TimeDTO(Time entity) {
		this.id = entity.getId();
		this.data = entity.getData();
		this.composicaoTime = entity.getComposicaoTime().stream().map(x -> new ComposicaoTimeDTO(x)).collect(Collectors.toList());
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

	public List<ComposicaoTimeDTO> getComposicaoTime() {
		return composicaoTime;
	}

	public void setComposicaoTime(List<ComposicaoTimeDTO> composicaoTime) {
		this.composicaoTime = composicaoTime;
	}
	
}
