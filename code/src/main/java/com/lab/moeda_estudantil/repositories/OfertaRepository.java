package com.lab.moeda_estudantil.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.moeda_estudantil.models.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    
    @SuppressWarnings("null")
    Optional<Oferta> findById(Long id);

}
