package com.ejemplo.formulario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="FormularioServlet", urlPatterns={"/formulario"})//  http://localhost:8080/formulario/formulario es ese el link
public class FormularioServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");//toma dato nombre del formulario
        String apellidos = request.getParameter("apellidos");
        String edad = request.getParameter("edad");
        String[] hobbies = request.getParameterValues("hobbies");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet que procesa un formulario básico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hola " + nombre + " " + apellidos + "</h1>");// muestra nombre y apellidos en un titulo junto a hola
            out.println("Tu franja de edad es " + edad + " y tus hobbies son:");

            if (hobbies != null && hobbies.length > 0) {
                out.println("<ul>");
                for (String hobby : hobbies) {
                    out.println("<li>" + hobby + "</li>");//lista de hobbies
                }
                out.println("</ul>");
            } else {
                out.println("<p>No seleccionaste hobbies.</p>");
            }

            out.println("<hr>");
            out.println("Este formulario ha sido invocado con los siguientes parámetros:<br/>");
            out.println(request.getQueryString());//muestra parametros

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}