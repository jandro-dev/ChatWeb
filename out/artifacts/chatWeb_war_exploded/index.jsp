<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

  <head>
    <title>Sala de Chat</title>
    <link rel="stylesheet" type="text/css" href="css/stylesWeb.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="scripts/inicioChat.js"></script>
  </head>

  <body>
    <div class="centrar" id="comprobarUsuario">
      <table>
        <tr>
          <td>Usuario:</td>
          <td><input type="text" id="nombreUsuario" class="textinput" placeholder="Introduzca un Usuario" style="text-align: center"></td>
          <td><input type="button" value="Entrar" onclick="comenzarChat()"></td>
        </tr>
      </table>
    </div>
  </body>

</html>