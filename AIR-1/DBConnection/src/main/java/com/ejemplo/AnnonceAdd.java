package com.ejemplo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AnnonceAdd")
public class AnnonceAdd extends HttpServlet {

    private AnnonceDAO dao = new AnnonceDAO();

    // doGet(): muestra el formulario
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher("AnnonceAdd.jsp").forward(req, resp);
    }

    // doPost(): valida y guarda el anuncio
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String adress = req.getParameter("adress");
        String mail = req.getParameter("mail");

        resp.setContentType("text/html;charset=UTF-8");

        // Validación: todos los campos obligatorios
        if (title == null || title.isEmpty() ||
            description == null || description.isEmpty() ||
            adress == null || adress.isEmpty() ||
            mail == null || mail.isEmpty()) {

            req.setAttribute("error", "All fields are required!!!");
            req.getRequestDispatcher("AnnonceAddMessage.jsp").forward(req, resp);
            return;
        }

        // Crear objeto Annonce y guardar usando DAO
        Annonce annonce = new Annonce(title, description, adress, mail);
        dao.insert(annonce);

        req.setAttribute("success", "Ad added successfully!");
        req.getRequestDispatcher("AnnonceAddMessage.jsp").forward(req, resp);
    }
}
