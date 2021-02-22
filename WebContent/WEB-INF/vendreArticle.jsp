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
<title>Ajouter une nouvelle vente</title>
</head>
<body>
	<div>

		<ul>

			<li><a href="ServletEncheres">Enchères</a></li>
			<li><a href="ServletVendreArticle">Vendre un article</a></li>
			<li><a href="ServletConnexion">Se connecter</a></li>
			<li><a href="ServletSinscrire">S'inscrire</a></li>
    		
		</ul>

	</div>
	
	
	
		<h2>Nouvelle Vente</h2>
	
	<div class="nouvelleVente">
	
		<label>Article: <input style="text"></label>
		<label>Description: <input style="text" class="descriptionArticle"></label>
		<label><select name="categorie" id="categorie">
   			 	<option value="">Catégorie</option>
			    <option value="#">#</option>
			    <option value="#">#</option>
			    <option value="#">#</option>
			    <option value="#">#</option>
			    <option value="#">#</option>
			    <option value="#">#</option>
				</select>
		</label>
		<label>Photo de l'article: <input></label>
		<label>Mise à prix: <input style="text"></label>
		<label>Début de l'enchère: <input style="date"></label>
		<label>Fin de l'enchère: <input style="date"></label>
		
	</div>
	
	<div class="retrait">
		<a>Retrait: </a>
		<label>Rue: <input style="text"></label>
		<label>Code postal: <input style="text"></label>
		<label>Ville: <input style="text"></label>

	
	
	</div>

	<a href="ServletMesVentes" class="button"> <input type="submit" class="button" value="Enregistrer"></input></a>
	<a href="ServletAccueil" class="button"> <input type="submit" class="button" value="Annuler"></input></a>

</body>

	<footer> Copyright 2021 des fifous du net © </footer> 
</html>