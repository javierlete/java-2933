'use strict';

const javier = { nombre: 'Javier', apellidos: 'Lete' };

console.log(javier, typeof javier);

console.log(javier.nombre);

console.log(javier['apellidos']);

javier.profesion = 'Profesor';

console.log(javier);

javier.cursos = [2933, 1234];

console.log(javier);

const pepe = { nombre: 'Pepe', apellidos: 'Pérez', profesion: 'Figurante' };

const gente = [javier, pepe];

console.log(gente);

for(const persona of gente) {
    console.log(persona.apellidos);
}

javier.nombreCompleto = function() { return this.nombre + ' ' + this.apellidos; };

console.log(javier.nombreCompleto());

pepe.nombreCompleto = javier.nombreCompleto;

console.log(pepe.nombreCompleto());
