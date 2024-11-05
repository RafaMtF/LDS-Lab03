package com.lab.moeda_estudantil.controllers;

import com.lab.moeda_estudantil.models.Transacao;
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
    public ResponseEntity<?> enviarMoedas(@RequestBody Transacao transacao) {
        try {
            transacaoService.enviarMoedas(transacao);
            return ResponseEntity.ok("Moedas enviadas com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}