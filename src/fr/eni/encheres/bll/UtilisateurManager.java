package fr.eni.encheres.bll;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de la DAOFactory dans DAL
	private UtilisateurDAO daoUtilisateur;
	
	// Méthode pour obtenir un utilisateur de la BDD
	public void ListeUtilisateur() {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}
	
}
