package com.afrancop05.chatweb;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/chatstore")
public class GestionChat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String username = request.getParameter("nombreUsuario");
        String message = request.getParameter("mensaje");

        List<Mensaje> listaMensajes = obtenerMensajes(request.getServletContext());

        listaMensajes.add(new Mensaje(username, message));

        guardarMensajes(request.getServletContext(), listaMensajes);
    }

    // Metodo para obtener la lista de mensajes desde el contexto de la aplicación
    private List<Mensaje> obtenerMensajes(ServletContext context)
    {
        List<Mensaje> listaMensajes = (List<Mensaje>) context.getAttribute("mensajesChat");

        if (listaMensajes == null) {
            listaMensajes = new ArrayList<>();
            context.setAttribute("mensajesChat", listaMensajes);
        }

        return listaMensajes;
    }

    // Método para guardar la lista de mensajes en un archivo
    private void guardarMensajes(ServletContext context, List<Mensaje> listaMensajes) throws IOException
    {
        Properties properties = new Properties();

        try (InputStream input = context.getResourceAsStream("/WEB-INF/config.properties")) {
            properties.load(input);
        }

        String rutaFichero = context.getRealPath(properties.getProperty("ficheroMensajes"));

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            outputStream.writeObject(listaMensajes);
        }
        catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}