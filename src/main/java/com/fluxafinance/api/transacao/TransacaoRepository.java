package com.fluxafinance.api.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository, pois cada um (conta, transacao) precisa de uma porta própria para acessar
// os dados do banco
public interface TransacaoRepository
        extends JpaRepository<Transacao, Long> {

    List<Transacao> findByContaId(Long contaId);

    List<Transacao> findByContaIdAndStatus(
            Long contId,
            StatusTransacao status
    );

}