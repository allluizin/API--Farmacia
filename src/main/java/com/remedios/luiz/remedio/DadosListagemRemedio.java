package com.remedios.luiz.remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

	public DadosListagemRemedio(Remedio remedio) {
		//esse this chama o proprio construtor do record
		this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
	}
	
}
