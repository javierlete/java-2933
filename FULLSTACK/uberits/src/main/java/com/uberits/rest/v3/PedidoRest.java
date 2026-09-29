package com.uberits.rest.v3;

import java.util.Optional;

import com.uberits.accesodatos.jpa.DaoPedidoJpa;
import com.uberits.entidades.Pedido;
import com.uberits.negocio.NegocioPedido;

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

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoRest {

    private NegocioPedido negocio =
            new NegocioPedido(new DaoPedidoJpa());

    @GET
    public Iterable<Pedido> obtenerTodos() {
        return negocio.obtenerTodos();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {

        Optional<Pedido> pedido = negocio.obtenerPorId(id);

        if (pedido.isPresent()) {
            return Response.ok(pedido.get()).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response insertar(Pedido pedido) {

        Pedido insertado = negocio.insertar(pedido);

        return Response.status(Response.Status.CREATED)
                .entity(insertado)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response modificar(@PathParam("id") Long id,
                              Pedido pedido) {

        pedido.setId(id);

        Pedido modificado = negocio.modificar(pedido);

        return Response.ok(modificado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrar(@PathParam("id") Long id) {

        negocio.borrar(id);

        return Response.noContent().build();
    }
}