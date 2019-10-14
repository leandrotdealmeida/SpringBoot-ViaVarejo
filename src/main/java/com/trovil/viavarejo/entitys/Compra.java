package com.trovil.viavarejo.entitys;

import lombok.Getter;

@Getter
public class Compra {
	private Produto produto;
	
	private CondicaoPagamento condicaoPagamento;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

}
