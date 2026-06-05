export function objetoAFormulario(objeto, form) {
    Object.entries(objeto).forEach(([name, value]) => {
        form[name].value = value;
    });
}