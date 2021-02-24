<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">

<title>Mot de passe oublié</title>
</head>
<body>
	<div class="logo">
		<a href="accueil"><img src="images/logoProjet.png" alt="accueil" height="80" width="150"></img></a>
	</div>

	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletConnexion">Se connecter</a></li>
			<li><a href="ServletSinscrire">S'inscrire</a></li>	
    		
		</ul>

	</div>


			<label for="mail">Email: </label> <input type="email" id="mail" name="mail"
			required placeholder="abcd@exemple.fr" maxlength="40" size="25">

</body>

<footer> Copyright 2021 des fifous du net © </footer> 

</html>