'use strict';

function saludar() {
    console.log('Hola');
}

saludar();

function sumar(a, b) {
    return a + b;
}

console.log(sumar(5, 6));

console.log(sumar(5));

console.log(sumar(5, 6, 7));

function operar(a, b, op = '+') {
    switch (op) {
        case '+': return sumar(a, b);
        default: console.error('No tenemos esa operacion');
    }
}

console.log(operar(1, 2, '+'));
console.log(operar(1, 2, '-'));
console.log(operar(1, 2));

let operacion = sumar;

console.log(operacion(3, 4));

operacion = function (a, b) { return a - b; }; // Función anónima

console.log(operacion(3, 4));

operacion = (a, b) => a * b; // Arrow function

console.log(operacion(3, 4));
