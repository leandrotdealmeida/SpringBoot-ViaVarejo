package com.trovil.viavarejo.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TaxaSelicDia {
	
	private String data;
	@JsonAlias(value = "valor")
	private Double taxaSelic;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getTaxaSelic() {
		return taxaSelic;
	}

	public void setTaxaSelic(Double taxaSelic) {
		this.taxaSelic = taxaSelic;
	}

}
