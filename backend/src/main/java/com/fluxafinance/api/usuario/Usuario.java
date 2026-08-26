package com.fluxafinance.api.usuario;

import jakarta.persistence.*;

// Entity indica para o JPA que esta é uma tabela
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private String endereco_usuario;

    private String empresa;
}
