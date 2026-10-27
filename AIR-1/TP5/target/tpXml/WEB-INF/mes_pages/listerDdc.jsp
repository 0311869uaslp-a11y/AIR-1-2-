<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<body>
		<h2>Liste de mes demandes de congés</h2>
		
		<a href="http://localhost:8080/ddc/home">Retour</a>
	
		<ul>
			<li><a href="http://localhost:8080/ddc/detailDdc?ddcId=1">Demande n°1 du xx/yy/zzz</a>, validée le xx/yy/zzz</li>
			<li><a href="http://localhost:8080/ddc/detailDdc?ddcId=2">Demande n°2 du xx/yy/zzz</a>, refusée le xx/yy/zzz</li>
			<li><a href="http://localhost:8080/ddc/detailDdc?ddcId=3">Demande n°3 du xx/yy/zzz</a>, validée le xx/yy/zzz</li>
		</ul>
		
		
	</body>
</html>