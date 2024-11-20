package com.algaworks.cursojavaee.service;

public class MensageiroCorreio implements Mensageiro{

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println("Enviando mensagem por correio: " + mensagem);
	}

}
