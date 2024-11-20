package com.algaworks.cursojavaee.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.CalculadoraPreco;

@Named("meuBean")
@SessionScoped
public class PrecoProdutoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CalculadoraPreco calculadoraPreco;
	
	@PostConstruct
	public void init() {
		System.out.println("Init PrecoProdutoBean");
	}
	
	
	public double getPreco() {
		return calculadoraPreco.calcularPreco(12, 10.50);
	}
}
