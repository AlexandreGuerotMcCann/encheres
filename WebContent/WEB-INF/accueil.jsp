<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<!-- FEUILLE CSS DE TEST -->
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<title>Accueil</title>
</head>
<body>


	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletConnexion">se connecter</a></li>
			<li><a href="ServletSinscrire">s'inscrire</a></li>
			
		<!--<c:if test="${!empty sessionScope.sessionUtilisateur}">
		<p class="succes">Bonjour!! : ${sessionScope.sessionUtilisateur.pseudo}</p>
		</c:if>
			<li><a href="ServletMonProfil">Mon profil</a></li>
			<li><a href="ServletAccueil">Déconnexion</a></li>
				
			
		<!--<%String pseudo = (String) request.getAttribute("id"); out.println(pseudo);%> -->	
    		
			

		</ul>

	</div>

	<br>

	<h1>ENI-Enchères</h1>

	<h2>Liste des enchères</h2>
	


	<br>
	<form>
	


		<div>
		
		<div class="wrapper3" style="float:left;">
			<label>Filtres : </label> <br> <input id="searchsize" type="text" placeholder="Search.."> <br>
			<label>Catégories: </label> <select id="categorie" name="categorie">

				<option value="0">categorie1</option>
				<option value="1">categorie2</option>
				<option value="2">categorie3</option>

			</select> <span><input type="radio"  name="achats" />Achats</span>
			<span><input type="radio"  name="achats" />Ventes</span>

			<span class="checkbox"><input type="checkbox" id="checkbox"> Enchères ouvertes</span> <span class="checkbox"><input
				type="checkbox" id="checkbox"> Mes Ventes en cours</span> <span class="checkbox"><input
				type="checkbox" > Mes enchères en cours</span> <span class="checkbox"><input
				type="checkbox" class="checkbox"> Ventes non débutées</span> <span class="checkbox"><input
				type="checkbox" class="checkbox"> Mes enchères remportées</span> <span class="checkbox"><input
				type="checkbox" class="checkbox"> Ventes terminées</span>


</div>
    <div class="wrapper4" style="float:right;">
			<label>Filtres : </label> <br> <input id="searchsize" type="text" placeholder="Search.."> <br>
			<label>Catégories: </label> <select id="categorie" name="categorie">

				<option value="0">categorie1</option>
				<option value="1">categorie2</option>
				<option value="2">categorie3</option>

			</select> <span><input type="radio"  name="achats" />Achats</span>
			<span><input type="radio"  name="achats" />Ventes</span>

			<span class="checkbox"><input type="checkbox" id="checkbox"> Enchères ouvertes</span> <span class="checkbox"><input
				type="checkbox" id="checkbox"> Mes Ventes en cours</span> <span class="checkbox"><input
				type="checkbox" > Mes enchères en cours</span> <span class="checkbox"><input
				type="checkbox" class="checkbox"> Ventes non débutées</span> <span class="checkbox"><input
				type="checkbox" class="checkbox"> Mes enchères remportées</span> <span class="checkbox"><input
				type="checkbox" class="checkbox"> Ventes terminées</span>

		</div>
		</div>
		
		

	</form>
	
	</body>
	</html>