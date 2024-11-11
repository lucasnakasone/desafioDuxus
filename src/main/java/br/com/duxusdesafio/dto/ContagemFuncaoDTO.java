package br.com.duxusdesafio.dto;

// DTO que retorna os dados conforme requisitos do método contagemFuncao na ApiService

public class ContagemFuncaoDTO {

	private String funcao;
	private Long contagem;
	
	public ContagemFuncaoDTO(String funcao, Long contagem) {
		this.funcao = funcao;
		this.contagem = contagem;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String franquia) {
		this.funcao = franquia;
	}
	public Long getContagem() {
		return contagem;
	}
	public void setContagem(Long contagem) {
		this.contagem = contagem;
	}
	
}
