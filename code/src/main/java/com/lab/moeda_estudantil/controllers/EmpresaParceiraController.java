package com.lab.moeda_estudantil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.moeda_estudantil.models.EmpresaParceira;
import com.lab.moeda_estudantil.services.EmpresaParceiraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Empresa Parceira")
@RestController
@RequestMapping("/empresa-parceira")
public class EmpresaParceiraController {

    @Autowired
    private EmpresaParceiraService empresaParceiraService;

    @Operation(summary = "Get all partner companies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of partner companies returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error") 
        }
    )
    @GetMapping
    public ResponseEntity<?> getEmpresasParceiras() {
        return ResponseEntity.ok().body(empresaParceiraService.findAll());
    }

    @Operation(summary = "Get partner company by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Partner company returned"),
            @ApiResponse(responseCode = "404", description = "Partner company not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error") 
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpresaParceiraById(@PathVariable Long id) {
        return ResponseEntity.ok().body(empresaParceiraService.findById(id));
    }

    @Operation(summary = "Get partner company by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Partner company returned"),
            @ApiResponse(responseCode = "404", description = "Partner company not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error") 
        }
    )
    @GetMapping("/{nome}")
    public ResponseEntity<?> getEmpresaParceiraByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(empresaParceiraService.findByNome(nome));
    }

    @Operation(summary = "Create partner company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Partner company created"),
            @ApiResponse(responseCode = "500", description = "Internal server error") 
        }
    )
    @PostMapping
    public ResponseEntity<?> createEmpresaParceira(@RequestBody EmpresaParceira empresaParceira) {
        return ResponseEntity.ok().body(empresaParceiraService.createEmpresaParceira(empresaParceira));
    }

    @Operation(summary = "Update partner company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Partner company updated"),
            @ApiResponse(responseCode = "404", description = "Partner company not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error") 
        }
    )
    @PutMapping
    public ResponseEntity<?> updateEmpresaParceira(@RequestBody EmpresaParceira empresaParceira) {
        return ResponseEntity.ok().body(empresaParceiraService.updateEmpresaParceira(empresaParceira));
    }

    @Operation(summary = "Delete partner company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Partner company deleted"),
            @ApiResponse(responseCode = "404", description = "Partner company not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error") 
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmpresaParceira(@PathVariable Long id) {
        empresaParceiraService.deleteEmpresaParceira(id);
        return ResponseEntity.ok().build();
    }


}
