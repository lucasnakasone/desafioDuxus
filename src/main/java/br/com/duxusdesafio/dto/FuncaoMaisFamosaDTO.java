package br.com.duxusdesafio.dto;

// DTO que retorna os dados conforme requisitos do método funcaoMaisFamosa na ApiService

public class FuncaoMaisFamosaDTO {

	private String funcao;
	
	public FuncaoMaisFamosaDTO(String funcao) {
		this.funcao = funcao;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFranquia(String funcao) {
		this.funcao = funcao;
	}
}
