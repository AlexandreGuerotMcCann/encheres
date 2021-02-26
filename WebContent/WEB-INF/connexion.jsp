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
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Se connecter</title>
</head>
<body>

	<div class="logo">
		<a href="ServletAccueil"><img src="images/logoProjet.png" alt="accueil" height="80" width="150"></img></a>
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
			<li><a href="ServletConnexion">Se connecter</a></li>
			<li><a href="ServletSinscrire">S'inscrire</a></li>
    		
		</ul>
 
	</div>
	<br>
	<h1>ENI Enchères</h1>
	
	<h2>Se connecter</h2>
	<br>
	<br>

	<form action="ServletConnexion" method="post">
		<!--  Encadrer les différents input dans des div ? (pour CSS flexbox) -->
		<div class="wrapper2">
			<label for="identifiant"> Identifiant :</label> 
			<input type="text" id="identifiant" name="identifiant" required maxlenght="30"  autofocus="autofocus" />
			<label for="motdepasse">Mot de	passe :</label> 
			<input type="password" name="motdepasse" id="motdepasse" required minimumlength="8" maxlenght="30"  /> 
				
				
			<button class="button4" type="button" name="sinscrire" onclick="ServletSinscrire">Créer un compte</button>

			<button class="button4" type="submit" name="connexion"
				onclick="ServletConnexion">S'inscrire</button>
				
	

			<span><input type="checkbox" class="checkbox"
				name="sesouvenir" /> Se souvenir de moi </span> <a href="">Mot de passe 
				oublié</a>
			<!-- Lien vers MDP oublié -->



		</div>


	</form>




</body>

<footer> Copyright 2021 des fifous du net © </footer> 
</html>