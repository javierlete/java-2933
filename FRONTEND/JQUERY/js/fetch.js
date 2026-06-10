const ul = document.querySelector('ul');

const URL = 'http://localhost:3000/productos/';

await refrescarListado();

const form = document.forms[0];

form.addEventListener('submit', async e => {
    e.preventDefault();

    const producto = { nombre: form.nombre.value };

    const options = {
        method: 'POST',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify(producto)
    };

    try {
        const response = await fetch(URL, options);
        const productoCreado = await response.json();

        console.log(productoCreado);

        form.reset();

        await refrescarListado();
    } catch (error) {
        console.error(error);
    }
});
async function refrescarListado() {
    const respuesta = await fetch(URL);

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    ul.innerHTML = '';

    for (const producto of productos) {
        const li = document.createElement('li');

        li.innerHTML = `${producto.nombre} <button onclick="javascript:borrar(${producto.id})">X</button>`; //JSON.stringify(producto);

        ul.appendChild(li);
    }
}

window.borrar = async function (id) {
    console.log('BORRAR', id);

    try {
        const response = await fetch(URL + id, { method: 'DELETE' });
        console.log(response);

        await refrescarListado();
    } catch (error) {
        console.error(error);
    }
}