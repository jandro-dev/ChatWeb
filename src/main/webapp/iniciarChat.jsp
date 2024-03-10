<%String nombreUsuario=(String)session.getAttribute("usuario"); %>

<!DOCTYPE html>

<html>

    <head>
        <title>Sala de Chat</title>
        <link rel="stylesheet" type="text/css" href="css/stylesWeb.css">
        <script src="https://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript" src="scripts/datosChat.js"></script>
        <script>setInterval(recargarDatos,2000)</script>
    </head>

    <body>
        <div>
            <%=nombreUsuario%>
            <p><a href="index.jsp">Cerrar Sesion</a></p>
        </div>
        <div id="chat">
            <div id="mensajes" style="margin-top: 88.9%"></div>
            <input style="display: none" type="text" id="user" value="<%=nombreUsuario%>">
            <textarea id='escribirMensaje' style="width: 92%; height: 3%;"></textarea>
            <input type="button" value="Enviar" onclick="addMensaje()" />
        </div>
    </body>

</html>