package br.com.duxusdesafio.dto;

public class ContagemFuncaoDTO {

	private String funcao;
	private Integer contagem;
	
	public ContagemFuncaoDTO(String funcao, Integer contagem) {
		this.funcao = funcao;
		this.contagem = contagem;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String franquia) {
		this.funcao = franquia;
	}
	public Integer getContagem() {
		return contagem;
	}
	public void setContagem(Integer contagem) {
		this.contagem = contagem;
	}
	
}
