package com.lab.moeda_estudantil.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.moeda_estudantil.models.Cupom;
import com.lab.moeda_estudantil.models.Aluno;
import com.lab.moeda_estudantil.models.Vantagem;
import com.lab.moeda_estudantil.repositories.AlunoRepository;
import com.lab.moeda_estudantil.repositories.CupomRepository;
import com.lab.moeda_estudantil.repositories.VantagemRepository;

@Service
public class CupomService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private VantagemRepository vantagemRepository;

    @Autowired
    private CupomRepository cupomRepository;

    public Cupom resgatarVantagem(Long alunoId, Long vantagemId) {
        // Buscar o aluno
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // Buscar a vantagem
        Vantagem vantagem = vantagemRepository.findById(vantagemId)
                .orElseThrow(() -> new RuntimeException("Vantagem não encontrada"));

        // Verificar saldo suficiente
        if (aluno.getSaldo() < vantagem.getCustoMoedas()) {
            throw new RuntimeException("Saldo insuficiente para resgatar a vantagem");
        }

        // Deduzir o saldo
        aluno.setSaldo(aluno.getSaldo() - vantagem.getCustoMoedas());
        alunoRepository.save(aluno);

        // Gerar código do cupom
        String codigoCupom = UUID.randomUUID().toString();

        // Criar e salvar o cupom
        Cupom cupom = new Cupom();
        cupom.setCodigo(codigoCupom);
        cupom.setVantagem(vantagem);
        cupom.setAluno(aluno);

        return cupomRepository.save(cupom);
    }

    public List<Cupom> getAllCupons() {
        return cupomRepository.findAll();
    }

    public List<Cupom> getCuponsByAlunoId(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    
        return cupomRepository.findByAluno(aluno);
    }
}

