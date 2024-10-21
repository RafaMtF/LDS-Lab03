package com.lab.moeda_estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.moeda_estudantil.models.Professor;
import com.lab.moeda_estudantil.repositories.ProfessorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Transactional
    public Professor addMoedasMensal(Long id) {
        Professor professor = findById(id);
        if (professor == null) {
            throw new RuntimeException("Professor não encontrado");
        }
        professor.setMoedas(professor.getMoedas() + 1000);
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor createProfessor(Professor professor) {
        if (findById(professor.getId()) != null) {
            throw new RuntimeException("Professor já cadastrado");
        }
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor updateProfessor(Professor professor) {
        if (professor.getId() == null) {
            throw new RuntimeException("Id não informado");
        }
        return professorRepository.save(professor);
    }

    @Transactional
    public void deleteProfessor(Long id) {
        if (findById(id) == null) {
            throw new RuntimeException("Professor não encontrado");
        }
        professorRepository.deleteById(id);
    }
}
