'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
    const ul = document.querySelector('ul');

    form.addEventListener('submit', e => {
        e.preventDefault();

        const li = document.createElement('li');
        const input = document.createElement('input');
        const label = document.createElement('label');

        const textoTarea = form.tarea.value.trim();
        
        if(!textoTarea) {
            return;
        }

        input.type = 'checkbox';
        input.addEventListener('change', e => {
            const elInput = e.target;
            const laLabel = elInput.parentNode;
            
            console.log(elInput);
            console.log(laLabel);

            console.log(elInput.checked);

            if(elInput.checked) {
                laLabel.classList.add('completada');
            } else {
                laLabel.classList.remove('completada');
            }
        });

        label.textContent = textoTarea;

        label.appendChild(input);

        li.appendChild(label);

        ul.appendChild(li);

        form.reset();
    });
});