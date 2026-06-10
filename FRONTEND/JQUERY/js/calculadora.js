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

    if (etiqueta === '=') {
        boton.className = 'destacado';
        boton.addEventListener('click', ejecutarIgual);
    } else if (etiqueta >= '0' && etiqueta <= '9') {
        boton.className = 'numero';
        boton.addEventListener('click', ejecutarNumero);
    } else if(etiqueta === 'C') {
        boton.addEventListener('click', ejecutarC);
    } else {
        boton.addEventListener('click', ejecutarOperacion);
    }

    calculadora.appendChild(boton);
}

function ejecutarNumero(e) {
    const etiqueta = e.target.textContent;
    const pantalla = inputResultado.textContent;
    
    resultado = (pantalla !== '0' ? pantalla : '') + etiqueta;
    
    inputResultado.textContent = resultado;
}

function ejecutarC() {
    resultado = 0;
    
    inputResultado.textContent = resultado;
}

function ejecutarOperacion(e) {
    const etiqueta = e.target.textContent;
    const pantalla = inputResultado.textContent;
    
    op1 = +pantalla; 
    op = etiqueta; 
    resultado = 0;

    inputResultado.textContent = resultado;
}

function ejecutarIgual() {
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
