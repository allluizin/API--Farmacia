package com.remedios.luiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.luiz.remedio.DadosCadastroRemedio;
import com.remedios.luiz.remedio.Remedio;
import com.remedios.luiz.remedio.RemedioRepository;

import jakarta.validation.Valid;

@RestController//identificar que é spring
@RequestMapping("/remedios")//mapeamento
public class RemedioController {
	
	//todos os metodos pode ser utilizado aqui
	@Autowired
	private RemedioRepository repository;
	
	@PostMapping//metodo de envio de dados
	public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
		repository.save(new Remedio(dados));
	}
}