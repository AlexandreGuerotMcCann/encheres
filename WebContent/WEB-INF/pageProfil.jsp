<%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<title>Profil de ${pseudo}</title>
</head>
<body>

	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletMonProfil">Mon profil</a></li>
			<li><a href="ServletAccueil">Déconnexion</a></li>




		</ul>

	</div>

	<h1>Mes informations</h1>
	<div class="rechercheProfil">
		<input id="searchsize" type="text" placeholder="Rechercher un profil par pseudo">
	</div>
	<div class="infosUtilisateur">

	
		<p>Pseudo : ${utilisateur.pseudo}</p>
		<p>Nom : ${utilisateur.nom}</p>
		<p>Prénom : ${utilisateur.prenom}</p>
		<p>Email : ${utilisateur.email}</p>
		<p>Téléphone : ${utilisateur.telephone}</p>
		<p>Rue : ${utilisateur.rue}</p>
		<p>Code postal : ${utilisateur.code_postal}</p>
		<p>Ville : ${utilisateur.ville}</p>
	</div>

	<div class="suppressionCompte">Suppression de compte</div>
</body>

<footer> Copyright 2021 des fifous du net © </footer>
</html>