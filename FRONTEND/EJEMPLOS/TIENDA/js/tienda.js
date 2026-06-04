const URL_PRODUCTOS = 'https://6a1fe16be96c1d13b5868fb0.mockapi.io/api/v1/productos/';

const listadoProductos = document.querySelector('#productos div');
const formularioBusqueda = document.querySelector('#formulario-busqueda');
const adminTbody = document.querySelector('#admin-listado tbody');

window.mostrarProductos = async () => {
    await listarProductos();
    mostrarSeccion('productos');
};

window.mostrarAdminListado = async () => {
    await cargarTabla();
    mostrarSeccion('admin-listado');
};

window.mostrarFormulario = async id => {
    console.log('MOSTRAR FORMULARIO', id);
};

window.borrarProducto = async id => {
    console.log('BORRAR PRODUCTO', id);

    const respuesta = await fetch(URL_PRODUCTOS + id, { method: 'DELETE' });

    console.log(respuesta);

    await cargarTabla();
};

window.mostrarAdminListado();

formularioBusqueda.addEventListener('submit', e => {
    e.preventDefault();

    const texto = formularioBusqueda.texto.value;

    formularioBusqueda.reset();

    listarProductos(texto);
});

async function listarProductos(texto) {
    let url = URL_PRODUCTOS;

    if (texto) {
        url += '?nombre=' + texto;
    }

    let respuesta = await fetch(url);

    console.log(respuesta);

    if (!respuesta.ok) {
        alert('No se ha encontrado ningún producto con esas características');
        respuesta = await fetch(URL_PRODUCTOS);
    }

    const productos = await respuesta.json();

    console.log(productos);

    listadoProductos.innerHTML = '';

    for (const p of productos) {
        console.debug(p);

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

async function cargarTabla() {
    const respuesta = await fetch(URL_PRODUCTOS);

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    adminTbody.innerHTML = '';

    for (const p of productos) {
        console.debug(p);

        const tr = document.createElement('tr');

        const htmlProducto = `
            <td class="text-end">${p.id}</td>
            <td>${p.nombre}</td>
            <td class="text-end">${p.precio} €</td>
            <td>
                <a href="javascript:mostrarFormulario(${p.id})" class="btn btn-sm btn-primary">
                    <i class="bi bi-pencil-fill"></i>
                </a>

                <a href="javascript:borrarProducto(${p.id})" class="btn btn-sm btn-danger">
                    <i class="bi bi-trash-fill"></i>
                </a>

            </td>
        `;

        tr.innerHTML = htmlProducto;

        adminTbody.appendChild(tr);
    }
}

function mostrarSeccion(id) {
    const secciones = document.querySelectorAll('main>section');

    for (const seccion of secciones) {
        seccion.style.display = 'none';
    }

    const seccionAMostrar = document.getElementById(id); // document.querySelector('#' + id);

    seccionAMostrar.style.display = null;
}
