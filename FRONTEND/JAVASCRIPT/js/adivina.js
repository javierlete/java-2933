'use strict';

let aleatorio = Math.floor(Math.random() * 100) + 1;
console.log('ALEATORIO', aleatorio);

ocultarCarteles();

const resultados = document.querySelector('.resultados');

resultados.innerHTML = '';

// IDENTIFICAR EL FORMULARIO
const form = document.querySelector('form');

console.log('FORMULARIO', form);

// CAPTURAR EL EVENTO DE ENVÍO DEL FORMULARIO
form.addEventListener('submit', nuevoNumeroUsuario);

function ocultarCarteles() {
    const carteles = document.querySelectorAll('.resultado');

    for (const cartel of carteles) {
        cartel.style.display = 'none';
    }
}

// REACCIONAR AL EVENTO DE ENVÍO DE FORMULARIO
function nuevoNumeroUsuario(e) {
    console.log('NUEVO_NUMERO_USUARIO', e);

    e.preventDefault();

    // RECOGER LOS DATOS DEL FORMULARIO
    const input = form.numero;
    console.log('INPUT', input);

    const numero = input.value;
    console.log('NUMERO', numero);

    // CONSECUENCIAS

    // CAMBIOS EN LA PANTALLA
    ocultarCarteles();
    
    const li = document.createElement('li');

    if (numero > aleatorio) {
        // CAMBIOS EN LA PANTALLA
        li.innerHTML = 'El número es menor que ' + numero;
        document.querySelector('.menor').style.display = null;
    } else if (numero < aleatorio) {
        // CAMBIOS EN LA PANTALLA
        li.innerHTML = 'El número es mayor que ' + numero;
        document.querySelector('.mayor').style.display = null;
    } else {
        aleatorio = Math.floor(Math.random() * 100) + 1;
        console.log('NUEVO ALEATORIO', aleatorio);
        
        // CAMBIOS EN LA PANTALLA
        li.innerHTML = 'Has acertado. El número era ' + numero;
        document.querySelector('.correcto').style.display = null;
    }

    // CAMBIOS EN LA PANTALLA
    input.value = '';
    resultados.appendChild(li);
}