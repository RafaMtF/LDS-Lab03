package com.lab.moeda_estudantil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.moeda_estudantil.models.Vantagem;
import com.lab.moeda_estudantil.services.VantagemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Vantagem")
@RestController
@RequestMapping("/vantagem")
public class VantagemController {

    @Autowired
    private VantagemService VantagemService;

    @Operation(summary = "Get all offers")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "List of offers returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping
    public ResponseEntity<?> getVantagems() {
        return ResponseEntity.ok().body(VantagemService.findAll());
    }

    @Operation(summary = "Get all active offers")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "List of active offers returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/ativas")
    public ResponseEntity<?> getVantagemsAtivas() {
        return ResponseEntity.ok().body(VantagemService.findAllAtivas());
    }

    @Operation(summary = "Get offer by id")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Offer returned"),
            @ApiResponse(responseCode = "404", description = "Offer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getVantagemById(@PathVariable Long id) {
        Vantagem Vantagem = VantagemService.findById(id);
        if (Vantagem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Vantagem);
    }

    @Operation(summary = "Get offer by partner company id")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Offer returned"),
            @ApiResponse(responseCode = "404", description = "Offer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/empresa/{idEmpresaParceira}")
    public ResponseEntity<?> getVantagemByEmpresaParceiraId(@PathVariable Long idEmpresaParceira) {
        List<Vantagem> Vantagem = VantagemService.findByIdEmpresaParceira(idEmpresaParceira);
        if (Vantagem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Vantagem);
    }

    @Operation(summary = "Create offer")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Offer created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping
    public ResponseEntity<?> createVantagem(@RequestBody Vantagem Vantagem) {
        return ResponseEntity.ok().body(VantagemService.createVantagem(Vantagem));
    }

    @Operation(summary = "Update offer")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Offer updated"),
            @ApiResponse(responseCode = "404", description = "Offer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PutMapping
    public ResponseEntity<?> updateVantagem(@RequestBody Vantagem Vantagem) {
        return ResponseEntity.ok().body(VantagemService.updateVantagem(Vantagem));
    }

    @Operation(summary = "Delete offer")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Offer deleted"),
            @ApiResponse(responseCode = "404", description = "Offer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVantagem(@PathVariable Long id) {
        VantagemService.deleteVantagem(id);
        return ResponseEntity.ok().build();
    }

}
