package com.fluxafinance.api.categoria;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    // Identificador único da categoria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    // Título da categoria (ex: "Infraestrutura", "Salários")
    @Column(nullable = false, length = 255)
    private String titulo;

    // Tipo da categoria (ex.: RECEITA ou DESPESA). Usamos enum para garantir valores conhecidos.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCategoria tipo;

    // Flag para indicar se a categoria está ativa (permite desativar sem remover histórico)
    @Column(nullable = false)
    private Boolean ativo = true;

    public Categoria() {
    }

    // Construtor de conveniência para referenciar categoria apenas pelo id em outras entidades
    public Categoria(Long id) {
        this.id = id;
    }

    // Getters mínimos — mantemos a entidade focada em representar estado.
    // Regras de negócio (ex.: validar uso antes de exclusão) devem ficar em CategoriaService.
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
