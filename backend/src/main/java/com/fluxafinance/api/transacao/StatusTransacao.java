package com.fluxafinance.api.transacao;

public enum StatusTransacao {
    PENDENTE, //foi registrada, mas não foi efetivada
    PAGA,
    CANCELADA //existiu no sistema, mas não deve ser considerada válida
}
