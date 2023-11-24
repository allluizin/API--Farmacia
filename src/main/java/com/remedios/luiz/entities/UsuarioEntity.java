package com.remedios.luiz.entities;

import com.remedios.luiz.enums.SexoEnum;
import com.remedios.luiz.forms.UserForm;
import com.remedios.luiz.forms.UserUpdateForm;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.hibernate.annotations.IdGeneratorType;

import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private SexoEnum sexo;

    public UsuarioEntity(Long id, String nome, int idade, SexoEnum sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
    public UsuarioEntity(UserForm user){
        this.nome = user.nome();
        this.idade = user.idade();
        this.sexo = user.sexo();
    }
    public UsuarioEntity(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public void updateUsers(@Valid UserUpdateForm user){
        if(user.nome() != null){
            this.nome = user.nome();
        }
        if (user.sexo() != null){
            this.sexo = user.sexo();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
