<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TP4 - Spring MVC</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1 { color: #333; }
        .menu { margin: 20px 0; padding: 10px; background: #f5f5f5; }
        .menu a { margin-right: 15px; text-decoration: none; color: #0066cc; }
        .menu a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>TP4 - Premiers pas avec Spring MVC</h1>
    
    <div class="menu">
        <a href="${pageContext.request.contextPath}/ddc/home">Accueil</a> |
        <a href="${pageContext.request.contextPath}/ddc/listerDdc">Lister Demandes</a>
    </div>
    
    <h2>Bienvenue dans l'application de gestion des congés</h2>
    
    <p>Cette application démontre:</p>
    <ul>
        <li>Contrôleurs Spring MVC avec annotations</li>
        <li>Récupération de paramètres de requête</li>
        <li>Utilisation des Beans du contexte Spring</li>
        <li>Vues JSP avec JSTL</li>
    </ul>
    
    <hr>
    <p><strong>URLs disponibles:</strong></p>
    <ul>
        <li><code>/ddc/home</code> - Page d'accueil (HomeController)</li>
        <li><code>/ddc/listerDdc</code> - Liste des demandes (ListerDdcController)</li>
        <li><code>/ddc/detailDdc?ddcId=1</code> - Détail d'une demande</li>
    </ul>
</body>
</html>