'use strict';

const valor = 6;

console.log(valor === 5 ? 'ES CINCO' : 'NO ES CINCO');

const texto = ' ';

if (texto) {
    console.log('Hay texto');
} else {
    console.log('No hay texto');
}

const opcion = 2;

switch (opcion) {
    case 1: console.log('PRIMERA'); break;
    case 2: console.log('SEGUNDA'); break;
    default: console.log('OTRA');
}

const mes = 5;

let dias;

switch (mes) {
    case 2: dias = 28; break;
    case 4:
    case 6:
    case 9:
    case 11: dias = 30; break;
    default: dias = 31;
}

console.log(`El mes ${mes} tiene ${dias} días`);

if (mes === 2) {
    dias = 28;
} else if (mes === 4 || mes === 6 || mes === 9 || mes === 11) {
    dias = 30;
} else {
    dias = 31;
}

let a = 0, b = 0;

console.log(++a, b++);

console.log(a, b);

for (let n = 1; n <= 5; n++) {
    console.log(n);
}

let c = 1;
while (c <= 5) {
    console.log(c);
    c++;
}

