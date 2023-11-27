package com.remedios.luiz.forms;

import com.remedios.luiz.enums.SexoEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank
        String nome,
        int idade,
        @Enumerated
        SexoEnum sexo,
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
