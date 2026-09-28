package com.uberits.negocio;

import java.util.Optional;

import com.uberits.accesodatos.DaoUsuario;
import com.uberits.entidades.Usuario;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

public class NegocioUsuario {

	private DaoUsuario daoUsuario;

	public NegocioUsuario() {
		daoUsuario = ContenedorInyeccionDependencias.obtenerObjeto("dao.usuario", DaoUsuario.class);
	}

	public Iterable<Usuario> obtenerTodos() {
		return daoUsuario.obtenerTodos();
	}

	public Optional<Usuario> obtenerPorId(Long id) {
		return daoUsuario.obtenerPorId(id);
	}

	public Usuario insertar(Usuario usuario) {
		return daoUsuario.insertar(usuario);
	}

	public Usuario modificar(Usuario usuario) {
		return daoUsuario.modificar(usuario);
	}

	public void borrar(Long id) {
		daoUsuario.borrar(id);
	}

	public Optional<Usuario> buscarPorEmail(String email) {
		return daoUsuario.buscarPorEmail(email);
	}
}