'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', agregarTarea);
});

function agregarTarea(e) {
    e.preventDefault();
    
    const form = e.target;
    const textoTarea = form.tarea.value.trim();
    
    if (!textoTarea) {
        return;
    }

    const ul = document.querySelector('ul');
    
    const li = document.createElement('li');
    const label = document.createElement('label');
    const input = document.createElement('input');

    input.type = 'checkbox';
    input.addEventListener('change', clickTarea);

    label.textContent = textoTarea;

    label.appendChild(input);
    li.appendChild(label);
    ul.appendChild(li);

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
