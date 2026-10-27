package com.ejemplo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {

    private AnnonceDAO dao = new AnnonceDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Obtener todas las annonces
        List<Annonce> annonces = dao.getAll();

        // Depuración: imprimir cantidad obtenida
        System.out.println("[Servlet] Total annonces obtained: " + annonces.size());

        // Guardar en request para la JSP
        req.setAttribute("annonces", annonces);

        // Enviar a la JSP
        req.getRequestDispatcher("AnnonceList.jsp").forward(req, resp);
    }
}
