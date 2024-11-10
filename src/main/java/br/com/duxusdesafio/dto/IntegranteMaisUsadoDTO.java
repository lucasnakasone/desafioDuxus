package br.com.duxusdesafio.dto;

import java.io.Serializable;

public class IntegranteMaisUsadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer quantidade;
	
	public IntegranteMaisUsadoDTO(String nome, Integer quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public IntegranteMaisUsadoDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
