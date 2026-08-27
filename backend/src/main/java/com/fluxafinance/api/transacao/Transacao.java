package com.fluxafinance.api.transacao;

import com.fluxafinance.api.categoria.Categoria;
import com.fluxafinance.api.conta.Conta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidade Transacao
 * Representa um lançamento financeiro (receita ou despesa) associado a uma conta e a uma categoria.
 *
 * Explicação simples:
 * - Em um sistema financeiro, uma transação é um registro de movimento de dinheiro.
 * - Aqui guardamos tipo (RECEITA/DESPESA), status (PENDENTE/PAGA/CANCELADA), valor, datas e referência a conta/categoria.
 * - A entidade é apenas um 'modelo' / 'registro' — comportamento (ex.: atualizar saldo da conta) fica em TransacaoService.
 */
@Entity
@Table(name = "transacao")
public class Transacao {
    // Chave primária da transação
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Long idTransacao;

    // Tipo da transação: RECEITA (entrada) ou DESPESA (saída)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransacao tipo;

    // Status do lançamento: pendente, paga, cancelada
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTransacao status;

    // Descrição livre para o usuário entender do que se trata
    @Column(length = 255)
    private String descricao;

    // Valor monetário da transação. BigDecimal evita erros de precisão.
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal valor;

    // Indica se o registro está ativo (para soft-delete)
    @Column(nullable = false)
    private Boolean ativo;

    // Data em que a transação foi efetivamente paga/recebida (pode ser nula para pendente)
    private LocalDate dataPagamento;

    // Data de vencimento ou competência da transação
    @Column(nullable = false)
    private LocalDate dataVencimento;

    // Auditoria simples: quando foi criada (não atualizável)
    @Column(nullable = false, updatable = false)
    private LocalDateTime criadaEm;

    // Auditoria: última atualização
    @Column(nullable = false)
    private LocalDateTime atualizadaEm;

    // Relacionamento ManyToOne para Conta (muitas transações podem pertencer a uma conta)
    // FetchType.LAZY evita carregar a conta automaticamente ao buscar a transação; melhora performance.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    // Transação possui uma categoria para classificação (ex.: "Infraestrutura", "Salários")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // --- getters e setters ---
    // A entidade expõe acesso ao estado. Regras como validação e atualizações de saldo
    // ficam nos Services para manter separação de responsabilidades.

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDateTime criadaEm) {
        this.criadaEm = criadaEm;
    }

    public LocalDateTime getAtualizadaEm() {
        return atualizadaEm;
    }

    public void setAtualizadaEm(LocalDateTime atualizadaEm) {
        this.atualizadaEm = atualizadaEm;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    // Transação pertence a uma conta
}

