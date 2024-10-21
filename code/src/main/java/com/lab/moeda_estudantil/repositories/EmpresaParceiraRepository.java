package com.lab.moeda_estudantil.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.EmpresaParceira;

@Repository
public interface EmpresaParceiraRepository extends JpaRepository<EmpresaParceira, Long> {
    
    @SuppressWarnings("null")
    Optional<EmpresaParceira> findById(Long id);

    EmpresaParceira findByNome(String nome);
    
}
