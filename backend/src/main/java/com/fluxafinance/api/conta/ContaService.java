package com.fluxafinance.api.conta;

import org.springframework.stereotype.Service;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService (
            ContaRepository contaRepository
    ) {
        this.contaRepository = contaRepository;
    }

    public Conta cadastrar(Conta conta) {
        return contaRepository.save(conta);
    }

    public  Conta buscarPorId(Long id){
        return contaRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Conta não encontrada")
        );
    }
}
