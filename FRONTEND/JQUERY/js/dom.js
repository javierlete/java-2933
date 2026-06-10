'use strict';

const h1 = document.querySelector('h1');

console.log(h1);
console.log(h1.innerHTML);

h1.innerHTML = 'Ahora ya manipulamos la <em>pantalla</em>';
h1.style.color = 'red';
h1.className = 'titulo';

const btnSaludar = document.querySelector('#saludar');

console.log(btnSaludar);

btnSaludar.addEventListener('click', btnSaludarPulsado);
btnSaludar.addEventListener('click', function () { console.log('Hola'); });
btnSaludar.addEventListener('click', () => console.log('Arrow function os saluda'));

function btnSaludarPulsado() {
    alert('¡Holaaa!');
}

const formularioSaludar = document.querySelector('#formulario-saludar');

console.log(formularioSaludar);

formularioSaludar.addEventListener('submit', e => {
    e.preventDefault();

    const nombre = document.querySelector('#nombre').value;
    const saludo = document.querySelector('#saludo');

    saludo.textContent = `Hola ${formularioSaludar.nombre.value}, ¿cómo estás ${nombre}?`;
});

const formularioTareas = document.querySelector('#formulario-tareas');

formularioTareas.addEventListener('submit', e => {
    e.preventDefault();

    const tarea = formularioTareas.tarea.value;

    console.log(tarea);

    const li = document.createElement('li');

    li.textContent = tarea;

    console.log(li);

    const listaTareas = document.querySelector('#lista-tareas');

    listaTareas.appendChild(li);

    formularioTareas.reset();
});

const vaciarLista = document.querySelector('#vaciar-lista');

vaciarLista.addEventListener('click', () => 
    document.querySelector('#lista-tareas').innerHTML = ''
);
