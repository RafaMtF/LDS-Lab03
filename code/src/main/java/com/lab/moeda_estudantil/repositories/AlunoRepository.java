package com.lab.moeda_estudantil.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @SuppressWarnings("null")
    Optional<Aluno> findById(Long id);

    Aluno findByCpf(String cpf);

}
