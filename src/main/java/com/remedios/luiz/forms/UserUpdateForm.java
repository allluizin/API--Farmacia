package com.remedios.luiz.forms;

import com.remedios.luiz.enums.SexoEnum;
import jakarta.validation.constraints.NotNull;

public record UserUpdateForm(
        @NotNull
        Long id,
        String nome,
        int idade,
        SexoEnum sexo
        ) {
}
