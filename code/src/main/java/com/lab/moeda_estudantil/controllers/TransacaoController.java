package com.lab.moeda_estudantil.controllers;

import com.lab.moeda_estudantil.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarMoedas(
            @RequestParam Long professorId,
            @RequestParam Long alunoId,
            @RequestParam Integer quantidade,
            @RequestParam String motivo) {
        try {
            transacaoService.enviarMoedas(professorId, alunoId, quantidade, motivo);
            return ResponseEntity.ok("Moedas enviadas com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}