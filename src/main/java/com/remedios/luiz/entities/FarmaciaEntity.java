package com.remedios.luiz.entities;

import com.remedios.luiz.enums.TipoFarmaciaEnum;
import com.remedios.luiz.forms.FarmaciaAtualizarForm;
import com.remedios.luiz.forms.FarmaciaForm;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "farmacia")
public class FarmaciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String endereco;

    @Enumerated(EnumType.STRING)
    private TipoFarmaciaEnum tipoFarmaciaEnum;

    public FarmaciaEntity(){}

    public FarmaciaEntity(Long id, String nome, String endereco, TipoFarmaciaEnum tipoFarmaciaEnum) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoFarmaciaEnum = tipoFarmaciaEnum;
    }

    public FarmaciaEntity(FarmaciaForm farmaciaForm) {
        this.nome=farmaciaForm.nome();
        this.endereco=farmaciaForm.endereco();
        this.tipoFarmaciaEnum=farmaciaForm.tipoFarmaciaEnum();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoFarmaciaEnum getTipoProdutoEnum() {
        return tipoFarmaciaEnum;
    }

    public void setTipoProdutoEnum(TipoFarmaciaEnum tipoFarmaciaEnum) {
        this.tipoFarmaciaEnum = tipoFarmaciaEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarmaciaEntity that = (FarmaciaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void atualizarFarmacia(FarmaciaAtualizarForm farmaciaAtualizarForm) {
        if(farmaciaAtualizarForm.nome() != null){
            this.nome = farmaciaAtualizarForm.nome();
        }
        if (farmaciaAtualizarForm.endereco() != null){
            this.endereco = farmaciaAtualizarForm.endereco();
        }
    }
}
