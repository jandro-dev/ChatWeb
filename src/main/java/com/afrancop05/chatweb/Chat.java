package com.afrancop05.chatweb;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/chat")
public class Chat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter writer = response.getWriter();

        response.setContentType("text/html");

        String username = request.getParameter("nombreUsuario");

        HttpSession session = request.getSession();
        session.setAttribute("usuario", username);

        writer.println("Has iniciado sesion como: " + username);
        writer.println("<br><br><a href='iniciarChat.jsp'>Entrar al Chat</a> | ");
        writer.println("<a href='index.jsp'>Cerrar Sesion</a>");
    }
}