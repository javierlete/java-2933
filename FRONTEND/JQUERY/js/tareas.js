'use strict';

$(function () {
    $('form').on('submit', agregarTarea);
    $('#archivar').on('click', function () { $('li:has(input[type="checkbox"]:checked)').remove() });
    $('ul').on('change', 'input[type="checkbox"]', function () {
        $(this).parent().toggleClass('completada');
    });
});

function agregarTarea(e) {
    e.preventDefault();

    var texto = $('#tarea').val().trim();

    if (!texto) return;

    $('ul').append('<li><label>' + texto + '<input type="checkbox"></label></li>');

    $('form')[0].reset();
}
