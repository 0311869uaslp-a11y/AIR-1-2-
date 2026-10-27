<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nouveau Formulaire - Demande de Congé</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; font-weight: bold; color: #333; }
        input, select, textarea { 
            width: 100%; padding: 10px; border: 2px solid #ddd; border-radius: 5px;
            box-sizing: border-box; font-size: 16px;
        }
        input:focus, select:focus, textarea:focus { border-color: #4CAF50; outline: none; }
        .btn { 
            background: #4CAF50; color: white; padding: 12px 25px; 
            border: none; border-radius: 5px; cursor: pointer; font-size: 16px;
            margin-right: 10px; margin-top: 10px;
        }
        .btn:hover { background: #45a049; }
        .btn-reset { background: #ff9800; }
        .btn-reset:hover { background: #e68900; }
        .btn-cancel { background: #f44336; }
        .btn-cancel:hover { background: #da190b; }
        .message { 
            padding: 15px; margin: 20px 0; border-radius: 5px; 
            font-weight: bold; text-align: center;
        }
        .success { background: #d4edda; color: #155724; border: 1px solid #c3e6cb; }
        .error { background: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }
        .info { background: #d1ecf1; color: #0c5460; border: 1px solid #bee5eb; }
        .debug-info { background: #f8f9fa; padding: 15px; border-left: 4px solid #007bff; margin: 20px 0; }
        h1 { color: #2c3e50; border-bottom: 3px solid #4CAF50; padding-bottom: 10px; }
        .menu { margin-bottom: 30px; }
        .menu a { 
            margin-right: 15px; text-decoration: none; color: #3498db; 
            font-weight: bold; padding: 5px 10px; border-radius: 3px;
        }
        .menu a:hover { background: #ecf0f1; }
    </style>
</head>
<body>
    <div class="container">
        <h1>📝 Nouveau Formulaire - Demande de Congé</h1>
        
        <div class="menu">
            <a href="${pageContext.request.contextPath}/ddc/home">🏠 Accueil</a> |
            <a href="${pageContext.request.contextPath}/ddc/listerDdc">📋 Liste</a> |
            <a href="${pageContext.request.contextPath}/nouveauDdc/form">🆕 Nouveau Formulaire</a> |
            <a href="${pageContext.request.contextPath}/nouveauDdc/test">🧪 Test</a>
        </div>
        
        <!-- Mensajes -->
        <c:if test="${not empty success}">
            <div class="message success">✅ ${success}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="message error">❌ ${error}</div>
        </c:if>
        
        <div class="debug-info">
            <h3>ℹ️ Información de Debug</h3>
            <p><strong>URL del formulario:</strong> ${pageContext.request.contextPath}/nouveauDdc/submit</p>
            <p><strong>Controlador:</strong> CreerDdcController (ruta /nouveauDdc)</p>
            <p><strong>Fecha actual:</strong> ${now}</p>
            <p><strong>Número de collaborateurs:</strong> ${collaborateurs.size()}</p>
        </div>
        
        <!-- FORMULARIO SIMPLIFICADO -->
        <!-- FORMULARIO MEJORADO -->
<form method="POST" action="${pageContext.request.contextPath}/nouveauDdc/submit">
    
    <h3>1. Collaborateur</h3>
    <div class="form-group">
        <label for="collaborateurId">Collaborateur *</label>
        
        <!-- Mostrar si la lista está vacía -->
        <c:choose>
            <c:when test="${empty collaborateurs}">
                <div style="color: #d9534f; padding: 10px; background: #f2dede; border-radius: 4px;">
                    ⚠️ Aucun collaborateur disponible!
                </div>
                <!-- Valores fijos para prueba -->
                <input type="hidden" name="collaborateurId" value="1">
                <p>Collaborateur par défaut: Jean Dupont (IT)</p>
            </c:when>
            <c:otherwise>
                <select name="collaborateurId" id="collaborateurId" required>
                    <option value="">-- Sélectionnez (${collaborateurs.size()} disponibles) --</option>
                    <c:forEach var="collab" items="${collaborateurs}">
                        <option value="${collab.id}">
                            ${collab.id} - ${collab.nom} ${collab.prenom} (${collab.departement})
                        </option>
                    </c:forEach>
                </select>
                <small>${collaborateurs.size()} collaborateurs disponibles</small>
                
                <!-- Script para seleccionar automáticamente el primero -->
                <script>
                    document.addEventListener('DOMContentLoaded', function() {
                        var select = document.getElementById('collaborateurId');
                        if (select && select.options.length > 1) {
                            select.value = select.options[1].value; // Selecciona el primero
                        }
                    });
                </script>
            </c:otherwise>
        </c:choose>
    </div>
    
    <h3>2. Type de congé</h3>
    <div class="form-group">
        <label for="typeDdc">Type de congé *</label>
        <select name="typeDdc" id="typeDdc" required>
            <option value="">-- Sélectionnez --</option>
            <option value="CONGE_PAYE" selected>Congé payé</option>
            <option value="RTT">RTT</option>
            <option value="CONGE_SANS_SOLDE">Congé sans solde</option>
            <option value="CONGE_MATERNITE">Congé maternité</option>
            <option value="CONGE_PATERNITE">Congé paternité</option>
        </select>
    </div>
    
    <h3>3. Dates</h3>
    <div class="form-group">
        <label for="dateDebut">Date de début *</label>
        <input type="text" name="dateDebut" id="dateDebut" 
               placeholder="jj/mm/aaaa" value="15/12/2025" required>
    </div>
    
    <div class="form-group">
        <label for="nbJours">Nombre de jours *</label>
        <input type="number" name="nbJours" id="nbJours" 
               min="1" max="30" value="5" required>
    </div>
    
    <h3>4. Commentaire</h3>
    <div class="form-group">
        <label for="commentaire">Commentaire</label>
        <textarea name="commentaire" id="commentaire" rows="4">Vacances annuelles</textarea>
    </div>
    
    <div class="form-group">
        <button type="submit" class="btn">✅ Soumettre</button>
        <button type="reset" class="btn btn-reset">🔄 Réinitialiser</button>
    </div>
</form>

<!-- Debug Info -->
<div style="margin-top: 30px; padding: 15px; background: #e8f4f8; border-radius: 5px;">
    <h4>🔍 Debug Information</h4>
    <p><strong>collaborateurs en session:</strong> ${not empty collaborateurs ? collaborateurs.size() : 'NULL'}</p>
    <p><strong>URL:</strong> ${pageContext.request.contextPath}/nouveauDdc/submit</p>
    
    <c:if test="${not empty collaborateurs}">
        <p><strong>Liste des collaborateurs:</strong></p>
        <ul>
            <c:forEach var="collab" items="${collaborateurs}">
                <li>${collab.id}: ${collab.nom} ${collab.prenom}</li>
            </c:forEach>
        </ul>
    </c:if>
</div>
        
        <!-- Información de prueba -->
        <div class="debug-info">
            <h3>🧪 Pour tester rapidement:</h3>
            <p>1. Sélectionnez "Jean Dupont (IT)" (ID: 1)</p>
            <p>2. Choisissez "Congé payé"</p>
            <p>3. Date: 15/12/2025</p>
            <p>4. Jours: 5</p>
            <p>5. Cliquez sur "Soumettre"</p>
            <p><a href="${pageContext.request.contextPath}/nouveauDdc/test">➡️ Ou utilisez le formulaire de test pré-rempli</a></p>
        </div>
        
        <hr>
        <p style="text-align: center; color: #7f8c8d; font-size: 0.9em;">
            TP5 - Spring MVC | Nouveau Formulaire | Ruta: /nouveauDdc
        </p>
    </div>
    
    <script>
        // Seleccionar valores por defecto para pruebas
        document.addEventListener('DOMContentLoaded', function() {
            // Seleccionar primer colaborador
            document.getElementById('collaborateurId').value = '1';
            // Seleccionar CONGE_PAYE
            document.getElementById('typeDdc').value = 'CONGE_PAYE';
        });
    </script>
</body>
</html>