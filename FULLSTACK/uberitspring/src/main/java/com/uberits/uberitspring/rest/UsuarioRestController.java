package com.uberits.uberitspring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uberits.uberitspring.dtos.UsuarioAutenticarEntradaDto;
import com.uberits.uberitspring.dtos.UsuarioAutenticarSalidaDto;
import com.uberits.uberitspring.dtos.UsuarioRegistrarEntradaDto;
import com.uberits.uberitspring.dtos.UsuarioRegistrarSalidaDto;
import com.uberits.uberitspring.entidades.Usuario;
import com.uberits.uberitspring.servicios.AnonimoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v2/usuarios")
public class UsuarioRestController {
	private final AnonimoService anonimoService;

	@PostMapping("autenticar")
	public UsuarioAutenticarSalidaDto autenticar(@Valid @RequestBody UsuarioAutenticarEntradaDto usuarioDto) {
		var usuario = Usuario.builder().email(usuarioDto.email()).password(usuarioDto.password()).build();

		var usuarioAutenticado = anonimoService.autenticarse(usuario);

		if (usuarioAutenticado.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		return UsuarioAutenticarSalidaDto.builder().email(usuarioAutenticado.get().getEmail())
				.nombre(usuarioAutenticado.get().getNombre()).build();
	}

	@PostMapping("registrar")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioRegistrarSalidaDto registrar(@Valid @RequestBody UsuarioRegistrarEntradaDto usuarioDto) {
		var usuario = Usuario.builder().nombre(usuarioDto.nombre()).email(usuarioDto.email())
				.password(usuarioDto.password()).build();

		var usuarioRegistrado = anonimoService.registrarse(usuario);

		return UsuarioRegistrarSalidaDto.builder().id(usuarioRegistrado.getId()).nombre(usuarioRegistrado.getNombre())
				.email(usuarioRegistrado.getEmail()).build();
	}
}
