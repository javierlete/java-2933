package com.uberits.pruebas;

import com.uberits.accesodatos.jpa.DaoUsuarioJpa;
import com.uberits.entidades.Usuario;
import com.uberits.negocio.NegocioUsuario;

public class PruebasNegocio {

    public static void main(String[] args) {

        NegocioUsuario negocioUsuario = new NegocioUsuario(new DaoUsuarioJpa());

        System.out.println("=== USUARIOS ===");

        for (Usuario usuario : negocioUsuario.obtenerTodos()) {
            System.out.println(usuario);
        }

        System.out.println("=== INSERTAR USUARIO ===");

        Usuario usuario = new Usuario(
                null,
                "Violeta",
                "violeta@prueba.com",
                "1234",
                null
        );

        Usuario usuarioInsertado = negocioUsuario.insertar(usuario);

        System.out.println(usuarioInsertado);

        System.out.println("=== BUSCAR POR EMAIL ===");

        System.out.println(
                negocioUsuario.buscarPorEmail("violeta@prueba.com")
        );
    }
}