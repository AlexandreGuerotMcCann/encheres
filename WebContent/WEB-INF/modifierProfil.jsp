<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@page import="java.util.HashMap"%>
<%@page import="fr.eni.encheres.servlet.ServletModifierProfil"%>


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
	
	
	<p class="erreur">
	<c:forEach items="${listeErreurs}" var="entry">
	${entry.value}<br>
</c:forEach>
<form action="ServletModifierProfil" method="post">
	
		<div class="modifProfil1">
			<label for="pseudo">Pseudo :</label>
			<input type="text" readonly name="pseudo"maxlength="30" size="30" value="${utilisateur.pseudo}">
			
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" pattern=".{1,30}.[A-Za-z -]" size="30" value="${utilisateur.prenom }"
			title="Votre prénom ne doit pas excéder 30 caractères."/>
			
			<label for="telephone">Téléphone :</label>
			<input type="tel" name="telephone" pattern=".{8}.[0-9]" size="30" value="${utilisateur.telephone }"
			title="10 caractères numériques sont attendus."/>
			
			
			<p>Crédit : ${utilisateur.credit }</p><br>
	
			<label for="nom">Nom :</label>
			<input type="text" name="nom" pattern=".{1,30}.[A-Za-z -]" size="30" value="${utilisateur.nom}"
			title="Votre nom ne doit pas excéder 30 caractères."/> 
			
			<label for="email">E-mail :</label>
			<input type="email" name="email" maxlength="50" size="50"value="${utilisateur.email}"
			title="Votre e-mail ne doit pas excéder 50 caractères."/> 
			
			<label for="rue">Rue :</label>
			<input type="text" name="rue" pattern=".{3,30}.[A-Za-z0-9 -]" size="30" value="${utilisateur.rue}"
			title="La rue ne doit pas excéder 30 caractères (les caractères spéciaux ne sont pas acceptés. Seuls les - et les espaces sont permis)."/>
			
			<label for="ville">Ville :</label>
			<input type="text" name="ville" pattern=".{1,50}.[A-Za-z -]" size="50" value="${utilisateur.ville}"
			title="La ville ne doit pas excéder 50 caractères. (Les caractères spéciaux ne sont pas acceptés. Seuls les - et les espaces sont permis)."/>

			<label for="codePostal">Code Postal :</label>
			<input type="text" name="codePostal" pattern=".{3}.[0-9]" size="30" maxlength=5 value="${utilisateur.codePostal }"
			title="5 caractères numériques sont attendus."/>
			
			<label for="motdepasse">Mot de passe actuel :</label>
			<input type="password" name="motdepasse" pattern=".{6,30}.[A-Za-z0-9]" size="30" value="${utilisateur.motDePasse }
			title="Le mot de passe doit contenir au moins 8 caractères alphanumériques (les symboles ne sont pas acceptés)."/> 
			
			<label for="nouveau_motdepasse">Nouveau mot de passe :</label>
			<input type="password" size="30" name="nouveau_motdepasse">
			<label for="confirmation_mdp">Confirmation : </label>	
			<input type="password" size="30" name="confirmation_mdp">	
		
		
		<button class="button" type="submit" onclick="ServletModifierProfil"name="modifier">Enregistrer les modifications</button> <!-- A faire : inclure méthode UPDATE compte -->
		<button class="button" type="submit" onclick="ServletModifierProfil"name="supprimer">Supprimer mon profil</button>
	</div>
	<!--	<a href="ServletModifierProfil" class="button">Supprimer mon compte</a> <!-- Redirige vers ServletSupprimerUtilisateur
			 <input type="submit" class="button" value="Connexion"></input></a>
			 -->
			</form>
			
</body>
</html>