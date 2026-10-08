package com.uberits.uberitspring.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UsuarioRegistrarEntradaDto(@NotBlank @Size(max = 20) String nombre,
		@Size(max = 100) @NotBlank @Email String email, @NotBlank @Size(max = 100) String password) {

}
