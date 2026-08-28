package com.fluxafinance.api.usuario;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioRequestDTO usuarioRequest);
    UsuarioResponseDTO toResponse(Usuario usuario);
}
