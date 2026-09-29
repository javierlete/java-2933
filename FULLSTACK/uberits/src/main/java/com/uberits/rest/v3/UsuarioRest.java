package com.uberits.rest.v3;

import java.util.Optional;

import com.uberits.entidades.Usuario;
import com.uberits.negocio.NegocioUsuario;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioRest {

	private static final NegocioUsuario NEGOCIO = new NegocioUsuario();

	@GET
	public Iterable<Usuario> getUsuarios() {
		return NEGOCIO.obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Usuario getUsuarioPorId(@PathParam("id") Long id) {

		Optional<Usuario> usuario = NEGOCIO.obtenerPorId(id);

		if (usuario.isEmpty()) {
			throw new NotFoundException("Usuario con id=" + id + " no encontrado");
		}

		return usuario.get();
	}

	@GET
	@Path("buscar/por-email")
	public Usuario getUsuarioPorEmail(@QueryParam("email") String email) {

		Optional<Usuario> usuario = NEGOCIO.buscarPorEmail(email);

		if (usuario.isEmpty()) {
			throw new NotFoundException("Usuario con email=" + email + " no encontrado");
		}

		return usuario.get();
	}

	@POST
	public Response crearUsuario(Usuario usuario) {
		return Response.created(null).entity(NEGOCIO.insertar(usuario)).build();
	}

	@PUT
	@Path("{id}")
	public Usuario actualizarUsuario(@PathParam("id") Long id, Usuario usuario) {

		if (id != usuario.getId()) {
			throw new BadRequestException();
		}

		return NEGOCIO.modificar(usuario);
	}

	@DELETE
	@Path("{id}")
	public Response borrarUsuario(@PathParam("id") Long id) {

		NEGOCIO.borrar(id);

		return Response.noContent().build();
	}
}