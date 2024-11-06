package br.com.duxusdesafio.dto;

import java.io.Serializable;

import br.com.duxusdesafio.model.Integrante;

public class IntegranteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String franquia;
	private String nome;
	private String funcao;
	
	public IntegranteDTO(Integrante entity) {
		this.id = entity.getId();
		this.franquia = entity.getFranquia();
		this.nome = entity.getNome();
		this.funcao = entity.getFuncao();
	}
	
	public IntegranteDTO() {
		
	}

	public IntegranteDTO(Long id, String franquia, String nome, String funcao) {
		this.id = id;
		this.franquia = franquia;
		this.nome = nome;
		this.funcao = funcao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
		
}
