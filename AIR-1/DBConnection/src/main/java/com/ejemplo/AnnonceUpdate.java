package com.ejemplo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {

    private AnnonceDAO dao = new AnnonceDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam == null) {
            System.out.println("[AnnonceUpdate] No id parameter received.");
            resp.sendRedirect("AnnonceList");
            return;
        }

        int id = 0;
        //Convertir el ID a número entero
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            System.out.println("[AnnonceUpdate] Invalid ID: " + idParam);
            resp.sendRedirect("AnnonceList");
            return;
        }

        // Obtener la annonce por ID
        Annonce annonce = dao.getById(id);

        if (annonce == null) {
            System.out.println("[AnnonceUpdate]Not found any annonce with id=" + id);
            req.setAttribute("error", "Not found any annonce with id=" + id);
        }

        req.setAttribute("annonce", annonce);
        req.getRequestDispatcher("AnnonceUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
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

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String adress = req.getParameter("adress");
        String mail = req.getParameter("mail");

        Annonce annonce = new Annonce(title, description, adress, mail);
        annonce.setId(id);

        dao.update(annonce);

        resp.sendRedirect("AnnonceList");
    }
}
