'use strict';

const temperaturas = [20, 18, 15, 17, 21, 33, 40, 20, 30, 10];

temperaturas[0] = 21;

console.log(temperaturas);

const coleccion = [];

coleccion.push('UNO');
coleccion.push('DOS');

console.log(coleccion, coleccion.length);

const diccionario = [];

diccionario.perro = 'dog';
diccionario['gato'] = 'cat';

console.log(diccionario);

const termino = 'gato';

console.log(diccionario[termino]);

const tablero = [
    ['t', 'c', 'a', 'r', 'd', 'a', 'c', 't'],
    ['p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'],
    ['.', '.', '.', '.', '.', '.', '.', '.'],
    ['.', '.', '.', '.', '.', '.', '.', '.'],
    ['.', '.', '.', '.', '.', '.', '.', '.'],
    ['.', '.', '.', '.', '.', '.', '.', '.'],
    ['P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'],
    ['T', 'C', 'A', 'R', 'D', 'A', 'C', 'T'],
];

console.log(tablero);

mostrarPantalla();

tablero[1][3] = '.';
tablero[3][3] = 'p';

console.log(tablero);

mostrarPantalla();

console.log(typeof mostrarPantalla);

function mostrarPantalla() {
    let pantalla = '';

    for (let x = 0; x < tablero.length; x++) {
        for (let y = 0; y < tablero[x].length; y++) {
            pantalla += tablero[x][y] + '\t';
        }

        pantalla += '\n';
    }

    console.log(pantalla);
}

