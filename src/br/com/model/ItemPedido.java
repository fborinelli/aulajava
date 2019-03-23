package br.com.model;

import java.math.BigDecimal;

//import java.math.BigDecimal;

public class ItemPedido extends Base {
	BigDecimal valor;
	int quantidade;
	String nome;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
