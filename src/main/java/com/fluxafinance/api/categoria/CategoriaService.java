package com.fluxafinance.api.categoria;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada")
                    );
    }
}
