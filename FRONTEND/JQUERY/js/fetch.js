var URL = 'http://localhost:3000/productos/';

$(function () {
    refrescarListado();

    $('form').on('submit', function (e) {
        e.preventDefault();

        var producto = { nombre: $('#nombre').val() };

        $.ajax(URL, { method: 'POST', data: producto, dataType: 'json' }).then(function (productoCreado) {
            console.log(productoCreado);
            $('#nombre').val('');
            refrescarListado();
        }).fail(function (error) { console.log(error); });
    });

});

function refrescarListado() {
    $.getJSON(URL).then(function (productos) {
        console.log(productos);

        $('ul').empty();

        $(productos).each(function () {
            $('<li>').html(this.nombre + ' <button onclick="javascript:borrar(' + this.id + ')">X</button>').appendTo('ul');
        });
    });
}

function borrar(id) {
    console.log('BORRAR', id);

    $.ajax(URL + id, { method: 'DELETE' }).then(function (respuesta) {
        console.log(respuesta);
        refrescarListado();
    }).fail(function (error) { console.log(error); });

}