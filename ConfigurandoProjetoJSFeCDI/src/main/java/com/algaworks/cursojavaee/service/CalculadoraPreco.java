package com.algaworks.cursojavaee.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CalculadoraPreco implements Serializable{
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		System.out.println("Init CalculadoraPreco");
	}
	
	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
