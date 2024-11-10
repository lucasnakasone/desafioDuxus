package br.com.duxusdesafio.dto;

public class ContagemFranquiaDTO {

	private String franquia;
	private Long contagem;
	
	public ContagemFranquiaDTO(String franquia, Long contagem) {
		this.franquia = franquia;
		this.contagem = contagem;
	}
	public String getFranquia() {
		return franquia;
	}
	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}
	public Long getContagem() {
		return contagem;
	}
	public void setContagem(Long contagem) {
		this.contagem = contagem;
	}
	
}
