'use strict';

const form = document.querySelector('form');

// EVENTO: SUBMIT DEL FORMULARIO
form.addEventListener('submit', calcular);

function calcular(e) {
    e.preventDefault();

    // RECOGER DATOS DE FORMULARIO
    const strOp1 = form.op1.value; // document.querySelector('#op1').value;
    const op = form.op.value; // document.querySelector('#op').value;
    const strOp2 = form.op2.value; // document.querySelector('#op2').value;
    
    const divResultado = document.querySelector('#resultado');

    console.log(op1, op, op2, divResultado);

    // CONVERSIÓN DE LOS DATOS
    const op1 = +strOp1;
    const op2 = +strOp2;

    // PROCESAMIENTO DE LOS DATOS
    // Según la op seleccionada, hacer la operación correspondiente con op1 y op2
    // Guardar el resultado en el inputResultado

    let resultado;

    switch(op) {
        case '+': resultado = op1 + op2; break;
        case '-': resultado = op1 - op2; break;
        case 'x': resultado = op1 * op2; break;
        case '/': resultado = op1 / op2; break;
        default: resultado = 'ERROR';
    }

    // ACTUALIZAR PANTALLA
    divResultado.textContent = resultado;

    form.reset();
}
