package com.trovil.viavarejo.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.trovil.viavarejo.entitys.Compra;
import com.trovil.viavarejo.entitys.Produto;

public class RealizarCompraRequest {
	
	@JsonAlias(value = "produto")
	private ProdutoRequest produtoRequest;
	
	@JsonAlias(value = "condicaoPagamento")
	private CondicaoPagamentoRequest condicaoPagamentoRequest;

	
	

}
