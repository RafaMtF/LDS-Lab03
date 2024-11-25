package com.lab.moeda_estudantil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lab.moeda_estudantil.models.Cupom;
import com.lab.moeda_estudantil.services.CupomService;

@RestController
@RequestMapping("/api/cupons")
public class CupomController {

    @Autowired
    private CupomService cupomService;

    @PostMapping("/resgatar")
    public ResponseEntity<Cupom> resgatarVantagem(@RequestBody CorpoResgate corpoResgate) {
        Cupom cupom = cupomService.resgatarVantagem(corpoResgate.getAlunoId(), corpoResgate.getVantagemId());
        return ResponseEntity.ok(cupom);
    }

    @GetMapping
    public ResponseEntity<List<Cupom>> getAllCupons() {
        List<Cupom> cupons = cupomService.getAllCupons();
        return ResponseEntity.ok(cupons);
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Cupom>> getCuponsByAlunoId(@PathVariable Long alunoId) {
        List<Cupom> cupons = cupomService.getCuponsByAlunoId(alunoId);
        return ResponseEntity.ok(cupons);
    }
}

class CorpoResgate {
    private Long alunoId;
    private Long vantagemId;

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getVantagemId() {
        return vantagemId;
    }

    public void setVantagemId(Long vantagemId) {
        this.vantagemId = vantagemId;
    }
}
