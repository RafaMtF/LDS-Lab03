package com.lab.moeda_estudantil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.Aluno;
import com.lab.moeda_estudantil.models.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
    List<Cupom> findByAluno(Aluno aluno);
}