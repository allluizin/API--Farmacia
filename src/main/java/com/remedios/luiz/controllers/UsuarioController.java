package com.remedios.luiz.controllers;

import com.remedios.luiz.dtos.UserDTO;
import com.remedios.luiz.entities.UsuarioEntity;
import com.remedios.luiz.forms.UserForm;
import com.remedios.luiz.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid UserForm user){
        userRepository.save(new UsuarioEntity(user));
    }
    @GetMapping
    public List<UserDTO> listar(){
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

}
