package com.uberits.negocio;

import com.uberits.accesodatos.DaoPedido;
import com.uberits.entidades.Pedido;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

public class NegocioPedido {

    private DaoPedido daoPedido;

    public NegocioPedido() {
        daoPedido = ContenedorInyeccionDependencias.obtenerObjeto(
                "dao.pedido", DaoPedido.class);
    }

    public Iterable<Pedido> obtenerTodos() {
        return daoPedido.obtenerTodos();
    }

    public Pedido obtenerPorId(Long id) {
        return daoPedido.obtenerPorId(id).orElse(null);
    }

    public Pedido insertar(Pedido pedido) {
        return daoPedido.insertar(pedido);
    }

    public Pedido modificar(Pedido pedido) {
        return daoPedido.modificar(pedido);
    }

    public void borrar(Long id) {
        daoPedido.borrar(id);
    }
}