package com.lab.moeda_estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.moeda_estudantil.models.Vantagem;
import com.lab.moeda_estudantil.repositories.VantagemRepository;

import jakarta.transaction.Transactional;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository VantagemRepository;

    public List<Vantagem> findAll() {
        return VantagemRepository.findAll();
    }

    public Vantagem findById(Long id) {
        return VantagemRepository.findById(id).orElse(null);
    }

    @Transactional
    public Vantagem createVantagem(Vantagem Vantagem) {
        if (findById(Vantagem.getId()) != null) {
            throw new RuntimeException("Vantagem já cadastrada");
        }
        return VantagemRepository.save(Vantagem);
    }

    @Transactional
    public Vantagem updateVantagem(Vantagem Vantagem) {
        if (Vantagem.getId() == null) {
            throw new RuntimeException("Id não informado");
        }
        return VantagemRepository.save(Vantagem);
    }

    @Transactional
    public void deleteVantagem(Long id) {
        if (findById(id) == null) {
            throw new RuntimeException("Vantagem não encontrada");
        }
        VantagemRepository.deleteById(id);
    }

}
