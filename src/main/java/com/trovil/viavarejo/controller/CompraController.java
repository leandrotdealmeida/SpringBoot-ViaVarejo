package com.trovil.viavarejo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trovil.viavarejo.controller.services.CompraService;
import com.trovil.viavarejo.entitys.Compra;
import com.trovil.viavarejo.entitys.Parcela;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Compras")
@RestController
@RequestMapping("compras")
public class CompraController {

	@Autowired
	private CompraService compraService;

	@ApiOperation(tags = "Compras", value = "Realizar compra de produto")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Parcela>> realizarCompras(@RequestBody Compra compra) {

		return ResponseEntity.created(null).body(compraService.realizarCompra(compra));

	}

}