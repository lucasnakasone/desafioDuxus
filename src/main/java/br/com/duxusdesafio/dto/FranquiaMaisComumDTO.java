package br.com.duxusdesafio.dto;

// DTO que retorna os dados conforme requisitos do método franquiaMaisComum na ApiService

public class FranquiaMaisComumDTO {

	private String franquia;
	
	public FranquiaMaisComumDTO(String franquia) {
		this.franquia = franquia;
	}
	public String getFranquia() {
		return franquia;
	}
	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}
}
