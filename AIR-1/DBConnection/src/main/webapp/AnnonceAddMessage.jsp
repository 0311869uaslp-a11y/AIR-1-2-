<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Result of the add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <%
                        String error = (String) request.getAttribute("error");
                        String success = (String) request.getAttribute("success");
                    %>

                    <% if (error != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <h4 class="alert-heading">❌ Error</h4>
                            <p><%= error %></p>
                        </div>
                    <% } else if (success != null) { %>
                        <div class="alert alert-success" role="alert">
                            <h4 class="alert-heading">✅ Success</h4>
                            <p><%= success %></p>
                        </div>
                    <% } else { %>
                        <div class="alert alert-secondary" role="alert">
                            <h4 class="alert-heading">ℹ️ Information</h4>
                            <p>No message was received from the server.</p>
                        </div>
                    <% } %>

                    <div class="d-grid gap-2 mt-4">
                        <a href="AnnonceAdd" class="btn btn-primary">Add another ad</a>
                        <a href="AnnonceList" class="btn btn-outline-secondary">Return to list</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
