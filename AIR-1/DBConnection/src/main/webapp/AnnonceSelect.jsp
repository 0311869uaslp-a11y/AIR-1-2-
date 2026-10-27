<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Select Announcement to Edit</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">

            <div class="card shadow-lg border-0 rounded-3">
                <div class="card-header bg-warning text-dark text-center fw-bold">
                    <h4 class="mb-0">Edit ad by ID</h4>
                </div>

                <div class="card-body">
                    <form action="AnnonceUpdate" method="get">

                        <div class="mb-3">
                            <label for="id" class="form-label">Enter the ad ID</label>
                            <input type="number" class="form-control" id="id" name="id" placeholder="Example:12" required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </div>
                    </form>

                    <div class="text-center mt-3">
                        <a href="AnnonceList" class="btn btn-outline-secondary btn-sm">← Return to the list</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
