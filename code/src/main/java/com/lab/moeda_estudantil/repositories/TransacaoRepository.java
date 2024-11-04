package com.lab.moeda_estudantil.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.moeda_estudantil.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByProfessorId(Long professorId);
    List<Transacao> findByAlunoId(Long alunoId);
}
