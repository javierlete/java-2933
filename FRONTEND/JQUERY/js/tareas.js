'use strict';

let UL;

window.addEventListener('DOMContentLoaded', () => {
    UL = document.querySelector('ul');

    const form = document.querySelector('form');
    const btnArchivar = document.querySelector('#archivar');

    form.addEventListener('submit', agregarTarea);
    btnArchivar.addEventListener('click', archivar);
});

function agregarTarea(e) {
    e.preventDefault();

    const form = e.target;
    const textoTarea = form.tarea.value.trim();

    if (!textoTarea) {
        return;
    }


    const li = document.createElement('li');
    const label = document.createElement('label');
    const input = document.createElement('input');

    input.type = 'checkbox';
    input.addEventListener('change', clickTarea);

    label.textContent = textoTarea;

    label.appendChild(input);
    li.appendChild(label);
    UL.appendChild(li);

    form.reset();
}

function clickTarea(e) {
    const elInput = e.target;
    const laLabel = elInput.parentNode;

    console.log(elInput);
    console.log(laLabel);

    console.log(elInput.checked);

    if (elInput.checked) {
        laLabel.classList.add('completada');
    } else {
        laLabel.classList.remove('completada');
    }
}

function archivar() {
    // Buscar los li que tienen un input marcado
    const tareas = UL.querySelectorAll('li');

    console.log(tareas);

    for (const tarea of tareas) {
        const input = tarea.querySelector('input[type="checkbox"]');
        
        if (input.checked) {
            UL.removeChild(tarea);
        }
    }

    // const tareas = UL.querySelectorAll('li');

    // tareas.forEach(tarea => {
    //     const input = tarea.querySelector('input[type="checkbox"]');
    //     if (input.checked) {
    //         UL.removeChild(tarea);
    //     }
    // });
}