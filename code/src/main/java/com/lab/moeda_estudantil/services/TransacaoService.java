package com.lab.moeda_estudantil.services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.moeda_estudantil.models.Aluno;
import com.lab.moeda_estudantil.models.Professor;
import com.lab.moeda_estudantil.models.Transacao;
import com.lab.moeda_estudantil.repositories.AlunoRepository;
import com.lab.moeda_estudantil.repositories.ProfessorRepository;
import com.lab.moeda_estudantil.repositories.TransacaoRepository;


@Service
public class TransacaoService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    //TODOFuturamente para envio de e-mail
    //@Autowired
    //private EmailService emailService; // Serviço de email fictício para notificação

    public void enviarMoedas(Long professorId, Long alunoId, Integer quantidade, String motivo) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (professor.getSaldo() < quantidade) {
            throw new RuntimeException("Saldo insuficiente para enviar moedas");
        }

        professor.setSaldo(professor.getSaldo() - quantidade);
        aluno.setSaldo(aluno.getSaldo() + quantidade);

        Transacao transacao = new Transacao();
        transacao.setProfessorId(professorId);
        transacao.setAlunoId(alunoId);
        transacao.setQuantidadeMoedas(quantidade);
        transacao.setMotivo(motivo);
        transacao.setDataHora(LocalDateTime.now());

        transacaoRepository.save(transacao);

        professorRepository.save(professor);
        alunoRepository.save(aluno);

        // TODOEnvia notificação ao aluno
        //emailService.enviarNotificacaoRecebimentoMoedas(aluno.getEmail(), quantidade, motivo);
    }
}
