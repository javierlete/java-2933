package com.uberits.rest.v3;

import java.util.Optional;

import com.uberits.accesodatos.jpa.DaoRestauranteJpa;
import com.uberits.entidades.Restaurante;
import com.uberits.negocio.NegocioRestaurante;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestauranteRest {

    private NegocioRestaurante negocio =
            new NegocioRestaurante(new DaoRestauranteJpa());

    @GET
    public Iterable<Restaurante> obtenerTodos() {
        return negocio.obtenerTodos();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {

        Optional<Restaurante> restaurante = negocio.obtenerPorId(id);

        if (restaurante.isPresent()) {
            return Response.ok(restaurante.get()).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response insertar(Restaurante restaurante) {

        Restaurante insertado = negocio.insertar(restaurante);

        return Response.status(Response.Status.CREATED)
                .entity(insertado)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response modificar(@PathParam("id") Long id,
                              Restaurante restaurante) {

        restaurante.setId(id);

        Restaurante modificado = negocio.modificar(restaurante);

        return Response.ok(modificado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrar(@PathParam("id") Long id) {

        negocio.borrar(id);

        return Response.noContent().build();
    }
}