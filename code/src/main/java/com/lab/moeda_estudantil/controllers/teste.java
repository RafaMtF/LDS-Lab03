package com.lab.moeda_estudantil.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/")
@Tag(name = "Teste", description = "Teste")
public class teste {
    
    @GetMapping("/")
    public String test() {
        return "Teste";
    }
    
}
