package com.lab.moeda_estudantil.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @SuppressWarnings("null")
    Optional<Professor> findById(Long id);

}
