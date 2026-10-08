package com.uberits.uberitspring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public Usuario autenticar(@RequestBody Usuario usuario) {
		var usuarioAutenticado = anonimoService.autenticarse(usuario);
		
		if(usuarioAutenticado.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		return usuarioAutenticado.get();
	}
	
	@PostMapping("registrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario registrar(@Valid @RequestBody Usuario usuario) {
		var usuarioRegistrado = anonimoService.registrarse(usuario);
		
		return usuarioRegistrado;
	}
}
