package com.lab.moeda_estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.moeda_estudantil.models.Oferta;
import com.lab.moeda_estudantil.repositories.OfertaRepository;

import jakarta.transaction.Transactional;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public List<Oferta> findAll() {
        return ofertaRepository.findAll();
    }

    public Oferta findById(Long id) {
        return ofertaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Oferta createOferta(Oferta oferta) {
        if (findById(oferta.getId()) != null) {
            throw new RuntimeException("Oferta já cadastrada");
        }
        return ofertaRepository.save(oferta);
    }

    @Transactional
    public Oferta updateOferta(Oferta oferta) {
        if (oferta.getId() == null) {
            throw new RuntimeException("Id não informado");
        }
        return ofertaRepository.save(oferta);
    }

    @Transactional
    public void deleteOferta(Long id) {
        if (findById(id) == null) {
            throw new RuntimeException("Oferta não encontrada");
        }
        ofertaRepository.deleteById(id);
    }

}
