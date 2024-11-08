package br.com.duxusdesafio.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.duxusdesafio.model.Time;

public class TimeDaDataDTO extends TimeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
    private LocalDate data;
    private List<IntegranteDTO> integrantes;

    public TimeDaDataDTO(Time time) {
        this.id = time.getId();
        this.data = time.getData();
        this.integrantes = time.getComposicaoTime().stream()
            .map(composicao -> new IntegranteDTO(composicao.getIntegrante()))
            .collect(Collectors.toList());
    }

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<IntegranteDTO> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<IntegranteDTO> integrantes) {
		this.integrantes = integrantes;
	}
    
    
}
