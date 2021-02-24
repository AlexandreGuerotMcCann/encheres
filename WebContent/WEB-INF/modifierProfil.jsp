<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<title>Modifier mon profil</title>
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


	<h2>Mon Profil</h2>
<form action="ServletModifierProfil" method="post">
	<div class="wrapper" >
		<div class="left_text">
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo"maxlength="30" size="15" value="${utilisateur.pseudo}">
			
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" maxlength="30" size="15"value="${utilisateur.prenom }">
			
			<label for="telephone">Téléphone :</label>
			<input type="tel" name="telephone" maxlength="30" size="15" value="${utilisateur.telephone }">
			
			<label for="codePostal">Code Postal :</label>
			<input type="text" name="codePostal"maxlength="30" size="15" value="${utilisateur.codePostal }">
			
			<label for="motdepasse">Mot de passe actuel :</label>
			<input type="password"maxlength="30" size="15" name="motdepasse">
			
			<label for="nouveau_motdepasse">Nouveau mot de passe :</label>
			<input type="password" maxlength="30" size="15"name="nouveau_motdepasse">
			
			<p>Crédit : ${utilisateur.credit }</p>
		</div>
	 
		<div class="right_text">
			<label for="nom">Nom :</label>
			<input type="text" name="nom" maxlength="30" size="15"value="${utilisateur.nom}">
			
			<label for="email">E-mail :</label>
			<input type="email" name="email" maxlength="30" size="15"value="${utilisateur.email}">
			
			<label for="rue">Rue :</label>
			<input type="text" name="rue" maxlength="30" size="15"value="${utilisateur.rue}">
			
			<label for="ville">Ville :</label>
			<input type="text" name="ville" maxlength="30" size="15"value="${utilisateur.ville}">


			<label for="confirmation_mdp">Confirmation : 
			<input type="password" maxlength="30" size="15"name="confirmation_mdp"></label>
		</div>
		
		<button class="button" type="submit" onclick="ServletModifierProfil"name="modifier">Enregistrer les modifications</button> <!-- A faire : inclure méthode UPDATE compte -->
		<button class="button" type="submit" onclick="ServletModifierProfil"name="supprimer">Supprimer mon profil</button>
	
	<!--	<a href="ServletModifierProfil" class="button">Supprimer mon compte</a> <!-- Redirige vers ServletSupprimerUtilisateur
			 <input type="submit" class="button" value="Connexion"></input></a>
			 -->
			</div>
			</form>
</body>
</html>