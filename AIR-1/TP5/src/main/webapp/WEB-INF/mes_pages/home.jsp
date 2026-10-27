<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil Collaborateur</title>

    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 80px auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            text-align: center;
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 30px;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            margin: 15px 0;
        }

        a {
            display: block;
            padding: 15px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            font-size: 16px;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #217dbb;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Accueil</h2>

    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/ddc/listerDdc">
                Lister mes demandes
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ddc/creerDdc/form">
                Créer une demande
            </a>
        </li>
    </ul>
</div>

</body>
</html>
