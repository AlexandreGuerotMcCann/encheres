<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${pseudo}</title>
</head>
<body>
	<div class="infosUtilisateur">
		<p>Pseudo : ${utilisateur.pseudo}</p>
		<p>Nom : ${utilisateur.pseudo}</p>
		<p>Prénom : ${utilisateur.pseudo}</p>
		<p>Email : ${utilisateur.pseudo}</p>
		<p>Téléphone : ${utilisateur.pseudo}</p>
		<p>Rue : ${utilisateur.rue}</p>
		<p>Code postal : ${utilisateur.codePostal}</p>
		<p>Ville : ${utilisateur.ville}</p>
	</div>
</body>
</html>