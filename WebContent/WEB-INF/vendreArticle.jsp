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
	
	

	
	
		<h2 class="newVente">Nouvelle Vente</h2>
	
	<div class="ajoutVente">
	
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
		<label>Photo de l'article: <input type="file" id="avatar" name="avatar" style="color:transparent"   ; accept="image/png, image/jpeg" /></label>
		<label>Mise à prix: <input type="number"></label>
		<label>Début de l'enchère: <input type="date"></label>
		<label>Fin de l'enchère: <input type="date"></label>
		
	
		<label class="retrait">Retirer un Article: </label> <br>
		<label>Rue: <input style="text"></label>
		<label>Code postal: <input style="text"></label>
		<label>Ville: <input style="text"></label>

	
	<a href="ServletAccueil" class="button3"><input type="submit" class="button" value="Annuler"> </a>
        <a href="ServletMesVentes" class="button3"> <input type="submit" class="button" value="Enregistrer"></a>
	
	</div>

	

</body>

	
</html>