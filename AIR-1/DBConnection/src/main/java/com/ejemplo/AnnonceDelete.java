package com.ejemplo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {

    private AnnonceDAO dao = new AnnonceDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam == null) {
            resp.sendRedirect("AnnonceList");
            return;
        }

        int id = 0;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.sendRedirect("AnnonceList");
            return;
        }

        // Obtener la annonce para mostrarla en JSP antes de borrar
        Annonce annonce = dao.getById(id);
        if (annonce == null) {
            req.setAttribute("error", "Advertisement not found with id=" + id);
        }

        req.setAttribute("annonce", annonce);
        req.getRequestDispatcher("AnnonceDelete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                dao.delete(id);
            } catch (NumberFormatException e) {
                // ignorar
            }
        }

        resp.sendRedirect("AnnonceList");
    }
}
