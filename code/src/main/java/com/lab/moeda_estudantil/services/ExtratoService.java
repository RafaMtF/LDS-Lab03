package com.lab.moeda_estudantil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.moeda_estudantil.models.Transacao;
import com.lab.moeda_estudantil.repositories.TransacaoRepository;
import java.util.List;

@Service
public class ExtratoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> consultarExtratoProfessor(Long professorId) {
        return transacaoRepository.findByProfessorId(professorId);
    }

    public List<Transacao> consultarExtratoAluno(Long alunoId) {
        return transacaoRepository.findByAlunoId(alunoId);
    }
}