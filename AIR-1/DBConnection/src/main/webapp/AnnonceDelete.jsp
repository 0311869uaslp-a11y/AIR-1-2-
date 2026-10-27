<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ejemplo.Annonce" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Eliminate Ad</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <%
                Annonce annonce = (Annonce) request.getAttribute("annonce");
                String error = (String) request.getAttribute("error");

                if (error != null) {
            %>
                <div class="alert alert-danger text-center">
                    <%= error %>
                </div>
                <div class="text-center mt-3">
                    <a href="AnnonceList" class="btn btn-outline-secondary">← Return to list</a>
                </div>

            <%
                } else if (annonce == null) {
            %>
                <div class="alert alert-warning text-center">
                    Ad not found.
                </div>
                <div class="text-center mt-3">
                    <a href="AnnonceList" class="btn btn-outline-secondary">← Return to list</a>
                </div>

            <%
                } else {
            %>

            <div class="card shadow-lg border-0 rounded-3">
                <div class="card-header bg-danger text-white text-center fw-bold">
                    <h4 class="mb-0">Confirm elimination</h4>
                </div>
                <div class="card-body">
                    <p class="text-center text-muted">
                        You are about to delete the following <strong>ad</strong>:
                    </p>

                    <div class="table-responsive">
                        <table class="table table-bordered table-striped align-middle text-center">
                            <tbody>
                                <tr><th>ID</th><td><%= annonce.getId() %></td></tr>
                                <tr><th>Title</th><td><%= annonce.getTitle() %></td></tr>
                                <tr><th>Description</th><td><%= annonce.getDescription() %></td></tr>
                                <tr><th>Adress</th><td><%= annonce.getAdress() %></td></tr>
                                <tr><th>Email</th><td><%= annonce.getMail() %></td></tr>
                                <tr><th>Date</th><td><%= annonce.getDate() %></td></tr>
                            </tbody>
                        </table>
                    </div>

                    <form action="AnnonceDelete" method="post" class="mt-4 text-center">
                        <input type="hidden" name="id" value="<%= annonce.getId() %>"/>
                        <button type="submit" class="btn btn-danger px-4"
                                onclick="return confirm('Are you sure you want to delete this ad?');">
                            🗑️ Eliminate definitively
                        </button>
                    </form>

                    <div class="text-center mt-3">
                        <a href="AnnonceList" class="btn btn-outline-secondary btn-sm">
                            ← Return to list
                        </a>
                    </div>
                </div>
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
