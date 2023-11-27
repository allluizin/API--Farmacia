package com.remedios.luiz.forms;

import com.remedios.luiz.enums.TipoFarmaciaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record FarmaciaForm(
        @NotBlank(message = "nao pode ta em branco")
        String nome,
        @NotBlank(message = "nao pode ta em branco")
        String endereco,
        @Enumerated
        TipoFarmaciaEnum tipoFarmaciaEnum
) {
}
