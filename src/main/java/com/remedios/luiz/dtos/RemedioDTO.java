package com.remedios.luiz.dtos;

import com.remedios.luiz.entities.RemedioEntity;
import com.remedios.luiz.enums.LaboratorioEnum;
import com.remedios.luiz.enums.ViaEnum;

import java.time.LocalDate;

public record RemedioDTO(
		Long id,
		String nome,
		ViaEnum viaEnum,
		String lote,
		LaboratorioEnum laboratorioEnum,
		LocalDate validade
) {

	public RemedioDTO(RemedioEntity remedioEntity) {
		//esse this chama o proprio construtor do record
		this(remedioEntity.getId(), remedioEntity.getNome(), remedioEntity.getVia(), remedioEntity.getLote(), remedioEntity.getLaboratorio(), remedioEntity.getValidade());
	}
	
}
