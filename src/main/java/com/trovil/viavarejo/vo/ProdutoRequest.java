package com.trovil.viavarejo.vo;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ProdutoRequest {
	
	private Long codigo;
	
	private String nome;
	
	private BigDecimal valor;

}
