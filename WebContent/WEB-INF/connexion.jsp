<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<title>Se connecter</title>
</head>
<body>

	<div class="logo">
		<a href="accueil"><img src="images/logoProjet.png" alt="accueil" height="80" width="150"></img></a>
	</div>
		<div>
		<ul>
			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletMonProfil">Mon profil</a></li>
			<li><a href="ServletDeconnexion">Déconnexion</a></li>
		</ul>
	</div>
	
	<h1>Se connecter</h1>
	<br>

	<form action="ServletConnexion" method="post">
		<!--  Encadrer les différents input dans des div ? (pour CSS flexbox) -->
		<div class="wrapper2">
			<label for="identifiant"> Identifiant :</label> 
			<input type="text" id="identifiant" name="identifiant" required maxlenght="30"  autofocus="autofocus" />
			<label for="motdepasse">Mot de	passe :</label> 
			<input type="password" name="motdepasse" id="motdepasse" required minimumlength="8" maxlenght="30"  /> 
				
				<a href="sinscrire" class="button"> <input type="button" class="button" value="Créer un compte"/></a>
			<!-- A FAIRE Lien vers page "créer un compte" -->

			<a href="ServletConnexion" class="button"> <input type="submit" class="button" value="Connexion"></input></a>


			<span><input type="checkbox" class="checkbox"
				name="sesouvenir" />Se souvenir de moi </span> <a href="">Mot de passe 
				oublié</a>
			<!-- Lien vers MDP oublié -->



		</div>


	</form>




</body>

<footer> Copyright 2021 des fifous du net © </footer> 
</html>