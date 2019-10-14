package com.trovil.viavarejo.controller.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trovil.viavarejo.entitys.Compra;
import com.trovil.viavarejo.entitys.Parcela;
import com.trovil.viavarejo.vo.TaxaSelicDia;

@Service
public class CompraService {

	@Autowired
	private BuscadorTaixaSelic buscadorTaxaSelic;

	public List<Parcela> realizarCompra(Compra compra) {

		return isCompraSemJuros(compra) ? gerarListaSemJuros(compra) : gerarListaComJuros(compra);

	}

	private List<Parcela> gerarListaComJuros(Compra compra) {
		List<Parcela> parcelas = new ArrayList<>();
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String antes = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		List<TaxaSelicDia> taxas = buscadorTaxaSelic.buscar("Json", antes, hoje);
		
		 BigDecimal taxaSelicAcumulada = new BigDecimal(taxas.stream().mapToDouble(TaxaSelicDia::getTaxaSelic).sum());
				
		//BigDecimal taxaSelic = buscadorTaxaSelic.buscar(formato, dataInicial, dataFinal);
				
		Integer quantidadeParcelas = compra.getCondicaoPagamento().getQuantidadeParcelas();

		BigDecimal valorTotal = compra.getProduto().getValue();

		BigDecimal valorEntrada = compra.getCondicaoPagamento().getValorEntrada();

		BigDecimal valorParcela = valorTotal.subtract(valorEntrada).divide(new BigDecimal(quantidadeParcelas), 2,
				RoundingMode.HALF_EVEN);

		BigDecimal valorJuros = valorTotal.subtract(valorEntrada)
				.multiply((taxaSelicAcumulada).divide(new BigDecimal(100)));

		BigDecimal valorParcelaComJuros = valorParcela.add(valorJuros);

		System.out.println("Valor Com Juros:" + valorParcelaComJuros);
		System.out.println("Valor Juros:" + valorJuros);

		for (int i = 0; i < quantidadeParcelas; i++) {
			parcelas.add(
					new Parcela(i + 1, valorParcelaComJuros.setScale(2, RoundingMode.HALF_EVEN), taxaSelicAcumulada));
		}

		return parcelas;
	}

	private List<Parcela> gerarListaSemJuros(Compra compra) {
		List<Parcela> parcelas = new ArrayList<>();

		Integer quantidadeParcelas = compra.getCondicaoPagamento().getQuantidadeParcelas();

		BigDecimal valorParcela = compra.getProduto().getValue()
				.subtract(compra.getCondicaoPagamento().getValorEntrada())
				.divide(new BigDecimal(quantidadeParcelas), 2, RoundingMode.HALF_EVEN);

		for (int i = 0; i < quantidadeParcelas; i++) {
			parcelas.add(new Parcela(i + 1, valorParcela, new BigDecimal(0)));
		}

		return parcelas;
	}

	private boolean isCompraSemJuros(Compra compra) {
		return compra.getCondicaoPagamento().getQuantidadeParcelas() <= 6;
	}

}
