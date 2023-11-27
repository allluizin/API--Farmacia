package com.remedios.luiz.controllers;

import com.remedios.luiz.dtos.FarmaciaDTO;
import com.remedios.luiz.entities.FarmaciaEntity;
import com.remedios.luiz.forms.FarmaciaAtualizarForm;
import com.remedios.luiz.forms.FarmaciaForm;
import com.remedios.luiz.services.ServiceFarmacia;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

    private final ServiceFarmacia serviceFarmacia;

    public FarmaciaController(ServiceFarmacia serviceFarmacia) {
        this.serviceFarmacia = serviceFarmacia;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FarmaciaDTO> criar(@RequestBody @Valid FarmaciaForm farmaciaForm){
        final var farmacia = serviceFarmacia.criar(farmaciaForm);
        final URI uri = URI.create("/farmacia/"+ farmacia.getId());
        return ResponseEntity.created(uri).body(new FarmaciaDTO(farmacia));
    }
    @GetMapping
    public ResponseEntity<List<FarmaciaDTO>> listar(){
        return ResponseEntity.ok(serviceFarmacia.listar().stream().map(FarmaciaDTO::new).toList());
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FarmaciaDTO> atualizar(@PathVariable long id, @RequestBody FarmaciaAtualizarForm farmaciaAtualizarForm){
        final var farmacia = serviceFarmacia.atualizar(id, farmaciaAtualizarForm);
        return ResponseEntity.ok(new FarmaciaDTO(farmacia));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        serviceFarmacia.deletar(id);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
