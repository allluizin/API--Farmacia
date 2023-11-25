package com.remedios.luiz.services;

import com.remedios.luiz.entities.UsuarioEntity;
import com.remedios.luiz.forms.UserForm;
import com.remedios.luiz.forms.UserUpdateForm;
import com.remedios.luiz.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //toda logica de negocio vai aqui dentro

    //service for create new user
    public UsuarioEntity create(UserForm userForm){
        return userRepository.save(new UsuarioEntity(userForm));
    }
    //service for listar
    public List<UsuarioEntity> listar(){
        return userRepository.findAll();
    }
    //service for SearchForId
    public UsuarioEntity searchForId(Long id){
        return userRepository.findById(id).orElse(null);
    }
    //delete
    public void deletar(long id){
        final var usuario = searchForId(id);
        //nao poderia simplesmente mandar um
        //userRepository.deleteById(usuario);
        userRepository.delete(usuario);
    }
    //service for update
    public UsuarioEntity update(Long id, UserUpdateForm form){
        final var usuario = searchForId(id);
        usuario.updateUsers(form);
        return userRepository.save(usuario);
    }

}
