package com.fluxafinance.api.transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller REST para Transações
* - Controller recebe requisições HTTP do frontend e converte para chamadas de Service.
 * - A lógica de validação e regras não deve ficar aqui: controller deve ser fino (mapeamento e status HTTP).
 */
@RestController
@RequestMapping("/api/transactions")
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    /**
     * Endpoint para criar uma transação.
     * - Recebe um DTO (TransacaoRequest) contendo os dados necessários.
     * - Constrói a entidade Transacao com os campos recebidos e delega ao service.
     * - Retorna 201 Created com o DTO de resposta (TransacaoResponse).
     */
    @PostMapping
    public ResponseEntity<TransacaoResponse> create(@RequestBody TransacaoRequest request) {
        Transacao t = new Transacao();
        t.setTipo(request.getTipo());
        t.setValor(request.getValor());
        t.setDescricao(request.getDescricao());
        t.setDataVencimento(request.getDataVencimento());
        t.setDataPagamento(request.getDataPagamento());

        // O service faz validações/associações e atualiza saldo se necessário
        Transacao saved = transacaoService.cadastrar(t, request.getContaId(), request.getCategoriaId());

        TransacaoResponse resp = toResponse(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    /**
     * Endpoint para listar transações por conta e opcionalmente por status.
     * - Usa query params: ?contaId=1[&status=PAGA]
     * - Retorna lista de TransacaoResponse.
     */
    @GetMapping
    public ResponseEntity<List<TransacaoResponse>> listByConta(@RequestParam Long contaId, @RequestParam(required = false) StatusTransacao status) {
        List<Transacao> list;
        if (status == null) {
            list = transacaoService.listarPorConta(contaId);
        } else {
            list = transacaoService.listarPorContaEStatus(contaId, status);
        }
        List<TransacaoResponse> resp = list.stream().map(this::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    /**
     * Buscar transação por id
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransacaoResponse> getById(@PathVariable Long id) {
        Transacao t = transacaoService.buscarPorId(id);
        return ResponseEntity.ok(toResponse(t));
    }

    // Converte entidade para DTO de resposta. Separar mapeamento em um Mapper é recomendável
    private TransacaoResponse toResponse(Transacao t) {
        TransacaoResponse r = new TransacaoResponse();
        r.setId(t.getIdTransacao());
        r.setTipo(t.getTipo());
        r.setStatus(t.getStatus());
        r.setValor(t.getValor());
        r.setDescricao(t.getDescricao());
        r.setDataVencimento(t.getDataVencimento());
        r.setDataPagamento(t.getDataPagamento());
        r.setContaId(t.getConta() != null ? t.getConta().getId() : null);
        r.setCategoriaId(t.getCategoria() != null ? t.getCategoria().getId() : null);
        r.setCriadaEm(t.getCriadaEm());
        r.setAtualizadaEm(t.getAtualizadaEm());
        return r;
    }
}