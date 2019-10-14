package com.trovil.viavarejo.entitys;

import java.math.BigDecimal;

public class Parcela {

	private Integer numeroParcela;
	
	private BigDecimal valor;
	
	private BigDecimal taxaDeJuroAoMes;
	
	

	public Parcela(Integer numeroParcela, BigDecimal valor, BigDecimal taxaDeJuroAoMes) {
		super();
		this.numeroParcela = numeroParcela;
		this.valor = valor;
		this.taxaDeJuroAoMes = taxaDeJuroAoMes;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxaDeJuroAoMes() {
		return taxaDeJuroAoMes;
	}

	public void setTaxaDeJuroAoMes(BigDecimal taxaDeJuroAoMes) {
		this.taxaDeJuroAoMes = taxaDeJuroAoMes;
	}
	
	
}