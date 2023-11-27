package com.remedios.luiz.dtos;

import com.remedios.luiz.entities.FarmaciaEntity;
import com.remedios.luiz.enums.TipoFarmaciaEnum;
import com.remedios.luiz.forms.FarmaciaForm;
import jakarta.validation.Valid;

public record FarmaciaDTO(
        long id,
        String nome,
        String endereco,
        TipoFarmaciaEnum tipoFarmaciaEnum
) {
    public FarmaciaDTO(@Valid FarmaciaEntity farmacia) {
        this(farmacia.getId(), farmacia.getNome(), farmacia.getEndereco(), farmacia.getTipoProdutoEnum());
    }
}
