<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifier mon profil</title>
</head>
<body>

	<div class="logo">
		<a href="accueil"><img src="images/logoProjet.png" alt="accueil" height="80" width="150"></img></a>
	</div>


	<h1>Mon Profil</h1>
<form action="ServletModifierProfil" method="post">
		<div class="left_text">
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo" value="${utilisateur.pseudo}">
			
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" value="${utilisateur.prenom }">
			
			<label for="telephone">Téléphone :</label>
			<input type="tel" name="telephone" value="${utilisateur.telephone }">
			
			<label for="codePostal">Code Postal :</label>
			<input type="text" name="codePostal" value="${utilisateur.codePostal }">
			
			<label for="motdepasse">Mot de passe actuel :</label>
			<input type="password" name="motdepasse">
			
			<label for="nouveau_motdepasse">Nouveau mot de passe :</label>
			<input type="password" name="nouveau_motdepasse">
			
			<p>Crédit : ${utilisateur.credit }</p>
		</div>
	 
		<div class="right_text">
			<label for="nom">Nom :</label>
			<input type="text" name="nom" value="${utilisateur.nom}">
			
			<label for="email">E-mail :</label>
			<input type="email" name="email" value="${utilisateur.email}">
			
			<label for="rue">Rue :</label>
			<input type="text" name="rue" value="${utilisateur.rue}">
			
			<label for="ville">Ville :</label>
			<input type="text" name="ville" value="${utilisateur.ville}">


			<label for="confirmation_mdp">Confirmation : 
			<input type="password" name="confirmation_mdp"></label>
		</div>
		
		<button class="button" type="submit" name="modifier">Enregistrer</button> <!-- A faire : inclure méthode UPDATE compte -->
		<button class="button"type="submit"onclick="ServletModifierProfil"name="supprimer">Supprimer mon profil</button>
	<a href="ServletModifierProfil" class="button"> <input type="submit" class="button" value="SupprimerTestCamille"></input></a>
	
	<!--	<a href="ServletModifierProfil" class="button">Supprimer mon compte</a> <!-- Redirige vers ServletSupprimerUtilisateur
			 <input type="submit" class="button" value="Connexion"></input></a>
			 -->
			</form>
</body>
</html>