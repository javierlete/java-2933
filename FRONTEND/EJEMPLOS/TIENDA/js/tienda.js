const URL_PRODUCTOS = 'https://6a1fe16be96c1d13b5868fb0.mockapi.io/api/v1/productos/';

const listadoProductos = document.querySelector('#productos div');

await listarProductos();

const formularioBusqueda = document.querySelector('#formulario-busqueda');

formularioBusqueda.addEventListener('submit', e => {
    e.preventDefault();

    const texto = formularioBusqueda.texto.value;

    formularioBusqueda.reset();

    listarProductos(texto);
});

async function listarProductos(texto) {
    let url = URL_PRODUCTOS;

    if(texto) {
        url += '?nombre=' + texto;
    }

    let respuesta = await fetch(url);

    console.log(respuesta);

    if(!respuesta.ok) {
        alert('No se ha encontrado ningún producto con esas características');
        respuesta = await fetch(URL_PRODUCTOS);
    }

    const productos = await respuesta.json();

    console.log(productos);

    listadoProductos.innerHTML = '';

    for (const p of productos) {
        console.log(p);

        const div = document.createElement('div');

        div.className = 'col';

        const htmlProducto = `
        <div class="card h-100">
            <img src="https://picsum.photos/id/${p.id}/400/300" class="card-img-top" alt="${p.nombre}">
            <div class="card-body">
                <h5 class="card-title">${p.nombre}</h5>
                <p class="card-text">${p.departamento}</p>
            </div>
            <div class="card-footer">
                <small class="text-body-secondary">Precio: ${p.precio} €</small>
            </div>
        </div>
    `;

        div.innerHTML = htmlProducto;

        listadoProductos.appendChild(div);
    }
}
