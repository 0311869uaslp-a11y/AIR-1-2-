<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Add an ad</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow-lg border-0 rounded-3">
                <div class="card-header bg-primary text-white text-center">
                    <h4 class="mb-0">Add an ad</h4>
                </div>
                <div class="card-body">
                    <form method="post" action="AnnonceAdd">

                        <div class="mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" name="title" required>
                        </div>

                        <div class="mb-3">
                            <label for="description" class="form-label">Description</label>
                            <textarea class="form-control" id="description" name="description" rows="4"></textarea>
                        </div>

                        <div class="mb-3">
                            <label for="adress" class="form-label">Adress</label>
                            <input type="text" class="form-control" id="adress" name="adress" required>
                        </div>

                        <div class="mb-3">
                            <label for="mail" class="form-label">Email</label>
                            <input type="email" class="form-control" id="mail" name="mail" required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">Add</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
