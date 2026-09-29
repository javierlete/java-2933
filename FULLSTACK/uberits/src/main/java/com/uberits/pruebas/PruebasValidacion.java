package com.uberits.pruebas;

import java.math.BigDecimal;
import java.util.HashSet;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import com.uberits.entidades.Cliente;
import com.uberits.entidades.Pedido;
import com.uberits.entidades.Plato;
import com.uberits.entidades.Restaurante;
import com.uberits.entidades.TipoComida;
import com.uberits.entidades.Usuario;

public class PruebasValidacion {

    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        System.out.println("=== VALIDACIÓN DE ENTIDADES ===");

        // Usuario inválido
        Usuario usuario = new Usuario(
                null,
                "",
                "correo-invalido",
                "12",
                null
        );

        validar(validator, usuario);

        // Cliente inválido
        Cliente cliente = new Cliente(
                null,
                "",
                "",
                null,
                null
        );

        validar(validator, cliente);

        // Plato inválido
        Plato plato = new Plato(
                null,
                "",
                new BigDecimal("-5"),
                null,
                null
        );

        validar(validator, plato);

        // TipoComida inválido
        TipoComida tipoComida = new TipoComida(
                null,
                ""
        );

        validar(validator, tipoComida);

        // Restaurante inválido
        Restaurante restaurante = new Restaurante(
                null,
                "",
                new HashSet<>(),
                new HashSet<>()
        );

        validar(validator, restaurante);

        // Pedido inválido
        Pedido pedido = new Pedido(
                null,
                null,
                new HashSet<>()
        );

        validar(validator, pedido);

        // Línea inválida
        Pedido.Linea linea = new Pedido.Linea(
                null,
                null,
                0
        );

        validar(validator, linea);

        factory.close();
    }

    private static void validar(Validator validator, Object entidad) {

        System.out.println();
        System.out.println("--- " + entidad.getClass().getSimpleName() + " ---");

        var errores = validator.validate(entidad);

        if (errores.isEmpty()) {
            System.out.println("Entidad válida");
        } else {
            for (ConstraintViolation<Object> error : errores) {
                System.out.println(
                        error.getPropertyPath() + ": " + error.getMessage()
                );
            }
        }
    }
}