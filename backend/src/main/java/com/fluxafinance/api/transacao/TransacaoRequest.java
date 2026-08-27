package com.fluxafinance.api.transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de requisição para criar/atualizar uma transação.
 *
 * - DTO (Data Transfer Object) é um objeto usado para transportar dados entre a API (controller)
 *   e as camadas internas (service, repository). Evita expor diretamente as entidades JPA.
 * - Aqui colocamos apenas os campos que o cliente (frontend) precisa enviar para criar a transação.
 */
public class TransacaoRequest {
    private TipoTransacao tipo;
    private BigDecimal valor;
    private String descricao;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    // Referências por id para ligar a transação à conta e à categoria
    private Long contaId;
    private Long categoriaId;

    // Getters / setters simples — mais tarde podemos adicionar validações (ex.: @NotNull) nesta classe
    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}