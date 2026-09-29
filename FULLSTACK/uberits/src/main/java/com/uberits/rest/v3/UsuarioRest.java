package com.uberits.rest.v3;

import java.util.Optional;

import com.uberits.entidades.Usuario;
import com.uberits.negocio.NegocioUsuario;
import com.uberits.accesodatos.jpa.DaoUsuarioJpa;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest {

	private NegocioUsuario negocio = new NegocioUsuario(new DaoUsuarioJpa());

	@GET
	public Iterable<Usuario> obtenerTodos() {
		return negocio.obtenerTodos();
	}

	@GET
	@Path("/{id}")
	public Response obtenerPorId(@PathParam("id") Long id) {

		Optional<Usuario> usuario = negocio.obtenerPorId(id);

		if (usuario.isPresent()) {
			return Response.ok(usuario.get()).build();
		}

		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/buscar")
	public Response buscarPorEmail(@QueryParam("email") String email) {

		Optional<Usuario> usuario = negocio.buscarPorEmail(email);

		if (usuario.isPresent()) {
			return Response.ok(usuario.get()).build();
		}

		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	public Response insertar(Usuario usuario) {

		Usuario insertado = negocio.insertar(usuario);

		return Response.status(Response.Status.CREATED).entity(insertado).build();
	}

	@PUT
	@Path("/{id}")
	public Response modificar(@PathParam("id") Long id, Usuario usuario) {

		usuario.setId(id);

		Usuario modificado = negocio.modificar(usuario);

		return Response.ok(modificado).build();
	}

	@DELETE
	@Path("/{id}")
	public Response borrar(@PathParam("id") Long id) {

		negocio.borrar(id);

		return Response.noContent().build();
	}
}