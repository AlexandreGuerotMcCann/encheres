<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Description vente</title>

</head>
<body>

	<div class="logo">
		<a href="ServletAccueil"><img src="images/logoProjet.png"
			alt="accueil" height="80" width="150"></img></a>
	</div>

	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">
				MENU <i class="fa fa-bars" aria-hidden="true"></i>
			</button>
			<div class="dropdown-content">
				<a href="ServletEncheres">Encheres</a> 
				
				 <c:if test="${!empty utilisateur.pseudo}">
				<a href="ServletVendreArticle">Vendre</a>
				</c:if>
				
				<c:if test="${empty utilisateur.pseudo}">
					<a href="ServletConnexion">Se connecter</a>
					<a href="ServletSinscrire">S'inscrire</a>
				</c:if>
				<c:if test="${!empty utilisateur.pseudo}">
					<!-- Si utilisateur connecté, bouton "Se déconnecter" visible et actif -->
					<a href="ServletDeconnexion">Se déconnecter</a>
				</c:if>


			</div>
		</div>
	</div>

	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			 <c:if test="${!empty utilisateur.pseudo}">
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			</c:if>

			<c:if test="${empty utilisateur.pseudo}">
				<!-- Si utilisateur non connecté, boutons "Se connecter" & "S'inscrire" visibles et actifs -->
				<li><a href="ServletConnexion">Se connecter</a></li>
				<li><a href="ServletSinscrire">S'inscrire</a></li>
			</c:if>

			<c:if test="${!empty utilisateur.pseudo}">
				<!-- Si utilisateur connecté, bouton "Mon profil" visible et actif -->
				<li><a href="ServletMonProfil">Mon profil</a></li>
			</c:if>

			<c:if test="${!empty utilisateur.pseudo}">
				<!-- Si utilisateur connecté, bouton "Se déconnecter" visible et actif -->
				<li><a href="ServletDeconnexion">Se déconnecter</a></li>
			</c:if>

		</ul>
	</div>
</head>
<body>
		<div class="modifProfil1">
		<p>Pseudo : </p>
		<p>Nom : </p>>
		<p>Prénom : </p>
		<p>Email : </p>
		<p>Téléphone :</p>
		<p>Rue : </p>
		<p>Code postal : </p>
		<p>Ville :</p>
		</div>



</body>
</html>