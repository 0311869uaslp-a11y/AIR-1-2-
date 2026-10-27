<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<String> tareas = (ArrayList<String>) session.getAttribute("tareas");
%>
<html>
<head><title>Lista de Tareas</title></head>
<body>
<h2>Lista de Tareas</h2>
<% if (tareas != null && !tareas.isEmpty()) { %>
    <ul>
    <% for(String t : tareas) { %>
        <li><%= t %></li>
    <% } %>
    </ul>
<% } else { %>
    <p>No hay tareas aún.</p>
<% } %>
<a href="TodoAdd.jsp">Agregar más tareas</a>
</body>
</html>
