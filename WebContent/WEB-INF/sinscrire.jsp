<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="test.css">
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">

<title>S'inscrire</title>
</head>
<body>

 	<h1>ENI Enchères</h1>

 	<h2>Création d'un nouveau compte</h2>
 	

		<form action="ServletSinscrire" method="post" name="connexion" >
       
        <div class="wrapper">
        
	
				<label for="nickname">Pseudo: </label>
				<input type="text" id="pseudo" name="pseudo" required maxlength="30" size="15">

				<label for="mdp">Mot de passe: </label>
				<input type="password" id="mdp" name="mdp" required min="8" maxlength="30" size="15">


				<label for="mdp">Confirmation Mot de passe: </label>
				<input type="Password" id="confirmMdp" name="confirmMdp" required min="8" maxlength="30" size="15">

				<label for="name">Nom: </label>
				<input type="text" id="nom" name="nom" required maxlength="30" size="15">

				<label for="prenom">Prénom: </label>
				<input type="text" id="prenom" name="prenom" required maxlength="30" size="15">

				<label for="mail">Email: </label>
				<input type="email" id="mail" name="mail" required placeholder="abcd@exemple.fr" maxlength="40" size="25">
			
            
				<label for="telephone">Téléphone: </label>
				<input type="tel" id="telephone" name="telephone" placeholder="0123456789" maxlength="15" size= "15" required>

				<label for="rue">Rue: </label>
				<input type="text" id="rue" name="rue" required maxlength="30" size="15">

				<label for="codePostal">Code postal: </label>
				<input type="text" id="codePostal" name="codePostal" placeholder="35000" required min="5" maxlength="10" size="15">

				<label for="city">Ville: </label>
				<input type="text" id="city" name="city" required maxlength="30" size="15">
            
            
                 <a href="ServletAccueil" class="button"><input type="button" class="button"  name="annuler" value="annuler" /></a>
				<a href="ServletAccueil" class="button"><input type="submit" class="button" name="sinscrire" value="s'inscrire" /></a>
        </div>

	</form>
    
</body>
    <br>
    
<footer> Copyright 2021 des fifous du net © </footer> 
</html>