package com.uberits.rest.v3;

import com.uberits.entidades.Restaurante;
import com.uberits.negocio.NegocioRestaurante;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/restaurantes")
public class RestauranteRest {

	private static final NegocioRestaurante NEGOCIO = new NegocioRestaurante();

	@GET
	public Iterable<Restaurante> getRestaurantes() {
		return NEGOCIO.obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Restaurante getRestaurantePorId(@PathParam("id") Long id) {

		Restaurante restaurante = NEGOCIO.obtenerPorId(id);

		if (restaurante == null) {
			throw new NotFoundException("Restaurante con id=" + id + " no encontrado");
		}

		return restaurante;
	}

	@POST
	public Response crearRestaurante(Restaurante restaurante) {
		return Response.created(null).entity(NEGOCIO.insertar(restaurante)).build();
	}

	@PUT
	@Path("{id}")
	public Restaurante actualizarRestaurante(@PathParam("id") Long id, Restaurante restaurante) {

		if (id != restaurante.getId()) {
			throw new BadRequestException();
		}

		return NEGOCIO.modificar(restaurante);
	}

	@DELETE
	@Path("{id}")
	public Response borrarRestaurante(@PathParam("id") Long id) {

		NEGOCIO.borrar(id);

		return Response.noContent().build();
	}
}