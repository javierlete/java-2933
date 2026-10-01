package com.uberits.logicanegocio.impl;

import java.util.Optional;

import com.uberits.accesodatos.DaoPedido;
import com.uberits.accesodatos.DaoRestaurante;
import com.uberits.entidades.Pedido;
import com.uberits.entidades.Restaurante;
import com.uberits.logicanegocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {

    private DaoRestaurante daoRestaurante;
    private DaoPedido daoPedido;

    public UsuarioNegocioImpl(DaoRestaurante daoRestaurante, DaoPedido daoPedido) {
        this.daoRestaurante = daoRestaurante;
        this.daoPedido = daoPedido;
    }

    @Override
    public Iterable<Restaurante> listadoRestaurantes() {
        return daoRestaurante.obtenerTodos();
    }

    @Override
    public Restaurante verRestaurante(Long id) {
        Optional<Restaurante> restaurante = daoRestaurante.obtenerPorId(id);

        if (restaurante.isEmpty()) {
            return null;
        }

        return restaurante.get();
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return daoPedido.insertar(pedido);
    }
}
