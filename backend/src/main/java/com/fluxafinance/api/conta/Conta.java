package com.fluxafinance.api.conta;

import com.fluxafinance.api.conta.TipoConta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity

// Define o nome da tabela
@Table(name = "conta")
public class Conta {

    // Identificador único da conta (chave primária no banco)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    // Nome da conta (ex: "Conta Corrente Nubank PJ")
    @Column(nullable = false, length = 255)
    private String nome;

    // Tipo da conta (enum) — usado para diferenciar contas bancárias, caixa, cartão, etc.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConta tipo;

    // Saldo atual da conta. Em sistemas financeiros, é comum usar BigDecimal para evitar erro de ponto flutuante.
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal saldo;

    // Flag para indicar se a conta está ativa (soft-delete / desativação)
    @Column(nullable = false)
    private Boolean ativo;

    // Data de criação do registro para auditoria básica
    @Column(name = "data_criada", nullable = false)
    private LocalDateTime dataCriada;

    // Construtor padrão necessário para JPA/Hibernate criar instâncias da entidade
    public Conta() {
    }

    // Construtor de conveniência usado quando apenas o id é necessário (ex.: referência em outra entidade)
    public Conta(Long id) {
        this.id = id;
    }

    // Getters/Setters seguem — são usados pelo JPA e para mapear dados entre camadas.
    // Mantemos responsabilidades simples: a entidade representa o estado. Lógica de negócio (ex.: cálculo de saldo)
    // deve estar na camada de Service para facilitar testes e garantir consistência.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(LocalDateTime dataCriada) {
        this.dataCriada = dataCriada;
    }
}