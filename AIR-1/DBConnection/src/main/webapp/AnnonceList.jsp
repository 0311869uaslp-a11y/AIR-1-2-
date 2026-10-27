<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ejemplo.Annonce" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>List of Announcements</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg border-0 rounded-3">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h4 class="mb-0">List of available announcements</h4>
            <a href="AnnonceAdd" class="btn btn-light btn-sm fw-bold">+ Add an ad</a>
            <a href="AnnonceSelectDelete.jsp" class="btn btn-light btn-sm fw-bold">- Delete an ad</a>
            <a href="AnnonceSelect.jsp" class="btn btn-light btn-sm fw-bold">* Update an ad</a>
        </div>

        <div class="card-body">

            <%
                List<Annonce> annonces = (List<Annonce>) request.getAttribute("annonces");

                if (annonces == null || annonces.isEmpty()) {
            %>
                <div class="alert alert-warning text-center" role="alert">
                    <strong>No ads available at the moment.</strong>
                </div>
            <%
                } else {
            %>

            <div class="table-responsive">
                <table class="table table-striped table-hover align-middle text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Actions</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Adress</th>
                            <th>Email</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Annonce a : annonces) {
                    %>
                        <tr>
                            <td>
                                <a href="AnnonceDelete?id=<%= a.getId() %>" class="btn btn-danger btn-sm fw-bold">Delete</a>
                                <a href="AnnonceUpdate?id=<%= a.getId() %>" class="btn btn-warning btn-sm fw-bold">Update</a>
                            </td>
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
                    </tbody>
                </table>
            </div>

            <%
                }
            %>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
