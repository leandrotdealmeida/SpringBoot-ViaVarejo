package com.trovil.viavarejo.controller.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trovil.viavarejo.vo.TaxaSelicDia;

@FeignClient(name = "gov", url = "https://api.bcb.gov.br")
public interface BuscadorTaixaSelic {

	@GetMapping(path = "/dados/serie/bcdata.sgs.11/dados")
	public List<TaxaSelicDia> buscar(@RequestParam String formato, @RequestParam String dataInicial,
			@RequestParam String dataFinal);

}
