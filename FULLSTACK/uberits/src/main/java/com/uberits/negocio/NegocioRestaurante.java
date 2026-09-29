package com.uberits.negocio;

import java.util.Optional;

import com.uberits.accesodatos.DaoRestaurante;
import com.uberits.entidades.Restaurante;

public class NegocioRestaurante {

    private DaoRestaurante dao;

    public NegocioRestaurante(DaoRestaurante dao) {
        this.dao = dao;
    }

    public Iterable<Restaurante> obtenerTodos() {
        return dao.obtenerTodos();
    }

    public Optional<Restaurante> obtenerPorId(Long id) {
        return dao.obtenerPorId(id);
    }

    public Restaurante insertar(Restaurante restaurante) {
        return dao.insertar(restaurante);
    }

    public Restaurante modificar(Restaurante restaurante) {
        return dao.modificar(restaurante);
    }

    public void borrar(Long id) {
        dao.borrar(id);
    }
}