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

    // TODOFuturamente para envio de e-mail
    // @Autowired
    // private EmailService emailService; // Serviço de email fictício para
    // notificação

    public void enviarMoedas(Transacao transacao) {
        Professor professor = professorRepository.findById(transacao.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Aluno aluno = alunoRepository.findById(transacao.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (professor.getSaldo() < transacao.getQuantidadeMoedas()) {
            throw new RuntimeException("Saldo insuficiente para enviar moedas");
        }

        professor.setSaldo(professor.getSaldo() - transacao.getQuantidadeMoedas());
        aluno.setSaldo(aluno.getSaldo() + transacao.getQuantidadeMoedas());

        transacao.setDataHora(LocalDateTime.now());

        transacaoRepository.save(transacao);

        // TODOEnvia notificação ao aluno
        // emailService.enviarNotificacaoRecebimentoMoedas(aluno.getEmail(), quantidade,
        // motivo);
    }
}
