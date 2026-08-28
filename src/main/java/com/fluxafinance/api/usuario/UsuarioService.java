package com.fluxafinance.api.usuario;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        if(usuarioRepository.existsByNome(usuario.getNome())) {
            throw new RuntimeException("Nome de usuário já existente.");
        }

        if(usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }
}
