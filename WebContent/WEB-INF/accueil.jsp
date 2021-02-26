<%@page import="java.util.*"%>
<%@page import="java.awt.List"%>
<%@page import="org.apache.catalina.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="fr.eni.encheres.servlet.ServletAccueil"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->  
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Accueil</title>

</head>
<body>

	<div class="logo">
		<a href="ServletAccueil"><img src="images/logoProjet.png" alt="accueil"
			height="80" width="150"></img></a>
	</div>

	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">
				MENU <i class="fa fa-bars" aria-hidden="true"></i>
			</button>
			<div class="dropdown-content">
				<a href="ServletEncheres">Encheres</a> <a
					href="ServletVendreArticle">Vendre</a> <a href="ServletConnexion">Se
					connecter</a> <a href="ServletSinscrire">S'inscrire</a>
			</div>
		</div>
	</div>

	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>

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



	<br>

	<h1>ENI Enchères</h1>

	<h2>Liste des enchères</h2> 

	<br>

	<c:if test="${empty utilisateur.pseudo}">
		<!-- Affiche un message si utilisateur non connecté -->
		<h3>Vous n'êtes pas connecté(e).</h3>
	</c:if>

	<c:if test="${!empty utilisateur.pseudo}">
		<!-- Affiche un message si utilisateur connecté -->
		<h3>Connecté en tant que "${utilisateur.pseudo}"</h3>
	</c:if>

	<form>
		<div>
		
		
		
			<div class="wrapper3" style="float: left;">
				<label style="font-weight:1000;">Filtres :</label> <br> <input id="searchsize"
					type="text" placeholder="Rechercher une enchère..." style="font-size:25px;"> <br> <label style="font-weight:1000;">Catégories:
				</label> <select id="categorie" name="categorie">
				<option value="0">Selectionnez</option>
					<option value="0">Decoration</option>
				<option value="0">Textile</option>
				<option value="0">Jeux</option>
				<option value="0">Mobilier</option>
				<option value="0">Immobilier</option>
				
				</select> <span style="font-weight:1000;"><input type="radio" name="achats" style="height:30px; width:30px; vertical-align: middle;" /> Achats</span> <span style="font-weight:1000;"><input
					type="radio" name="achats" style="height:30px; width:30px; vertical-align: middle;" /> Ventes</span> <span class="checkbox"><input
					type="checkbox" id="checkbox"> Enchères ouvertes</span> <span
					class="checkbox"><input type="checkbox" id="checkbox">
					Mes Ventes en cours</span> <span class="checkbox"><input
					type="checkbox"> Mes enchères en cours</span> <span
					class="checkbox"><input type="checkbox" class="checkbox">
					Ventes non débutées</span> <span class="checkbox"><input
					type="checkbox" class="checkbox"> Mes enchères remportées</span> <span
					class="checkbox"><input type="checkbox" class="checkbox">
					Ventes terminées</span>
			</div>

		</div>
		

	</form>


<p>
	
		<c:if test="${empty listeArticlesVendus }">
			<h3>Aucun article en vente actuellement. Revenez un peu plus
				tard. Vous pouvez aussi vendre un article.</h3>
		</c:if>
		
		
		<c:forEach items="${listeArticlesVendus}" var="article">
   ${article.nomArticle}<br>
   ${article.miseAPrix}<br>
   dateFinEncheres = ${article.dateFinEncheres}<br>
   vendeur= ${article.noUtilisateur}<br>
		</c:forEach>
	

	</p>

	

	
	</body>
	
	<!-- DEUX LETTRES -->
	
	<footer> Copyright 2021 des fifous du net © </footer> 
	</html>

