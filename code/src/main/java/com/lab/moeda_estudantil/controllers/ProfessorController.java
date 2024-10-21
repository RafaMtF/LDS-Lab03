package com.lab.moeda_estudantil.controllers;

import com.lab.moeda_estudantil.models.Professor;
import com.lab.moeda_estudantil.services.ProfessorService;

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

@Tag(name = "Professor")
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @Operation(summary = "Get all professors")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "List of professors returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping
    public ResponseEntity<List<Professor>> getProfessors() {
        return ResponseEntity.ok().body(professorService.findAll());
    }

    @Operation(summary = "Get professor by id")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Professor returned"),
            @ApiResponse(responseCode = "404", description = "Professor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Professor professor = professorService.findById(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(professor);
    }

    @Operation(summary = "Create professor")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201", description = "Professor created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.createProfessor(professor));
    }

    @Operation(summary = "Update professor")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Professor updated"),
            @ApiResponse(responseCode = "404", description = "Professor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PutMapping
    public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor) {
        Professor updatedProfessor = professorService.updateProfessor(professor);
        if (updatedProfessor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedProfessor);
    }

    @Operation(summary = "Delete professor")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "204", description = "Professor deleted"),
            @ApiResponse(responseCode = "404", description = "Professor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        Professor professor = professorService.findById(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Add monthly coins to professor")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Professor updated"),
            @ApiResponse(responseCode = "404", description = "Professor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PutMapping("/add-moedas-mensal/{id}")
    public ResponseEntity<Professor> addMoedasMensal(@PathVariable Long id) {
        Professor professor = professorService.addMoedasMensal(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(professor);
    }
}
