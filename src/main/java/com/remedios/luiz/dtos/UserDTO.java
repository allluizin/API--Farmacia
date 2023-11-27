package com.remedios.luiz.dtos;

import com.remedios.luiz.entities.UsuarioEntity;
import com.remedios.luiz.enums.SexoEnum;

public record UserDTO(
        Long id,
        String nome,
        int idade,
        SexoEnum sexo,
        String email
) {
    public UserDTO(UsuarioEntity usuarioEntity){
        this(usuarioEntity.getId(), usuarioEntity.getNome(), usuarioEntity.getIdade(), usuarioEntity.getSexo(), usuarioEntity.getEmail());
    }

}
