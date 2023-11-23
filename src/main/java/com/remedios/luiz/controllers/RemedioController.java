package com.remedios.luiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.luiz.remedio.DadosCadastroRemedio;
import com.remedios.luiz.remedio.DadosListagemRemedio;
import com.remedios.luiz.remedio.Remedio;
import com.remedios.luiz.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController//identificar que é spring
@RequestMapping("/remedios")//mapeamento
public class RemedioController {
	
	//todos os metodos pode ser utilizado aqui
	@Autowired
	private RemedioRepository repository;
	
	@PostMapping//metodo de envio de dados
	@Transactional // fazer com que a transacao seja revertida se tiver algum problema
	public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
		repository.save(new Remedio(dados));
	}
	
	@GetMapping
	public List<DadosListagemRemedio> listar(){
		return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
	}
}