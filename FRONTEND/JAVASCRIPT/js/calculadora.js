'use strict';

let op1, op, op2, resultado;

const calculadora = document.querySelector('#calculadora');
const inputResultado = document.querySelector('#resultado');

const etiquetas = [
    '7', '8', '9', '/',
    '4', '5', '6', 'X',
    '1', '2', '3', '-',
    '=', '0', 'C', '+',
];

for (const etiqueta of etiquetas) {
    const boton = document.createElement('button');
    boton.textContent = etiqueta;

    boton.addEventListener('click', botonPulsado);

    if (etiqueta === '=') {
        boton.className = 'destacado';
    }

    if (etiqueta >= '0' && etiqueta <= '9') {
        boton.className = 'numero';
    }

    calculadora.appendChild(boton);
}

function botonPulsado(e) {
    const etiqueta = e.target.textContent;
    console.log('BOTON_PULSADO', etiqueta);

    // if (!isNaN(parseInt(etiqueta))) { //etiqueta >= '0' && etiqueta <= '9') {
    //     resultado.textContent += etiqueta;
    // }

    const pantalla = inputResultado.textContent;

    switch (etiqueta) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9': resultado = (pantalla !== '0' ? pantalla : '') + etiqueta; break;
        case 'C': resultado = 0; break;
        case '+':
        case '-':
        case 'X':
        case '/': op1 = +pantalla; op = etiqueta; resultado = 0; break;
        case '=': ejecutarOperacion(); break;
        default: resultado = pantalla;
    }

    // MOSTRAR EN PANTALLA

    inputResultado.textContent = resultado;
}

function ejecutarOperacion() {
    const pantalla = inputResultado.textContent;
    op2 = +pantalla;

    switch (op) {
        case '+': resultado = op1 + op2; break;
        case '-': resultado = op1 - op2; break;
        case 'X': resultado = op1 * op2; break;
        case '/': resultado = op1 / op2; break;
        default: resultado = 'ERROR';
    }

    inputResultado.textContent = resultado;
}