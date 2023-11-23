package com.remedios.luiz.remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

	public DadosListagemRemedio(Remedio remedio) {
		//esse this chama o proprio construtor do record
		this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
	}
	
}
