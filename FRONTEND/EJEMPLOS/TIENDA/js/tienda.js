const URL_PRODUCTOS = 'https://6a1fe16be96c1d13b5868fb0.mockapi.io/api/v1/productos/';

const listadoProductos = document.querySelector('#productos div');

const respuesta = await fetch(URL_PRODUCTOS);
const productos = await respuesta.json();

for (const p of productos) {
    const div = document.createElement('div');

    div.className = 'col';

    const htmlProducto = `
        <div class="card h-100">
            <img src="https://picsum.photos/id/${p.id}/400/300" class="card-img-top" alt="Cámara Canon EOS R10">
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