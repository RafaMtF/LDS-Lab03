package com.lab.moeda_estudantil.controllers;

import com.lab.moeda_estudantil.models.Aluno;
import com.lab.moeda_estudantil.services.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Aluno")
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    
    @Operation(summary = "Get all students")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "List of students returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping
    public ResponseEntity<?> getAlunos() {
        return ResponseEntity.ok().body(alunoService.findAll());
    }

    @Operation(summary = "Get student by id")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Student returned"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getAlunoById(Long id) {
        Aluno aluno = alunoService.findById(id);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(aluno);
    }

    @Operation(summary = "Create student")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201", description = "Student created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping
    public ResponseEntity<?> createAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.createAluno(aluno));
    }

    @Operation(summary = "Update student")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Student updated"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PutMapping
    public ResponseEntity<?> updateAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok().body(alunoService.updateAluno(aluno));
    }

    @Operation(summary = "Delete student")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "204", description = "Student deleted"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAluno(Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
    
}
