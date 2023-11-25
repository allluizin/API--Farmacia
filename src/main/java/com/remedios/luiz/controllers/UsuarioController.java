package com.remedios.luiz.controllers;

import com.remedios.luiz.dtos.UserDTO;
import com.remedios.luiz.entities.UsuarioEntity;
import com.remedios.luiz.forms.UserForm;
import com.remedios.luiz.forms.UserUpdateForm;
import com.remedios.luiz.repositories.UserRepository;
import com.remedios.luiz.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
//    @Autowired
//    private UserRepository userRepository;

    private final UserService userService;

    public UsuarioController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> cadastrar(@RequestBody @Valid UserForm user){
        final var usuario = userService.create(user);
        final URI uri = URI.create("/usuarios/"+ usuario.getId());
        return ResponseEntity.created(uri).body(new UserDTO(usuario));
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> listar(){
        return ResponseEntity.ok(userService.listar().stream().map(UserDTO::new).toList());
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDTO> atualizar(@PathVariable long id, @RequestBody @Valid UserUpdateForm user){
        final var usuario = userService.update(id, user);
        return ResponseEntity.ok(new UserDTO(usuario));
//        var usuarioAtualizar = userRepository.getReferenceById(user.id());
//        usuarioAtualizar.updateUsers(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        userService.deletar(id);
        return ResponseEntity.noContent().build();

//        userRepository.deleteById(id);
//        System.out.println("excluido com sucesso");
    }

}
