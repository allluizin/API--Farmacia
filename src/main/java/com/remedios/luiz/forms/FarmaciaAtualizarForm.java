package com.remedios.luiz.forms;

import jakarta.validation.constraints.NotNull;

public record FarmaciaAtualizarForm(
        @NotNull
        Long id,
        String nome,
        String endereco,
        String tipoFarmaciaEnum
) {
}
