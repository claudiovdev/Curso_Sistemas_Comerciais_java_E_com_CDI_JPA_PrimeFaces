package com.algaworks.cursojavaee.controller;

import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.CalculadoraPreco;

@Named("meuBean")
public class PrecoProdutoBean {
	
	@Inject
	private CalculadoraPreco calculadoraPreco;
	
	
	public double getPreco() {
		return calculadoraPreco.calcularPreco(12, 10.50);
	}
}
