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
	<c:if test="${!empty requestScope.erreurMDP}"> 
		<p>${erreurMDP}</p>
	</c:if>
	
	<c:if test="${!empty requestScope.pseudoBDD}"> 
		<p>${pseudoBDD}</p>
	</c:if>
	
	<c:if test="${!empty requestScope.mailBDD}"> 
		<p>${mailBDD}</p>
	</c:if>
	
	<c:if test="${!empty requestScope.telephoneBDD}"> 
		<p>${telephoneBDD}</p>
	</c:if>
	

	<form action="ServletSinscrire" method="post" name="connexion">

		<div class="wrapper">

			<label for="pseudo">Pseudo: </label> 
			<input type="text" required id="pseudo" name="pseudo" pattern=".{1,30}.[A-Za-z0-9 -]" size="30" 
			title="Le pseudo doit contenir entre 3 et 30 caractères alphanumériques." /> 
			
			<label for="mdp">Mot de passe: </label> 
			<input type="password" required id="mdp" name="mdp" pattern=".{6,30}.[A-Za-z0-9]" size="30"
			title="Le mot de passe doit contenir au moins 8 caractères alphanumériques (les symboles ne sont pas acceptés)."/> 
			
			<label for="mdp">Confirmation Mot de passe: </label> 
			<input type="Password" required id="confirmMdp" name="confirmMdp" size="30"/> 
			
			<label for="name">Nom: </label> 
			<input type="text" required id="nom" name="nom" pattern=".{1,30}.[A-Za-z -]" size="30"
			title="Votre nom ne doit pas excéder 30 caractères."/> 
			
			<label for="prenom">Prénom: </label> 
			<input type="text" required id="prenom" name="prenom" pattern=".{1,30}.[A-Za-z -]" size="30" 
			title="Votre prénom ne doit pas excéder 30 caractères."/> 
			
			<label for="mail">Email: </label> 
			<input type="email" required id="mail" name="mail" placeholder="email@exemple.fr" maxlength="50" size="50"
			title="Votre e-mail ne doit pas excéder 50 caractères."/> 
			
			<label for="telephone">Téléphone: </label> 
			<input type="tel" required id="telephone" name="telephone" placeholder="0600000000" pattern=".{8}.[0-9]" size="30" 
			title="10 caractères numériques sont attendus."/> 
			
			<label for="rue">Rue: </label> 
			<input type="text" required id="rue" name="rue" pattern=".{1,30}.[A-Za-z0-9 -]" size="30"
			title="La rue ne doit pas excéder 30 caractères (les caractères spéciaux ne sont pas acceptés. Seuls les - et les espaces sont permis)."/>

			<label for="codePostal">Code postal: </label> 
			<input type="text" required id="codePostal" name="codePostal" placeholder="35000" pattern=".{3}.[0-9]" size="30"
			title="5 caractères numériques sont attendus."/> 
			
			<label for="ville">Ville: </label> 
			<input type="text" required id="ville" name="ville" pattern=".{1,50}.[A-Za-z -]" size="50"
			title="La ville ne doit pas excéder 50 caractères. (Les caractères spéciaux ne sont pas acceptés. Seuls les - et les espaces sont permis)."/>


			<button class="button" type="button" name="annuler" onclick="window.location.href='http://localhost:8080/projetEncheres/accueil';">
				Annuler</button>

			<button class="button" type="submit" name="sinscrire"
				onclick="ServletSinscrire">S'inscrire</button>


		</div>

	</form>
</body>
<br>

<footer> Copyright 2021 des fifous du net © </footer>
</html>