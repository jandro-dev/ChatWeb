function comenzarChat() {
    let nombreUsuario = $('#nombreUsuario').val();

    if (nombreUsuario === '') {
        alert('Introduzca un usuario valido.');
        return false;
    }

    $.ajax({
        type: 'POST',
        url: 'chat',
        data: { nombreUsuario: nombreUsuario },
        success: function(response) {
            $('#comprobarUsuario').html('<h1>' + response + '</h1>');
        },
        error: function() {
            alert('Error de sesion.');
        }
    });
}