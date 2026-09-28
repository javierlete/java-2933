package com.uberits.negocio;

import com.uberits.accesodatos.DaoRestaurante;
import com.uberits.entidades.Restaurante;

import bibliotecas.inyecciondependencias.ContenedorInyeccionDependencias;

public class NegocioRestaurante {

    private DaoRestaurante daoRestaurante;

    public NegocioRestaurante() {
        daoRestaurante = ContenedorInyeccionDependencias.obtenerObjeto(
                "dao.restaurante", DaoRestaurante.class);
    }

    public Iterable<Restaurante> obtenerTodos() {
        return daoRestaurante.obtenerTodos();
    }

    public Restaurante obtenerPorId(Long id) {
        return daoRestaurante.obtenerPorId(id).orElse(null);
    }

    public Restaurante insertar(Restaurante restaurante) {
        return daoRestaurante.insertar(restaurante);
    }

    public Restaurante modificar(Restaurante restaurante) {
        return daoRestaurante.modificar(restaurante);
    }

    public void borrar(Long id) {
        daoRestaurante.borrar(id);
    }
}