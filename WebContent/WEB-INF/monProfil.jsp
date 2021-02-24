<%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Profil de ${utilisateur.pseudo}</title>
</head>

<body>

	<div class="logo">
		<a href="accueil"><img src="images/logoProjet.png" alt="accueil" height="80" width="150"></img></a>
	</div>
	
	<div class="navbar">
  <div class="dropdown">
    <button class="dropbtn">MENU
     <i class="fa fa-bars" aria-hidden="true"></i>
    </button>
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
			<li><a href="ServletMonProfil">Mon profil</a></li>
			<li><a href="ServletDeconnexion">Déconnexion</a></li>
		</ul>
	</div>


	<h1 class="titre" >Mes informations</h1>
	<div class="rechercheProfil">
		<input id="searchsize2" type="text" placeholder="Rechercher un profil par pseudo...">
	</div>
	<div class="infosUtilisateur">
   
	
		<p>Pseudo : ${utilisateur.pseudo}</p>
		<p>Nom : ${utilisateur.nom}</p>
		<p>Prénom : ${utilisateur.prenom}</p>
		<p>Email : ${utilisateur.email}</p>
		<p>Téléphone : ${utilisateur.telephone}</p>
		<p>Rue : ${utilisateur.rue}</p>
		<p>Code postal : ${utilisateur.codePostal}</p>
		<p>Ville : ${utilisateur.ville}</p>
		 
		<br>		
			<a href="ServletModifierProfil" class="button">Modifier</a> <!-- Redirige vers la servletModifierProfil qui envoie vers modifierProfil.jsp -->

	</div>
	
</body>

<footer> Copyright 2021 des fifous du net © </footer>
</html>