<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ejemplo.Annonce" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Actualizate Ad</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7">

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
                <div class="alert alert-danger text-center">
                    Ad not found.
                </div>
                <div class="text-center mt-3">
                    <a href="AnnonceList" class="btn btn-outline-secondary">← Return to list</a>
                </div>

            <%
                } else {
            %>

            <div class="card shadow-lg border-0 rounded-3">
                <div class="card-header bg-info text-white text-center">
                    <h4 class="mb-0">Update ad</h4>
                </div>
                <div class="card-body">
                    <form action="AnnonceUpdate" method="post">
                        <input type="hidden" name="id" value="<%= annonce.getId() %>"/>

                        <div class="mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" name="title"
                                   value="<%= annonce.getTitle() %>" pattern="[A-Za-z]+" required>
                        </div>

                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea class="form-control" id="description" name="description" rows="4" required><%= annonce.getDescription() %></textarea>
                        </div>

                        <div class="mb-3">
                            <label for="adress" class="form-label">Adress</label>
                            <input type="text" class="form-control" id="adress" name="adress"
                                   value="<%= annonce.getAdress() %>" pattern="[A-Za-z]+" required>
                        </div>

                        <div class="mb-3">
                            <label for="mail" class="form-label">Email</label>
                            <input type="email" class="form-control" id="mail" name="mail"
                                   value="<%= annonce.getMail() %>" required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">Update</button>
                        </div>
                    </form>

                    <div class="text-center mt-3">
                        <a href="AnnonceList" class="btn btn-outline-secondary btn-sm">← Return to the list</a>
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
