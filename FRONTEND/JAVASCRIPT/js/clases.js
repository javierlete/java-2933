class Persona {
    constructor(nombre, apellidos, profesion, cursos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
        this.cursos = cursos;
    }

    nombreCompleto() {
        return `${this.nombre} ${this.apellidos}`;
    }
}

const javier = new Persona('Javier', 'Lete', 'Profe', [1234, 2345]);

console.log(javier);

const pepe = new Persona('Pepe', 'Pérez');

console.log(pepe);

console.log(javier.nombreCompleto());
console.log(pepe.nombreCompleto());
