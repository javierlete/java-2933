const ul = document.querySelector('ul');

const URL = 'http://localhost:3000/productos';

const respuesta = await fetch(URL);

console.log(respuesta);

const productos = await respuesta.json();

console.log(productos);

for (const producto of productos) {
    const li = document.createElement('li');

    li.textContent = producto.nombre; //JSON.stringify(producto);

    ul.appendChild(li);
}