<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<meta charset="UTF-8">
<title>Erreur</title>
</head>
<!-- TODO :: CODE 
+ redirection vers page authentification
+Redirection vers mot de passe oublié -->
<body>

	<div class="logo">
		<a href="accueil"><img src="images/logoProjet.png" alt="accueil"
			height="80" width="150"></img></a>
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
			
		<c:if test="${empty utilisateur.pseudo}">	<!-- Si utilisateur non connecté, boutons "Se connecter" & "S'inscrire" visibles et actifs -->
			<li><a href="ServletConnexion">Se connecter</a></li>
			<li><a href="ServletSinscrire">S'inscrire</a></li>	
		</c:if>	
		
		<c:if test="${!empty utilisateur.pseudo}">	<!-- Si utilisateur connecté, bouton "Mon profil" visible et actif -->
			<li><a href="ServletMonProfil">Mon profil</a></li>
		</c:if>	
		
		<c:if test="${!empty utilisateur.pseudo}">	<!-- Si utilisateur connecté, bouton "Se déconnecter" visible et actif -->
			<li><a href="ServletDeconnexion">Se déconnecter</a></li>
		</c:if>
			
		</ul>
	</div>
	<p class="erreur2">
		<a href="ServletConnexion"style="color:#ff6961;" > Erreur lors de la connection, veuillez
			réessayer.</a>
	</p>


</body>

<footer> Copyright 2021 des fifous du net © </footer>
</html>