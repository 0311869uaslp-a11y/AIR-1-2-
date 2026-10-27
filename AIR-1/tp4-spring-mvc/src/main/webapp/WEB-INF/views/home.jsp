<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil - Gestion Congés</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .header { background: #4CAF50; color: white; padding: 10px 20px; }
        .menu { margin: 20px 0; }
        .menu a { margin-right: 15px; text-decoration: none; color: #0066cc; }
        .content { background: #f9f9f9; padding: 20px; border-radius: 5px; }
    </style>
</head>
<body>
    <div class="header">
        <h1>Application de Gestion des Congés</h1>
    </div>
    
    <div class="menu">
        <a href="${pageContext.request.contextPath}/ddc/home">Accueil</a> |
        <a href="${pageContext.request.contextPath}/ddc/listerDdc">📋 Lister Demandes</a> |
        <a href="${pageContext.request.contextPath}/">🏠 Retour à l'index</a>
    </div>
    
    <div class="content">
        <h2>Page d'Accueil</h2>
        <p>Bienvenue dans le système de gestion des demandes de congés.</p>
        
        <h3>Fonctionnalités:</h3>
        <ul>
            <li>Consulter la liste des demandes de congés</li>
            <li>Voir le détail d'une demande spécifique</li>
            <li>Gérer l'état des demandes (à venir dans TP5)</li>
        </ul>
        
        <h3>Test des contrôleurs:</h3>
        <p>
            <a href="${pageContext.request.contextPath}/ddc/listerDdc" 
               style="background: #4CAF50; color: white; padding: 10px 15px; text-decoration: none; border-radius: 4px;">
               Voir toutes les demandes
            </a>
        </p>
        
        <h3>Test détail demande:</h3>
        <p>
            <a href="${pageContext.request.contextPath}/ddc/detailDdc?ddcId=1">Demande #1</a> |
            <a href="${pageContext.request.contextPath}/ddc/detailDdc?ddcId=2">Demande #2</a> |
            <a href="${pageContext.request.contextPath}/ddc/detailDdc?ddcId=3">Demande #3</a>
        </p>
    </div>
    
    <hr>
    <p><small>TP4 Spring MVC - Détection automatique des contrôleurs</small></p>
</body>
</html>