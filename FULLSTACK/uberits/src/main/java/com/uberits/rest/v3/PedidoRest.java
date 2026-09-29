package com.uberits.rest.v3;

import com.uberits.entidades.Pedido;
import com.uberits.negocio.NegocioPedido;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/pedidos")
public class PedidoRest {

	private static final NegocioPedido NEGOCIO = new NegocioPedido();

	@GET
	public Iterable<Pedido> getPedidos() {
		return NEGOCIO.obtenerTodos();
	}

	@GET
	@Path("{id}")
	public Pedido getPedidoPorId(@PathParam("id") Long id) {

		Pedido pedido = NEGOCIO.obtenerPorId(id);

		if (pedido == null) {
			throw new NotFoundException("Pedido con id=" + id + " no encontrado");
		}

		return pedido;
	}

	@POST
	public Response crearPedido(Pedido pedido) {
		return Response.created(null).entity(NEGOCIO.insertar(pedido)).build();
	}

	@PUT
	@Path("{id}")
	public Pedido actualizarPedido(@PathParam("id") Long id, Pedido pedido) {

		if (id != pedido.getId()) {
			throw new BadRequestException();
		}

		return NEGOCIO.modificar(pedido);
	}

	@DELETE
	@Path("{id}")
	public Response borrarPedido(@PathParam("id") Long id) {

		NEGOCIO.borrar(id);

		return Response.noContent().build();
	}
}