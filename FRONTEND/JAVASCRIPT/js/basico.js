'use strict';

const SALUDO = 'Hola mundo';

console.log(SALUDO);

let numero = 5;

console.log(numero, typeof numero);

console.log(numero / 0, typeof Infinity);

numero = 'pepe';

console.log(numero, typeof numero);

// const nombre = prompt('¿Cómo te llamas?');

// alert(`Hola ${nombre}, ¿qué tal estás?`);

let opcion;

do {
    opcion = parseInt(prompt('Dime un número de opción'));
} while (isNaN(opcion));

alert(opcion);
alert(typeof opcion);

alert(opcion == 5);
alert(opcion === 5);

switch (opcion) {
    case 5: alert('LA CINCO'); break;
    default: alert('OTRA');
}
