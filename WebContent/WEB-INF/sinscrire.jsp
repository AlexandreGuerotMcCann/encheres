<%@page import="java.util.HashMap"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.servlet.ServletSinscrire"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="test.css">
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<title>S'inscrire</title>
</head>

<body>

	<div class="logo">
		<a href="accueil"><img src="images/logoProjet.png" alt="accueil"
			height="80" width="150"></img></a>
	</div>

	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn"> MENU <i class="fa fa-bars" aria-hidden="true"></i></button>
			<div class="dropdown-content">
				<a href="ServletEncheres">Encheres</a> 
				<a href="ServletVendreArticle">Vendre</a> 
				<a href="ServletConnexion">Se connecter</a> 
				<a href="ServletSinscrire">S'inscrire</a>
			</div>
		</div>
	</div>


	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletConnexion">Se connecter</a></li>
			<li><a href="ServletSinscrire">S'inscrire</a></li>

		</ul>

	</div>

	<br>
	<h1>ENI Enchères</h1>

	<h2>Création d'un nouveau compte</h2>

	<!-- INTEGRER LES MESSAGES D ERREURS -->
	<c:if test="${erreur != 0}"> 
		<p>${listeErreurs}</p>
	</c:if>

	<form action="ServletSinscrire" method="post" name="connexion">

		<div class="wrapper">

			<label for="pseudo">Pseudo: </label> 
			<input type="text" required id="pseudo" name="pseudo" maxlength="30" size="15"> 
			
			<label for="mdp">Mot de passe: </label> 
			<input type="password" required id="mdp" name="mdp" min="8" maxlength="30" size="15"> 
			<label for="mdp">Confirmation Mot de passe: </label> <input type="Password"
				required id="confirmMdp" name="confirmMdp" min="8" maxlength="30"
				size="15"> <label for="name">Nom: </label> <input
				type="text" required id="nom" name="nom" maxlength="30" size="15">

			<label for="prenom">Prénom: </label> <input type="text" required
				id="prenom" name="prenom" maxlength="30" size="15"> <label
				for="mail">Email: </label> <input type="email" required id="mail"
				name="mail" placeholder="abcd@exemple.fr" maxlength="50" size="25">

			<label for="telephone">Téléphone: </label> <input type="tel" required
				id="telephone" name="telephone" placeholder="0123456789"
				maxlength="10" size="15"> <label for="rue">Rue: </label> <input
				type="text" required id="rue" name="rue" maxlength="30" size="15">

			<label for="codePostal">Code postal: </label> <input type="text"
				required id="codePostal" name="codePostal" placeholder="35000"
				min="5" maxlength="5" size="15"> <label for="ville">Ville:
			</label> <input type="text" required id="ville" name="ville" maxlength="50"
				size="15">

			<button class="button" type="button" name="annuler"
				onclick="window.location.href='http://localhost:8080/projetEncheres/accueil';">
				Annuler</button>

			<button class="button" type="submit" name="sinscrire"
				onclick="ServletSinscrire">S'inscrire</button>


		</div>

	</form>
</body>
<br>

<footer> Copyright 2021 des fifous du net © </footer>
</html>