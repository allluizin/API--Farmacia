package com.remedios.luiz.remedio;

import java.time.LocalDate;
import java.util.Objects;

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
public class Remedio {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
		Remedio other = (Remedio) obj;
		return Objects.equals(id, other.id);
	}

	private String nome;
	
	@Enumerated(EnumType.STRING) //este atributo é um enum e tem que ser mapeado pelo jpa
	private Via via;
	
	private String lote;
	private int quantidade;
	private LocalDate validade;
	
	@Enumerated(EnumType.STRING) //este atributo é um enum e tem que ser mapeado pelo jpa
	private Laboratorio laboratorio;
	public Remedio() {
		//construtor vazio
	}
	public Remedio(String nome, Via via, String lote, int quantidade, LocalDate validade, Laboratorio laboratorio){
		this.nome = nome;
		this.via = via;
		this.lote = lote;
		this.quantidade = quantidade;
		this.validade = validade;
		this.laboratorio = laboratorio;
	}
	
	public Remedio(DadosCadastroRemedio dados) {
		this.nome = dados.nome();
		this.laboratorio = dados.laboratorio();
		this.via = dados.via();
		this.lote = dados.lote();
		this.quantidade = dados.quantidade();
		this.validade = dados.validade();
		
	}
	public Via getVia() {
		return via;
	}
	public Laboratorio getLaboratorio() {
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
}
