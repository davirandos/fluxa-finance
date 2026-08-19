package com.fluxafinance.api.transacao;

import com.fluxafinance.api.conta.ContaRepository;
import com.fluxafinance.api.categoria.CategoriaRepository;
import org.springframework.stereotype.Service;

// Service, pois usa os repository's para executar a regra de negócio
@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    // Aqui, cadastrar uma transação precisaria buscar a conta e verificar se ela existe
    // e eventualmente atualizar alguma informação da conta
    private final ContaRepository contaRepository;

    // Da mesma forma, transação terá que verificar as categorias e definir uma
    private final CategoriaRepository categoriaRepository;

    public TransacaoService(
            TransacaoRepository transacaoRepository,
            ContaRepository contaRepository,
            CategoriaRepository categoriaRepository
    ) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
        this.categoriaRepository = categoriaRepository;
    }
}
