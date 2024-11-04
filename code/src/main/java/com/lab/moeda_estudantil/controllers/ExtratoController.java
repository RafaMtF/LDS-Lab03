package com.lab.moeda_estudantil.controllers;

import com.lab.moeda_estudantil.models.Transacao;
import com.lab.moeda_estudantil.services.ExtratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/extrato")
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Transacao>> consultarExtratoProfessor(@PathVariable Long professorId) {
        List<Transacao> extrato = extratoService.consultarExtratoProfessor(professorId);
        return ResponseEntity.ok(extrato);
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Transacao>> consultarExtratoAluno(@PathVariable Long alunoId) {
        List<Transacao> extrato = extratoService.consultarExtratoAluno(alunoId);
        return ResponseEntity.ok(extrato);
    }
}