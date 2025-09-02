package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Premio", value = "/Premio")
public class Premio extends jakarta.servlet.http.HttpServlet {
    private int contadorVisitas = 0;
    private String nombreVisitante;
    private String message = "¡Felicitaciones @! eres el visitante número # de nuestro sitio y has sido\n" +
            "seleccionado para el gran premio TTPS - Cursada APROBADA";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newMessage = this.message.replace("@",request.getParameter("nombre"));
        response.setContentType("text/html");
        contadorVisitas++;

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Premio</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>" + newMessage.replace("#", String.valueOf(contadorVisitas)) + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
