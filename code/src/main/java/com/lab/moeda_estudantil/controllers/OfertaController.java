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

import com.lab.moeda_estudantil.models.Oferta;
import com.lab.moeda_estudantil.services.OfertaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Oferta")
@RestController
@RequestMapping("/oferta")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @Operation(summary = "Get all offers")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "List of offers returned"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping
    public ResponseEntity<?> getOfertas() {
        return ResponseEntity.ok().body(ofertaService.findAll());
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
    public ResponseEntity<?> getOfertaById(@PathVariable Long id) {
        Oferta oferta = ofertaService.findById(id);
        if (oferta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(oferta);
    }

    @Operation(summary = "Create offer")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Offer created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping
    public ResponseEntity<?> createOferta(@RequestBody Oferta oferta) {
        return ResponseEntity.ok().body(ofertaService.createOferta(oferta));
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
    public ResponseEntity<?> updateOferta(@RequestBody Oferta oferta) {
        return ResponseEntity.ok().body(ofertaService.updateOferta(oferta));
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
    public ResponseEntity<?> deleteOferta(@PathVariable Long id) {
        ofertaService.deleteOferta(id);
        return ResponseEntity.ok().build();
    }

}
