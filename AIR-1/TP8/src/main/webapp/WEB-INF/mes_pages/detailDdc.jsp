<%@page contentType="text/html"%>
<%@include file="/WEB-INF/mes_pages/include.jsp" %>

<html>
<head>
    <title>Détail de la demande de congés</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            color: #333;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 700px;
            margin: 50px auto;
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        h2 {
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 10px;
        }

        a {
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
            margin-bottom: 20px;
            display: inline-block;
        }

        .detail {
            margin-top: 20px;
        }

        .detail p {
            margin: 10px 0;
            line-height: 1.6;
        }

        .label {
            font-weight: bold;
            color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Détail de la demande de congés numéro ${demandeConge.numero}</h2>
        
        <a href="http://localhost:8081/ddc/listerDdc">&larr; Retour</a>

        <div class="detail">
            <p><span class="label">Date de début :</span> <c:out value="${demandeConge.periode.dateDebut}"/></p>
            <p><span class="label">Nombre de jours :</span> ${demandeConge.periode.nbJours}</p>
            <p><span class="label">Collaborateur :</span> ${demandeConge.collaborateur.prenom} ${demandeConge.collaborateur.nom}</p>
        </div>
    </div>
</body>
</html>
