function addMensaje() {
    let username = $('#user').val();
    let message = $('#escribirMensaje').val();
    let chat = $('#chat');
    let p = $('<p></p>');
    let mensajes = $('#mensajes');

    p.html(username + ": <b>" + message + "</b>");
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
        dataType: 'json',
        success: function(response) {
            // Limpia el contenido de #mensajes para no cargar el ultimo mensaje constantemente
            $('#mensajes').empty();

            // Itera sobre el array JSON y muestra cada mensaje
            $.each(response, function(index, mensaje) {
                $('#mensajes').append("<p>" + mensaje.usuario + ": " + mensaje.mensaje + "</p>");
            });

            // Hacer scroll hasta la parte inferior del chat
            let chat = $('#chat');
            chat.scrollTop(chat.prop('scrollHeight'));
        },
        error: function() {
            alert('Error al recargar los datos.');
        }
    });
}

