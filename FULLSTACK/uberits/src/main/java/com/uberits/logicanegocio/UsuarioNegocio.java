package com.uberits.logicanegocio;

import com.uberits.entidades.Pedido;
import com.uberits.entidades.Restaurante;

public interface UsuarioNegocio {

    Iterable<Restaurante> listadoRestaurantes();

    Restaurante verRestaurante(Long id);

    Pedido crearPedido(Pedido pedido);
}
