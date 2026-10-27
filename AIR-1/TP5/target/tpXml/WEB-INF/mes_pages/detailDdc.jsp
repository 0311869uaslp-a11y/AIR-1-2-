<%@page contentType="text/html"%>
<%@include file="/WEB-INF/mes_pages/include.jsp" %>

<html>
	<body>
		<h2>Détail de la demande de congés numéro ${demandeConge.numero}</h2>
		
		<a href="http://localhost:8080/ddc/listerDdc">Retour</a>

		<br/>
		<br/>
		<!-- accès au modèle en JSTL -->
		Date de début : <c:out value="${demandeConge.periode.dateDebut}"/>
		<br/>
		<!-- ou directement... -->
		Nombre de jours : ${demandeConge.periode.nbJours}
		<br/>
		Collaborateur : ${demandeConge.collaborateur.prenom} ${demandeConge.collaborateur.nom}
	</body>
</html>