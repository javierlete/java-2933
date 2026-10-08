package com.uberits.uberitspring.dtos;

import lombok.Builder;

@Builder
public record UsuarioAutenticarSalidaDto(String nombre, String email) {

}
