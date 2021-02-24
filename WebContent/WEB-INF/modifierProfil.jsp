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

		<div class="left_text">
			<label for="pseudo">Pseudo :
			<input type="text" name="pseudo" value="${utilisateur.pseudo}"></label>
			
			<label for="prenom">Prénom :
			<input type="text" name="prenom" value="${utilisateur.prenom }"></label>
			
			<label for="telephone">Téléphone :
			<input type="tel" name="telephone" value="${utilisateur.telephone }"></label>
			
			<label for="codePostal">Code Postal :
			<input type="text" name="codePostal" value="${utilisateur.codePostal }"></label>
			
			<label for="motdepasse">Mot de passe actuel :
			<input type="password" name="motdepasse"></label>
			
			<label for="nouveau_motdepasse">Nouveau mot de passe :
			<input type="password" name="nouveau_motdepasse"></label>
			
			<p>Crédit : ${utilisateur.credit }</p>
		</div>
	
		<div class="right_text">
			<label for="nom">Nom :
			<input type="text" name="nom" value="${utilisateur.nom}"></label>
			
			<label for="email">E-mail :
			<input type="email" name="email" value="${utilisateur.email}"></label>
			
			<label for="rue">Rue :
			<input type="text" name="rue" value="${utilisateur.rue}"></label>
			
			<label for="ville">Ville :
			<input type="text" name="ville" value="${utilisateur.ville}"></label>


			<label for="confirmation_mdp">Confirmation : 
			<input type="password" name="confirmation_mdp"></label>
		</div>
		
		<button class="button" type="submit" name="enregistrer">Enregistrer</button> <!-- A faire : inclure méthode UPDATE compte -->
		<a href="ServletSupprimerUtilisateur?noUtilisateur=${utilisateur.noUtilisateur}" class="button">Supprimer mon compte</a> <!-- Redirige vers ServletSupprimerUtilisateur WHERE noUtilisateur = noUtilisateur en cours -->
		
</body>
</html>