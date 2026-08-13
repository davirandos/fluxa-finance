package com.fluxafinance.api.transacao;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Long idTransacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransacao tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTransacao status;

    @Column(length = 255)
    private String descricao;

    @Column(length = 255)
    private String observacao;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private Boolean ativo;

    private LocalDate dataPagamento;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    @Column(nullable = false, updatable = false)
    private LocalDateTime criadaEm;

    @Column(nullable = false)
    private LocalDateTime atualizadaEm;

}

