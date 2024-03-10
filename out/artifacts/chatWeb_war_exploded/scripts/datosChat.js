function addMensaje() {
    let username = $('#user').val();
    let message = $('#escribirMensaje').val();
    let chat = $('#chat');
    let p = $('<p></p>');
    let mensajes = $('#mensajes');

    p.html(username + "- <b>" + message + "</b>");
    mensajes.append(p);                                 // Añade una nueva línea al pulsar enviar
    chat.scrollTop(chat.prop('scrollHeight'));    // Iguala la altura del chat con el contenido
    $('#escribirMensaje').val('');

    $.ajax({
        type: 'POST',
        url: 'chatstore',
        data: { nombreUsuario: username, mensaje: message },
        error: function() {
            alert('Error al añadir mensaje.');
        }
    });
}

function recargarDatos() {
    $.ajax({
        type: 'POST',
        url: 'recargardatos',
        success: function(response) {
            $('#mensajes').html(response);
            let chat = $('#chat');
            chat.scrollTop(chat.prop('scrollHeight'));
        },
        error: function() {
            alert('Error al recargar los datos.');
        }
    });
}