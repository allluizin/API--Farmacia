package com.remedios.luiz.forms;

import java.time.LocalDate;

import com.remedios.luiz.enums.LaboratorioEnum;
import com.remedios.luiz.enums.ViaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record RemedioForm(
		
		@NotBlank//evitar mandar com nome em branco
		String nome,
		@Enumerated//demonstra que isso é um enumeration
		ViaEnum viaEnum,
		@NotBlank
		String lote,
		
		int quantidade,
		@Future //nao pode colocar validade de ontem
		LocalDate validade,
		@Enumerated
		LaboratorioEnum laboratorioEnum
		) {
	
}
