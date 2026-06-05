export function objetoAFormulario(objeto, form) {
    Object.entries(objeto).forEach(([name, value]) => {
        form[name].value = value;
    });
}

export function formularioAObjeto(form) {
    return Object.fromEntries(new FormData(form));
}