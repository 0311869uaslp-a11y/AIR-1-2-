<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/mes_pages/include.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Créer une demande de congés</title>

    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 10px;
        }

        .subtitle {
            color: #555;
            margin-bottom: 20px;
        }

        a.back {
            display: inline-block;
            margin-bottom: 20px;
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        td {
            padding: 10px;
            vertical-align: top;
        }

        input, select {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-top: 5px;
        }

        input[type="submit"] {
            width: auto;
            background-color: #3498db;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 15px;
            cursor: pointer;
            border-radius: 6px;
        }

        input[type="submit"]:hover {
            background-color: #217dbb;
        }

        .error {
            color: #c0392b;
            background-color: #fdecea;
            border: 1px solid #f5c6cb;
            padding: 10px;
            border-radius: 6px;
            margin-bottom: 20px;
        }

        .field-error {
            color: #c0392b;
            font-size: 0.85em;
            margin-top: 4px;
            display: block;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Créer une demande de congés</h2>
    <div class="subtitle">Formulaire de création</div>

    <a class="back" href="${pageContext.request.contextPath}/ddc/home">
        ← Retour à l'accueil
    </a>

    <p>Nous sommes le <strong>${now}</strong>.</p>

    <form:errors path="*" cssClass="error" element="div"/>

    <form:form modelAttribute="demandeConge"
               method="post"
               action="${pageContext.request.contextPath}/ddc/creerDdc/form">

        <label><strong>Type de congé</strong></label>
        <form:select path="type" items="${typeDdc}"/>
        <form:errors path="type" cssClass="field-error"/>

        <form:hidden path="numero"/>

        <h4>Période</h4>
        <table>
            <tr>
                <td>
                    Date début (JJ/MM/AAAA)
                    <form:input path="periode.dateDebut" placeholder="10/01/2025"/>
                    <form:errors path="periode.dateDebut" cssClass="field-error"/>
                </td>
                <td>
                    Nombre de jours
                    <form:input path="periode.nbJours" type="number" min="1"/>
                    <form:errors path="periode.nbJours" cssClass="field-error"/>
                </td>
            </tr>
        </table>

        <h4>Collaborateur</h4>
        <table>
            <tr>
                <td>
                    Prénom
                    <form:input path="collaborateur.prenom"/>
                    <form:errors path="collaborateur.prenom" cssClass="field-error"/>
                </td>
                <td>
                    Nom
                    <form:input path="collaborateur.nom"/>
                    <form:errors path="collaborateur.nom" cssClass="field-error"/>
                </td>
            </tr>
        </table>

        <input type="submit" value="Valider"/>

    </form:form>

</div>

</body>
</html>
