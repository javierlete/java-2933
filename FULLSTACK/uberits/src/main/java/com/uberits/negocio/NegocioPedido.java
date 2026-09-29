package com.uberits.negocio;

import java.util.Optional;

import com.uberits.accesodatos.DaoPedido;
import com.uberits.entidades.Pedido;

public class NegocioPedido {

    private DaoPedido dao;

    public NegocioPedido(DaoPedido dao) {
        this.dao = dao;
    }

    public Iterable<Pedido> obtenerTodos() {
        return dao.obtenerTodos();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return dao.obtenerPorId(id);
    }

    public Pedido insertar(Pedido pedido) {
        return dao.insertar(pedido);
    }

    public Pedido modificar(Pedido pedido) {
        return dao.modificar(pedido);
    }

    public void borrar(Long id) {
        dao.borrar(id);
    }
}