// Función constructora
function Persona(nombre, apellidos, profesion, cursos) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.profesion = profesion;
    this.cursos = cursos;
}

Persona.prototype.nombreCompleto = function() {
    return `${this.nombre} ${this.apellidos}`;
}

const javier = new Persona('Javier', 'Lete', 'Profe', [1234,2345]);

console.log(javier);

const pepe = new Persona('Pepe', 'Pérez');

console.log(pepe);

console.log(javier.nombreCompleto());
console.log(pepe.nombreCompleto());

console.log('Texto'.toUpperCase());

String.prototype.toUpperCase = function() { return 'TROLEADOOOOOOO'; };
String.prototype.esProfe = function() { return this == 'Javier' };

console.log('Texto'.toUpperCase());

console.log('Texto'.esProfe());
console.log('Javier'.esProfe());
