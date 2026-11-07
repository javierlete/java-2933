
package com.ipartex.rest.v3;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import com.ipartex.entidades.Mensaje;
import com.ipartex.logicanegocio.AnonimoNegocio;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mensajes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensajeRest {

	private static final AnonimoNegocio NEGOCIO = (AnonimoNegocio) ContenedorInyeccionDependencias
			.obtenerObjeto("negocio.anonimo");

	@GET
	public Iterable<Mensaje> getMensajes() {
		return NEGOCIO.listarMensajes();
	}

	@GET
	@Path("{id}")
	public Mensaje getMensajePorId(@PathParam("id") Long id) {

		return NEGOCIO.buscarMensajePorId(id)
				.orElseThrow(() -> new NotFoundException("Mensaje con id=" + id + " no encontrado"));
	}

	@GET
	@Path("buscar")
	public Iterable<Mensaje> buscarMensajes(@QueryParam("fecha-minima") String fechaMinima) {

		if (fechaMinima == null || fechaMinima.isBlank()) {
			throw new BadRequestException("Debes indicar una fecha mínima");
		}

		try {
			LocalDateTime fecha = LocalDateTime.parse(fechaMinima);

			return NEGOCIO.buscarMensajesPorFechaMinima(fecha);

		} catch (DateTimeParseException e) {
			throw new BadRequestException("Formato de fecha incorrecto", e);
		}
	}

	@PUT
	@Path("{id}")
	public Mensaje actualizarMensaje(@PathParam("id") Long id, Mensaje mensaje) {

		if (mensaje == null) {
			throw new BadRequestException("Debes enviar un mensaje");
		}

		if (mensaje.getId() != null && !id.equals(mensaje.getId())) {

			throw new BadRequestException("El ID de la URL no coincide con el mensaje");
		}

		if (NEGOCIO.buscarMensajePorId(id).isEmpty()) {
			throw new NotFoundException("Mensaje con ID " + id + " no encontrado");
		}

		if (mensaje.getTexto() == null || mensaje.getTexto().isBlank() || mensaje.getFechaHora() == null) {

			throw new BadRequestException("El texto y la fecha son obligatorios");
		}

		mensaje.setId(id);

		return NEGOCIO.editarMensaje(mensaje);
	}

	@DELETE
	@Path("{id}")
	public Response borrarMensaje(@PathParam("id") Long id) {

		if (NEGOCIO.buscarMensajePorId(id).isEmpty()) {
			throw new NotFoundException("Mensaje con ID " + id + " no encontrado");
		}

		NEGOCIO.eliminarMensaje(id);

		return Response.noContent().build();
	}

}
