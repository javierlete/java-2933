package com.uberits.pruebas;

import java.util.Optional;

import com.uberits.entidades.Usuario;
import com.uberits.negocio.NegocioUsuario;

public class PruebasNegocio {

    public static void main(String[] args) {

        NegocioUsuario negocioUsuario = new NegocioUsuario();

        Usuario usuario = new Usuario(
                null,
                "Javier",
                "javier@email.net",
                "javier",
                null
        );

        negocioUsuario.insertar(usuario);

        System.out.println("USUARIOS:");

        for (Usuario u : negocioUsuario.obtenerTodos()) {
            System.out.println(u);
        }

        System.out.println("BUSCAR POR EMAIL:");

        Optional<Usuario> resultado =
                negocioUsuario.buscarPorEmail("javier@email.net");

        System.out.println(resultado);
    }
}