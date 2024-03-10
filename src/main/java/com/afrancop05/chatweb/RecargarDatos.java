package com.afrancop05.chatweb;

import com.google.gson.Gson;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/recargardatos")
public class RecargarDatos extends HttpServlet {

    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Mensaje> listaMensajes = obtenerMensajesFichero(request.getServletContext());

        String mensajesJson = gson.toJson(listaMensajes);
        writer.print(mensajesJson);
        writer.flush();

    }

    // Metodo para obtener la lista de mensajes desde el archivo mensajes.txt
    private List<Mensaje> obtenerMensajesFichero(ServletContext context) throws IOException
    {
        Properties properties = new Properties();

        try (InputStream input = context.getResourceAsStream("/WEB-INF/config.properties")) {
            properties.load(input);
        }

        String rutaFichero = context.getRealPath(properties.getProperty("ficheroMensajes"));

        List<Mensaje> listaMensajes = new ArrayList<>();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(rutaFichero));
            listaMensajes = (List<Mensaje>) inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer desde el fichero: " + e.getMessage());
        }

        return listaMensajes;
    }
}