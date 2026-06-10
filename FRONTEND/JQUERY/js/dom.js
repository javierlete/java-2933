'use strict';

$(function () {
    console.log($('h1').css('color', 'red').addClass('titulo').html('Ahora ya manipulamos la <em>pantalla</em>')[0]);

    console.log($('#saludar').on('click', btnSaludarPulsado)[0]);
    $('#saludar').on('click', function () { console.log('Hola'); });
    $('#saludar').on('click', function () { console.log('No existían las arrow functions') });

    function btnSaludarPulsado() {
        alert('¡Holaaa!');
    }

    console.log($('#formulario-saludar').on('submit', function (e) {
        e.preventDefault();

        $('#saludo').text('Hola ' + $('#nombre').val() + ' ¿cómo estás ' + $('#nombre').val() + '?')
    })[0]);

    $('#formulario-tareas').on('submit', function (e) {
        e.preventDefault();

        $('#lista-tareas').append($('<li>').text($('#formulario-tareas [name=tarea]').val()));

        $('#formulario-tareas')[0].reset();
    });

    $('#vaciar-lista').on('click', function () {
        $('#lista-tareas').empty();
    });

});

