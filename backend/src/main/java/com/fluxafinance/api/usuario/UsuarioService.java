package com.fluxafinance.api.usuario;

@Service
public class UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO usuarioRequest) {
        if(usuarioRepository.existsByNome(usuarioRequest.getNome())) {
            throw new RuntimeException("Nome de usuário já existente.");
        }

        if(usuarioRepository.existsByEmail(usuarioRequest.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }
}
