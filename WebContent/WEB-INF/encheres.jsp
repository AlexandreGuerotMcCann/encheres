<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Enchères</title>
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
    
    <!--  <div class="dropdown-content">
      <a href="ServletEncheres">Encheres</a>
      <a href="ServletVendreArticle">Vendre</a>
      <a href="ServletConnexion">Se connecter</a>
      <a href="ServletSinscrire">S'inscrire</a>

    </div> -->
    </div>
  </div> 

	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			
		<c:if test="${!empty utilisateur.pseudo}">
			<li><a href="ServletMonProfil">Mon profil</a></li>
			<li><a href="ServletAccueil">Déconnexion</a></li>
		</c:if>
		</ul>

	</div>
	
	<h2>Liste des enchères</h2>
	
	<br>
	
	<c:if test="${empty utilisateur.pseudo}">	<!-- Test pour afficher un message si utilisateur non connecté -->
		<h3>Vous n'êtes pas connecté.</h3>
	</c:if>  
	
	<form>
		<div>
		<div class="wrapper3" style="float:center;">
			<label>Filtres :</label> 
			<br> 
			<span class="checkbox"><input type="checkbox" id="checkbox"> Enchères ouvertes</span> 
			<span class="checkbox"><input type="checkbox" id="checkbox"> Ventes en cours</span> 
			<span class="checkbox"><input type="checkbox" class="checkbox"> Ventes terminées</span>
			<br>
			<label>Catégories: </label> 
			
			<select id="categorie" name="categorie">
				<option value="0">--</option>
				<option value="1">Décoration</option>
				<option value="2">Mobilier</option>
				<option value="3">Extérieur</option>
				<option value="4">Textile</option>
				<option value="5">Jeux</option>
				<option value="6">Motorisés</option>
			</select> 
			
		</div>
	
	<h2>ARTICLES</h2>
	
    <div class="wrapper5"> 
     	<!--  TEST pour présentation de la page -> faire afficher articles de la BDD sur cette page <a href="#"><img src="images/lampe.png" alt="articleLampe" height="120" width="150"></img></a>-->

	</div>
		
		<div class="wrapper6">
 
			

		</div>
		
		<div class="wrapper7">
			
		</div>
		
	</div>

	</form>


</body>

<footer> Copyright 2021 des fifous du net © </footer> 
</html>