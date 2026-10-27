<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Demandes de Congé</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; width: 100%; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .statut { padding: 3px 8px; border-radius: 3px; font-size: 0.9em; }
        .en-attente { background: #ffeb3b; color: #333; }
        .menu a { margin-right: 15px; text-decoration: none; color: #0066cc; }
    </style>
</head>
<body>
    <h1>📋 Liste des Demandes de Congé</h1>
    
    <div class="menu">
        <a href="${pageContext.request.contextPath}/ddc/home">← Retour à l'accueil</a> |
        <a href="${pageContext.request.contextPath}/">🏠 Index</a>
    </div>
    
    <p>Total des demandes: <strong>${total}</strong></p>
    
    <c:if test="${not empty demandes}">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Collaborateur</th>
                    <th>Département</th>
                    <th>Date Début</th>
                    <th>Jours</th>
                    <th>Statut</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="demande" items="${demandes}">
                    <tr>
                        <td>${demande.id}</td>
                        <td>${demande.collaborateur.nom} ${demande.collaborateur.prenom}</td>
                        <td>${demande.collaborateur.departement}</td>
                        <td>${demande.dateDebut}</td>
                        <td>${demande.nbJours}</td>
                        <td>
                            <span class="statut en-attente">${demande.statut}</span>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ddc/detailDdc?ddcId=${demande.id}">
                                Voir détail
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty demandes}">
        <p style="color: #999; font-style: italic;">Aucune demande de congé enregistrée.</p>
    </c:if>
    
    <hr>
    <p><small>Controller: ListerDdcController | Service: DemandeCongeServiceMock</small></p>
</body>
</html>