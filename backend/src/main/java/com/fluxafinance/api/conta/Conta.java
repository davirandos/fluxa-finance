package com.fluxafinance.api.conta;

import com.fluxafinance.api.conta.TipoConta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity

// Define o nome da tabela
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConta tipo;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal saldo;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(name = "data_criada", nullable = false)
    private LocalDateTime dataCriada;
}