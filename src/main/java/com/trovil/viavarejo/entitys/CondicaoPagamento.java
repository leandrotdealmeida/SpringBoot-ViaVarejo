package com.trovil.viavarejo.entitys;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class CondicaoPagamento {
	
	private BigDecimal valorEntrada;
	
	private Integer quantidadeParcelas;

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	
	
	
	
	

}
