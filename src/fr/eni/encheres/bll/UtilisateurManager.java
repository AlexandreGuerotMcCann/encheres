package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de la DAOFactory dans DAL
	private UtilisateurDAO daoUtilisateur;
	
	public UtilisateurManager() {
daoUtilisateur=DAOFactory.getUtilisateurDAO();}
	
	

	// Méthode pour obtenir la liste des utilisateurs présents en BDD
	public List<Utilisateur> getListeUtilisateurs() throws BusinessException {
		return this.daoUtilisateur.selectAll();
		}
	

//public void verifierUtilisateur(String pseudo, String motDePasse,List<Utilisateur> daoUtilisateurs) {
//	if(identifiant.length()<30 && identifiant.)
//	
	

	// Méthode pour obtenir un utilisateur de la BDD
	public void ListeUtilisateur() {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}
	

}
