'use strict';

var op1, op, op2, resultado;

var etiquetas = [
    '7', '8', '9', '/',
    '4', '5', '6', 'X',
    '1', '2', '3', '-',
    '=', '0', 'C', '+',
];

$(function () {
    $(etiquetas).each(function () {
        var $boton = $('<button>').text(this);

        if (this == '=') {
            $boton.addClass('destacado').on('click', ejecutarIgual);
        } else if (this >= '0' && this <= '9') {
            $boton.addClass('numero').on('click', ejecutarNumero);
        } else if (this == 'C') {
            $boton.on('click', ejecutarC);
        } else {
            $boton.on('click', ejecutarOperacion);
        }

        console.log($boton[0]);

        $('#calculadora').append($boton);
    });

    function ejecutarNumero(e) {
        var resultado = $('#resultado').text();
        $('#resultado').text((resultado != '0' ? resultado : '') + $(e.target).text());
    }

    function ejecutarC() {
        $('#resultado').text(0);
    }

    function ejecutarOperacion(e) {
        op1 = +$('#resultado').text();
        op = e.target.textContent;
        ejecutarC();
    }

    function ejecutarIgual() {
        op2 = +$('#resultado').text();

        switch (op) {
            case '+': resultado = op1 + op2; break;
            case '-': resultado = op1 - op2; break;
            case 'X': resultado = op1 * op2; break;
            case '/': resultado = op1 / op2; break;
            default: resultado = 'ERROR';
        }

        $('#resultado').text(resultado);
    }
});