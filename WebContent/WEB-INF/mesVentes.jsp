<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="fr.eni.encheres.bo.Utilisateur"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<title>Vente d'article(s)</title>
</head>
<body>

	<div class="logo">
		<a href="ServletAccueil"><img src="images/logoProjet.png" alt="accueil" height="80" width="150"></img></a>
	</div>
	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletMonProfil">Mon profil</a></li>
			<c:if test="${!empty utilisateur.pseudo}">
			<li><a href="ServletAccueil">Déconnexion</a></li>
			</c:if>

		</ul>



	</div>


</body>

<footer> Copyright 2021 des fifous du net © </footer> 
</html>