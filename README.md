# Chat Web

El proyecto consiste en un chat en línea en el cual puede chatear cualquier  
usuario que se identifique.

## Entrada al Chat

Para entrar al chat se carga la vista **index.jsp** de la cual se carga un input para  
introducir el usuario con el cual vas a poder chatear.

Una vez el usuario le da al boton **entrar** se activa una función de JS  
llamada `comenzarChat` que recoge el valor del input y lo manda mediante  
`$.ajax` (una función de Jquery) al Servlet **Chat** mediante una petición POST 
y utilizando JSON para enviar los datos.

Cuando llega al Servlet después de haber comprobado que el usuario es válido  
este crea una sesión para el usuario recogiendo el usuario por parámetro y  
crea dos enlaces uno para entrar al chat mediante la vista **iniciarChat.jsp**  
y otro para cerrar sesión que manda a la vista inicial index.jsp.

## Comunicación en el Chat

Una vez estamos en la vista de iniciarChat.jsp se nos muestra una entrada de texto para  
poder hablar con otra gente que este conectada. 

Cuando se le da al botón **enviar**
se activa una función JS llamada `addMensaje` que  
recoge el valor del usuario de la sesión
y el mensaje a enviar y los manda por **$.ajax**  
con JSON al Servlet **GestionChat** con una petición POST.

El servlet recoge los parametros del usuario y el mensaje, crea una lista de mensajes  
que añade cada mensaje con su usuario y mensaje a la lista y esta lista  
se guarda en un fichero temporal.

Para que los otros usuarios puedan ver el mensaje se utiliza una función que ira  
mandando los mensajes al chat periodicamente llamada `recargarDatos` que  
se ejecuta cada 2 segundos mandando una petición POST al servlet **RecargarDatos**  
que obtiene los mensajes del fichero y los manda en formato JSON. 

Ahora la función recargarDatos coge esa respuesta del
servlet vacía el ultimo mensaje  
para que no envie ese ultimo mensaje en bucle y construye
el mensaje de la vista.
 


