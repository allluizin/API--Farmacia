package com.remedios.luiz.forms;

import com.remedios.luiz.enums.SexoEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank
        String nome,
        @Min(18)
        int idade,
        @Enumerated
        SexoEnum sexo
) {
}
