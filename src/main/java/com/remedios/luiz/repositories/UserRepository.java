package com.remedios.luiz.repositories;

import com.remedios.luiz.controllers.UsuarioController;
import com.remedios.luiz.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsuarioEntity, Long> {
}
