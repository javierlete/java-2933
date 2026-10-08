package com.uberits.uberitspring.dtos;

import lombok.Builder;

@Builder
public record UsuarioRegistrarSalidaDto(Long id, String nombre, String email) {

}
