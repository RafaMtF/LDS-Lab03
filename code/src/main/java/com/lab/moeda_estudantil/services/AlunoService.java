package com.lab.moeda_estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.moeda_estudantil.models.Aluno;
import com.lab.moeda_estudantil.repositories.AlunoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Aluno createAluno(Aluno aluno) {
        if (alunoRepository.findByCpf(aluno.getCpf()) != null) {
            throw new RuntimeException("Aluno já cadastrado");
        }
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno updateAluno(Aluno aluno) {
        if (aluno.getId() == null) {
            throw new RuntimeException("Id não informado");
        }
        return alunoRepository.save(aluno);
    }

    @Transactional
    public void deleteAluno(Long id) {
        if (findById(id) == null) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }

}
