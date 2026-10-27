<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détail Demande de Congé #${demande.id}</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .detail-card { border: 1px solid #ddd; padding: 20px; border-radius: 5px; margin: 20px 0; }
        .field { margin: 10px 0; }
        .label { font-weight: bold; color: #555; }
        .value { margin-left: 10px; }
        .statut { display: inline-block; padding: 5px 10px; border-radius: 3px; }
        .en-attente { background: #ffeb3b; color: #333; }
        .menu a { margin-right: 15px; text-decoration: none; color: #0066cc; }
    </style>
</head>
<body>
    <h1>📄 Détail de la Demande de Congé</h1>
    
    <div class="menu">
        <a href="${pageContext.request.contextPath}/ddc/listerDdc">← Retour à la liste</a> |
        <a href="${pageContext.request.contextPath}/ddc/home">🏠 Accueil</a> |
        <a href="${pageContext.request.contextPath}/">Index</a>
    </div>
    
    <c:if test="${not empty demande}">
        <div class="detail-card">
            <h2>Demande #${demande.id}</h2>
            
            <div class="field">
                <span class="label">Collaborateur:</span>
                <span class="value">${demande.collaborateur.nom} ${demande.collaborateur.prenom}</span>
            </div>
            
            <div class="field">
                <span class="label">Département:</span>
                <span class="value">${demande.collaborateur.departement}</span>
            </div>
            
            <div class="field">
                <span class="label">Date de début:</span>
                <span class="value">${demande.dateDebut}</span>
            </div>
            
            <div class="field">
                <span class="label">Nombre de jours:</span>
                <span class="value">${demande.nbJours}</span>
            </div>
            
            <div class="field">
                <span class="label">Statut:</span>
                <span class="value statut en-attente">${demande.statut}</span>
            </div>
            
            <div class="field">
                <span class="label">ID Collaborateur:</span>
                <span class="value">${demande.collaborateur.id}</span>
            </div>
        </div>
        
        <h3>Informations techniques:</h3>
        <ul>
            <li>URL appelée: <code>/ddc/detailDdc?ddcId=${demande.id}</code></li>
            <li>Controller: DetailDdcController</li>
            <li>Paramètre récupéré: ddcId=${demande.id}</li>
            <li>Service utilisé: DemandeCongeServiceMock</li>
        </ul>
    </c:if>
    
    <c:if test="${empty demande}">
        <p style="color: #f44336; font-weight: bold;">
            ❌ Demande non trouvée. Vérifiez l'ID.
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/ddc/listerDdc">
                Voir toutes les demandes disponibles
            </a>
        </p>
    </c:if>
    
    <hr>
    <p><small>TP4 - Récupération des paramètres d'une requête</small></p>
</body>
</html>