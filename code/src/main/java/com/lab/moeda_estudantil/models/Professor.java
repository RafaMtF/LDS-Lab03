package com.lab.moeda_estudantil.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Pattern(regexp = "\\d{2}[0-9]\\.\\d{2}[0-9]\\.\\d{2}[0-9]-\\d{1}[0-9]")
    private String cpf;

    private String departamento;

    private Long saldo = 0L;

    private String nomeInstituicao;

}
