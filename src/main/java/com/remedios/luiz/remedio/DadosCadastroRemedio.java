package com.remedios.luiz.remedio;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRemedio(
		
		@NotBlank//evitar mandar com nome em branco
		String nome,
		@Enumerated//demonstra que isso é um enumeration
		Via via,
		@NotBlank
		String lote,
		
		int quantidade,
		@Future //nao pode colocar validade de ontem
		LocalDate validade,
		@Enumerated
		Laboratorio laboratorio
		) {
	
}
