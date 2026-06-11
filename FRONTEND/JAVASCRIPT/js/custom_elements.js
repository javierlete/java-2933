'use strict';

class Titulo extends HTMLElement {
    constructor() {
        super();

        const texto = this.getAttribute('texto');

        this.innerHTML = `<h1>${texto}</h1>`;
        this.style.color = 'green';

        this.addEventListener('click', () => {
            this.style.color = 'blue';
        });
    }
}

customElements.define("jl-titulo", Titulo);
