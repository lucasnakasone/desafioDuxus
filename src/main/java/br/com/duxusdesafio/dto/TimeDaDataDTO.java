package br.com.duxusdesafio.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import br.com.duxusdesafio.model.Time;

// DTO que retorna os dados conforme requisitos do método TimeDaDataDTO na ApiService

public class TimeDaDataDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;
	private LocalDate data;
    private List<String> integrantes;

    public TimeDaDataDTO(Time time) {
        this.data = time.getData();
        this.integrantes = time.getComposicaoTime().stream()
            .map(composicao -> composicao.getIntegrante().getNome())
            .collect(Collectors.toList());
    }

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<String> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<String> integrantes) {
		this.integrantes = integrantes;
	}
    
    
}
