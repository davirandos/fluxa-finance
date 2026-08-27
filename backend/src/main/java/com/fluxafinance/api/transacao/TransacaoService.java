package com.fluxafinance.api.transacao;

import com.fluxafinance.api.conta.Conta;
import com.fluxafinance.api.conta.ContaRepository;
import com.fluxafinance.api.categoria.Categoria;
import com.fluxafinance.api.categoria.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * TransacaoService
 *
 * Responsabilidade:
 * - Orquestrar operações relacionadas a transações (criação, leitura, regras de negócio).
 * - Garantir consistência ao atualizar o saldo da conta quando uma transação é marcada como PAGA.
 * - Manter a lógica dentro de uma transação (annotation @Transactional) para rollback automático em caso de erro.
 */
@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    // Repositório de Conta: usado para buscar a conta e atualizar o saldo
    private final ContaRepository contaRepository;

    // Repositório de Categoria: usado apenas para validar se a categoria existe
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

    /**
     * Cadastrar uma transação.
     * Etapas principais:
     * 1) Validar existência de conta e categoria
     * 2) Preencher campos de auditoria (criadaEm/atualizadaEm)
     * 3) Definir status padrão (PAGA se dataPagamento for informada, caso contrário PENDENTE)
     * 4) Salvar a transação
     * 5) Se transação estiver PAGA, atualizar o saldo da conta (adicionar para RECEITA, subtrair para DESPESA)
     *
     * Observações importantes:
     * - Método marcado com @Transactional para garantir que tanto a transação quanto a atualização do saldo
     *   sejam aplicadas de forma atômica; se algo falhar, tudo é revertido.
     * - Em cenários concorrentes, considerar locks/versões para evitar condições de corrida ao atualizar saldo.
     */
    @Transactional
    public Transacao cadastrar(Transacao transacao, Long contaId, Long categoriaId) {
        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        // Associa a transação às entidades relacionadas
        transacao.setConta(conta);
        transacao.setCategoria(categoria);

        // Preenche auditoria
        LocalDateTime now = LocalDateTime.now();
        transacao.setCriadaEm(now);
        transacao.setAtualizadaEm(now);

        // Por padrão mantemos o registro ativo
        if (transacao.getAtivo() == null) transacao.setAtivo(true);

        // Define status padrão com base na presença de dataPagamento
        if (transacao.getStatus() == null) {
            transacao.setStatus(transacao.getDataPagamento() != null ? StatusTransacao.PAGA : StatusTransacao.PENDENTE);
        }

        // Salva o registro da transação
        Transacao saved = transacaoRepository.save(transacao);

        // Se a transação estiver PAGA, atualiza o saldo da conta imediatamente
        if (saved.getStatus() == StatusTransacao.PAGA) {
            BigDecimal valor = saved.getValor();
            if (saved.getTipo() == TipoTransacao.RECEITA) {
                // Para receitas, soma ao saldo
                conta.setSaldo(conta.getSaldo().add(valor));
            } else if (saved.getTipo() == TipoTransacao.DESPESA) {
                // Para despesas, subtrai do saldo
                conta.setSaldo(conta.getSaldo().subtract(valor));
            }
            // Persiste alteração do saldo
            contaRepository.save(conta);
        }

        return saved;
    }

    // Métodos de leitura delegados ao repository — mantemos serviços finos para consultas simples
    public List<Transacao> listarPorConta(Long contaId) {
        return transacaoRepository.findByContaId(contaId);
    }

    public List<Transacao> listarPorContaEStatus(Long contaId, StatusTransacao status) {
        return transacaoRepository.findByContaIdAndStatus(contaId, status);
    }

    public Transacao buscarPorId(Long id) {
        return transacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }
}
