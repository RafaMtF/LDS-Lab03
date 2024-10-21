package com.lab.moeda_estudantil.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.InstituicaoEnsino;

@Repository
public interface InstituicaoEnsinoRepository extends JpaRepository<InstituicaoEnsino, Long> {
    
    Optional<InstituicaoEnsino> findById(Long id);

    InstituicaoEnsino findByNome(String nome);
    
}