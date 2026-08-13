package com.fluxafinance.api.empresa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.*;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String CNPJ;

    private String endereco_empresa;

    private boolean ativo;

    private LocalDate data_cadastro;
}
