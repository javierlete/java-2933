class LabelInput extends HTMLElement {
    constructor() {
        super();

        const id = this.getAttribute('identificador');
        const etiqueta = this.getAttribute('etiqueta');
        const tipo = this.getAttribute('tipo');
        const atributos = this.getAttribute('atributos');
        const error = this.getAttribute('error');

        switch (tipo) {
            case 'submit':
                this.innerHTML = `
                    <div class="row mb-3">
                        <div class="offset-sm-2 col-sm">
                            <button type="submit" class="btn btn-primary">${etiqueta}</button>
                        </div>
                    </div>
                `;
                break;
            default:
                this.innerHTML = `
                    <div class="row mb-3">
                        <label for="${id}" class="col-sm-2 col-form-label">${etiqueta}</label>
                        <div class="col-sm">
                            <input ${atributos} type="${tipo}" class="form-control" id="${id}" name="${id}">
                            <div class="invalid-feedback">
                                ${error}
                            </div>
                        </div>
                    </div>
                `;
        }
    }
}

customElements.define('jl-label-input', LabelInput);
