package com.lab.moeda_estudantil.controllers;

import com.lab.moeda_estudantil.models.InstituicaoEnsino;
import com.lab.moeda_estudantil.services.InstituicaoEnsinoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Instituição de Ensino")
@RestController
@RequestMapping("/instituicaoEnsino")
public class InstituicaoEnsinoController {

    @Autowired
    private InstituicaoEnsinoService instituicaoEnsinoService;

    @Operation(summary = "Get all educational institutions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of educational institutions returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<InstituicaoEnsino>> getInstituicoesEnsino() {
        return ResponseEntity.ok().body(instituicaoEnsinoService.findAll());
    }

    @Operation(summary = "Get educational institution by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Educational institution returned"),
            @ApiResponse(responseCode = "404", description = "Educational institution not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoEnsino> getInstituicaoEnsinoById(@PathVariable Long id) {
        InstituicaoEnsino instituicaoEnsino = instituicaoEnsinoService.findById(id);
        if (instituicaoEnsino == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(instituicaoEnsino);
    }

    @Operation(summary = "Get educational institution by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Educational institution returned"),
            @ApiResponse(responseCode = "404", description = "Educational institution not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/nome/{nome}")
    public ResponseEntity<InstituicaoEnsino> getInstituicaoEnsinoByNome(@PathVariable String nome) {
        InstituicaoEnsino instituicaoEnsino = instituicaoEnsinoService.findByNome(nome);
        if (instituicaoEnsino == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(instituicaoEnsino);
    }

    @Operation(summary = "Create educational institution")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Educational institution created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<InstituicaoEnsino> createInstituicaoEnsino(@RequestBody InstituicaoEnsino instituicaoEnsino) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoEnsinoService.createInstituicaoEnsino(instituicaoEnsino));
    }

    @Operation(summary = "Update educational institution")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Educational institution updated"),
            @ApiResponse(responseCode = "404", description = "Educational institution not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping
    public ResponseEntity<InstituicaoEnsino> updateInstituicaoEnsino(@RequestBody InstituicaoEnsino instituicaoEnsino) {
        InstituicaoEnsino instituicaoEnsinoUpdated = instituicaoEnsinoService.updateInstituicaoEnsino(instituicaoEnsino);
        if (instituicaoEnsinoUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(instituicaoEnsinoUpdated);
    }

    @Operation(summary = "Delete educational institution")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Educational institution deleted"),
            @ApiResponse(responseCode = "404", description = "Educational institution not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstituicaoEnsino(@PathVariable Long id) {
        InstituicaoEnsino instituicaoEnsino = instituicaoEnsinoService.findById(id);
        if (instituicaoEnsino == null) {
            return ResponseEntity.notFound().build();
        }
        instituicaoEnsinoService.deleteInstituicaoEnsino(id);
        return ResponseEntity.ok().build();
    }

}
