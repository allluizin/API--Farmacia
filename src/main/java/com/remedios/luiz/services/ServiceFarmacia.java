package com.remedios.luiz.services;

import com.remedios.luiz.dtos.FarmaciaDTO;
import com.remedios.luiz.entities.FarmaciaEntity;
import com.remedios.luiz.forms.FarmaciaAtualizarForm;
import com.remedios.luiz.forms.FarmaciaForm;
import com.remedios.luiz.repositories.FarmaciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFarmacia {
    private final FarmaciaRepository farmaciaRepository;

    public ServiceFarmacia(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }

    public FarmaciaEntity criar(FarmaciaForm farmaciaForm){
        return farmaciaRepository.save(new FarmaciaEntity(farmaciaForm));
    }
    public List<FarmaciaEntity> listar(){
        return farmaciaRepository.findAll();
    }
    //procurar por id
    public FarmaciaEntity procurarPorId(Long id){
        return farmaciaRepository.findById(id).orElse(null);
    }
    public FarmaciaEntity atualizar(Long id, FarmaciaAtualizarForm farmaciaAtualizarForm){
        final var farmacia = procurarPorId(id);
        farmacia.atualizarFarmacia(farmaciaAtualizarForm);
        return farmaciaRepository.save(farmacia);
    }
    public void deletar(Long id){
        farmaciaRepository.deleteById(id);
    }

}
