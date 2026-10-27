<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mes Demandes de Conges</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 1000px;
        }
        .table thead th {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mb-4">Liste de mes demandes de congés</h2>
        
        <nav aria-label="breadcrumb" class="mb-4">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/ddc/home">Accueil</a></li>
                <li class="breadcrumb-item active" aria-current="page">Mes demandes</li>
            </ol>
        </nav>

        <div class="card shadow">
            <div class="card-body">
                <c:if test="${empty listeDemandes}">
                    <div class="alert alert-info">
                        Aucune demande de congés trouvée.
                        <a href="${pageContext.request.contextPath}/ddc/creerDdc/form" class="alert-link">
                            Créer une nouvelle demande
                        </a>
                    </div>
                </c:if>
                
                <c:if test="${not empty listeDemandes}">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Numéro</th>
                                <th>Date début</th>
                                <th>Nombre de jours</th>
                                <th>Collaborateur</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="demande" items="${listeDemandes}">
                                <tr>
                                    <td>${demande.numero}</td>
                                    <td>${demande.periode.dateDebut}</td>
                                    <td>${demande.periode.nbJours}</td>
                                    <td>${demande.collaborateur.prenom} ${demande.collaborateur.nom}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ddc/detailDdc?ddcId=${demande.numero}" 
                                           class="btn btn-sm btn-outline-primary">Détails</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                
                <div class="mt-3">
                    <a href="${pageContext.request.contextPath}/ddc/home" class="btn btn-secondary">Retour à l'accueil</a>
                    <a href="${pageContext.request.contextPath}/ddc/creerDdc/form" class="btn btn-primary ms-2">
                        Créer une nouvelle demande
                    </a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>