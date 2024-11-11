package com.lab.moeda_estudantil.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.Vantagem;

@Repository
public interface VantagemRepository extends JpaRepository<Vantagem, Long> {

    @SuppressWarnings("null")
    Optional<Vantagem> findById(Long id);

    List<Vantagem> findAllByIdEmpresaParceira(Long idEmpresaParceira);

    Vantagem findByDescricao(String descricao);

}
