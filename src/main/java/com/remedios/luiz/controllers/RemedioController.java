package com.remedios.luiz.controllers;

import com.remedios.luiz.dtos.RemedioDTO;
import com.remedios.luiz.forms.RemedioForm;
import com.remedios.luiz.services.RemedioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController//identificar que é spring
@RequestMapping("/remedios")//mapeamento
public class RemedioController {


    //todos os metodos pode ser utilizado aqui
    private final RemedioService remedioService;

    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }

    @PostMapping//metodo de envio de dados
    @Transactional // fazer com que a transacao seja revertida se tiver algum problema
    public ResponseEntity<RemedioDTO> cadastrar(@RequestBody @Valid RemedioForm dados) {
        final var remedio = remedioService.criar(dados);
        final URI uri = URI.create("/remedios/" + remedio.getId());
        return ResponseEntity.created(uri).body(new RemedioDTO(remedio));
    }

    @GetMapping
    public ResponseEntity<List<RemedioDTO>> listar() {
        return ResponseEntity.ok(remedioService.listar().stream().map(RemedioDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemedioDTO> buscarPorId(@PathVariable Long id) {
        final var remedio = remedioService.buscarPorId(id);
        return ResponseEntity.ok(new RemedioDTO(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id){
        remedioService.deletar(id);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RemedioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid RemedioForm dados) {
        final var remedio = remedioService.atualizar(id, dados);
        return ResponseEntity.ok(new RemedioDTO(remedio));
    }
}