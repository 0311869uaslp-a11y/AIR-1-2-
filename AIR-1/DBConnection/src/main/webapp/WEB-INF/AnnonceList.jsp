<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ejemplo.Annonce" %>
<html>
<head>
    <title>Liste des Annonces</title>
</head>
<body>
<h2>Liste des annonces disponibles</h2>

<%
    List<Annonce> annonces = (List<Annonce>) request.getAttribute("annonces");

    out.println("<p>DEBUG: annonces.size() = " + (annonces != null ? annonces.size() : "null") + "</p>");

    if (annonces == null || annonces.isEmpty()) {
%>
    <p>No hay anuncios disponibles.</p>
<%
    } else {
%>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Adress</th>
            <th>Mail</th>
            <th>Date</th>
        </tr>
<%
        for (Annonce a : annonces) {
%>
        <tr>
            <td><%= a.getId() %></td>
            <td><%= a.getTitle() %></td>
            <td><%= a.getDescription() %></td>
            <td><%= a.getAdress() %></td>
            <td><%= a.getMail() %></td>
            <td><%= a.getDate() %></td>
        </tr>
<%
        }
%>
    </table>
<%
    }
%>

<br/>
<a href="AnnonceAdd">Agregar nueva annonce</a>
</body>
</html>
