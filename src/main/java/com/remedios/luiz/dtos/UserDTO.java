package com.remedios.luiz.dtos;

import com.remedios.luiz.entities.UsuarioEntity;
import com.remedios.luiz.enums.SexoEnum;

public record UserDTO(

        String nome,
        int idade,
        SexoEnum sexo
) {
    public UserDTO(UsuarioEntity usuarioEntity){
        this(usuarioEntity.getNome(), usuarioEntity.getIdade(), usuarioEntity.getSexo());
    }

}
