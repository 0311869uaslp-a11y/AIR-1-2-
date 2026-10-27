package com.ejemplo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/annonce")
public class AnnonceServlet extends HttpServlet {

    private AnnonceDAO dao = new AnnonceDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String adress = req.getParameter("adress");
        String mail = req.getParameter("mail");
        String id = req.getParameter("id");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            if ("insert".equals(action)) {
                Annonce annonce = new Annonce(title, description, adress, mail);
                dao.insert(annonce);
                out.println("<h3>Insert made ✅</h3>");

            } else if ("update".equals(action)) {
                Annonce annonce = new Annonce(title, description, adress, mail);
                annonce.setId(Integer.parseInt(id));
                dao.update(annonce);
                out.println("<h3>Update performed ✅</h3>");

            } else if ("delete".equals(action)) {
                dao.delete(Integer.parseInt(id));
                out.println("<h3>Delete performed ✅</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.println("<a href='index.jsp'>Return</a>");
    }
}
