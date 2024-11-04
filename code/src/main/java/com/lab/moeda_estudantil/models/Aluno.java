package com.lab.moeda_estudantil.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Pattern(regexp = "\\d{2}[0-9]\\.\\d{2}[0-9]\\.\\d{2}[0-9]-\\d{1}[0-9]")
    private String cpf;

    private String rg;

    private String endereco;

    private Long saldo = 0L;

    private String nomeInstituicao;
}
