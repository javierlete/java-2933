package com.uberits.uberitspring.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UsuarioAutenticarEntradaDto(@NotBlank @Email String email, @NotBlank String password) {

}
