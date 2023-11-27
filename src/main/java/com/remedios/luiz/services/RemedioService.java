package com.remedios.luiz.services;

import com.remedios.luiz.entities.RemedioEntity;
import com.remedios.luiz.forms.RemedioForm;
import com.remedios.luiz.repositories.RemedioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedioService {

    private final RemedioRepository remedioRepository;

    public RemedioService(RemedioRepository remedioRepository) {

        this.remedioRepository = remedioRepository;
    }

    public RemedioEntity criar(RemedioForm remedioForm){
        return remedioRepository.save(new RemedioEntity(remedioForm));
    }

    public List<RemedioEntity> listar(){
        return remedioRepository.findAll();
    }

    public RemedioEntity buscarPorId(Long id){
        return remedioRepository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        remedioRepository.deleteById(id);
    }

    public RemedioEntity atualizar(Long id, RemedioForm form){
        final var remedio = buscarPorId(id);
        remedio.update(form);
        return remedioRepository.save(remedio);
    }
}
