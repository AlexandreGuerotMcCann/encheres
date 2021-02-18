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


	<h1>Se connecter</h1>

	<form action="ServletConnexion" method="post">
		<!--  Encadrer les différents input dans des div ? (pour CSS flexbox) -->
		<div class="wrapper2">
			<label for="identifiant"> Identifiant :</label> 
			<input type="text" id="identifiant" name="identifiant" required maxlenght="30"  autofocus="autofocus" />
			<label for="motdepasse">Mot de	passe :</label> 
			<input type="password" name="motdepasse" id="motdepasse" required minimumlength="8" maxlenght="30"  /> 
				
				<a href="ServletSinscrire"> <input type="button" class="button" value="Créer un compte"/></a>
			<!-- A FAIRE Lien vers page "créer un compte" -->

			<button type="submit" class="button">Connexion</button>


			<span><input type="checkbox" class="checkbox"
				name="sesouvenir" />Se souvenir de moi </span> <a href="">Mot de passe
				oublié</a>
			<!-- Lien vers MDP oublié -->



		</div>


	</form>




</body>
</html>