'use strict';

const calculadora = document.querySelector('#calculadora');

const etiquetas = [
    '7', '8', '9', '/',
    '4', '5', '6', 'X',
    '1', '2', '3', '-',
    '=', '0', 'C', '+',
];

for (const etiqueta of etiquetas) {
    const boton = document.createElement('button');
    boton.textContent = etiqueta;

    if(etiqueta === '=') {
        boton.className = 'destacado';
    }

    calculadora.appendChild(boton);
}
