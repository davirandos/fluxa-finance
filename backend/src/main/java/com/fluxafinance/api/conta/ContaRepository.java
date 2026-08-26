package com.fluxafinance.api.conta;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository, pois cada um (conta, transacao) precisa de uma porta própria para acessar
// os dados do banco
public interface ContaRepository
        extends JpaRepository<Conta, Long> {
}
