package com.lab.moeda_estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.moeda_estudantil.models.InstituicaoEnsino;
import com.lab.moeda_estudantil.repositories.InstituicaoEnsinoRepository;

import jakarta.transaction.Transactional;

@Service
public class InstituicaoEnsinoService {

    @Autowired
    private InstituicaoEnsinoRepository instituicaoEnsinoRepository;

    public List<InstituicaoEnsino> findAll() {
        return instituicaoEnsinoRepository.findAll();
    }

    public InstituicaoEnsino findById(Long id) {
        return instituicaoEnsinoRepository.findById(id).orElse(null);
    }

    public InstituicaoEnsino findByNome(String nome) {
        return instituicaoEnsinoRepository.findByNome(nome);
    }

    @Transactional
    public InstituicaoEnsino createInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
        if ((findById(instituicaoEnsino.getId()) != null)
                || (instituicaoEnsinoRepository.findByNome(instituicaoEnsino.getNome()) != null)) {
            throw new RuntimeException("Instituição de Ensino já cadastrada");
        }
        return instituicaoEnsinoRepository.save(instituicaoEnsino);
    }

    @Transactional
    public InstituicaoEnsino updateInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
        if (instituicaoEnsino.getId() == null) {
            throw new RuntimeException("Id não informado");
        }
        return instituicaoEnsinoRepository.save(instituicaoEnsino);
    }

    @Transactional
    public void deleteInstituicaoEnsino(Long id) {
        if (findById(id) == null) {
            throw new RuntimeException("Instituição de Ensino não encontrada");
        }
        instituicaoEnsinoRepository.deleteById(id);
    }

}
