package com.fluxafinance.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

/* Repositório para acessar o banco de dados de usuários e se comunica com o UsuarioService
* para aplicar regra de negócios necessária para cadastro */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        boolean existsByNome(String nome);
        boolean existsByEmail(String email);
}