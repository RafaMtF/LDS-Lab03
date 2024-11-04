package com.lab.moeda_estudantil.repositories;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lab.moeda_estudantil.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByProfessorId(Long professorId);
    List<Transacao> findByAlunoId(Long alunoId);
}
