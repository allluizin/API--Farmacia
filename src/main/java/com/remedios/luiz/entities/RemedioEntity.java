package com.remedios.luiz.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.remedios.luiz.forms.RemedioForm;
import com.remedios.luiz.enums.LaboratorioEnum;
import com.remedios.luiz.enums.ViaEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

//anotacoes do jpa
@Entity(name = "remedios")
@Table(name = "Remedio")
@EqualsAndHashCode(of = "id")
public class RemedioEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	@Enumerated(EnumType.STRING) //este atributo é um enum e tem que ser mapeado pelo jpa
	private ViaEnum via;
	
	private String lote;
	private int quantidade;
	private LocalDate validade;
	
	@Enumerated(EnumType.STRING) //este atributo é um enum e tem que ser mapeado pelo jpa
	private LaboratorioEnum laboratorio;
	public RemedioEntity() {
		//construtor vazio
	}
	public RemedioEntity(String nome, ViaEnum via, String lote, int quantidade, LocalDate validade, LaboratorioEnum laboratorio){
		this.nome = nome;
		this.via = via;
		this.lote = lote;
		this.quantidade = quantidade;
		this.validade = validade;
		this.laboratorio = laboratorio;
	}
	
	public RemedioEntity(RemedioForm dados) {
		this.nome = dados.nome();
		this.laboratorio = dados.laboratorioEnum();
		this.via = dados.viaEnum();
		this.lote = dados.lote();
		this.quantidade = dados.quantidade();
		this.validade = dados.validade();
	}

	public void update(RemedioForm dados){
		this.nome = dados.nome();
		this.laboratorio = dados.laboratorioEnum();
		this.via = dados.viaEnum();
		this.lote = dados.lote();
		this.quantidade = dados.quantidade();
		this.validade = dados.validade();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ViaEnum getVia() {
		return via;
	}
	public LaboratorioEnum getLaboratorio() {
		return laboratorio;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemedioEntity other = (RemedioEntity) obj;
		return Objects.equals(id, other.id);
	}
}
