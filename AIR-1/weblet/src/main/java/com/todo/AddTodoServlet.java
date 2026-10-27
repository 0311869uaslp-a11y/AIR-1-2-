package com.todo;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addTodo")
public class AddTodoServlet extends HttpServlet {

    // Lista en memoria para guardar tareas
    private static ArrayList<String> tareas = new ArrayList<>();

    // Maneja GET → redirige al formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("TodoAdd.jsp");
    }

    // Maneja POST → recibe datos del formulario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        if (titulo != null && !titulo.isEmpty()) {
            tareas.add(titulo);
        }

        // Guardamos la lista en la sesión para que el JSP la muestre
        request.getSession().setAttribute("tareas", tareas);

        // Redirige a la lista de tareas
        response.sendRedirect("TodoList.jsp");
    }
}
