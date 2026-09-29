package com.uberits.negocio;

import java.util.Optional;

import com.uberits.accesodatos.DaoUsuario;
import com.uberits.entidades.Usuario;

public class NegocioUsuario {

    private DaoUsuario dao;

    public NegocioUsuario(DaoUsuario dao) {
        this.dao = dao;
    }

    public Iterable<Usuario> obtenerTodos() {
        return dao.obtenerTodos();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return dao.obtenerPorId(id);
    }

    public Usuario insertar(Usuario usuario) {
        return dao.insertar(usuario);
    }

    public Usuario modificar(Usuario usuario) {
        return dao.modificar(usuario);
    }

    public void borrar(Long id) {
        dao.borrar(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }
}