package fr.eni.encheres.bll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de
	// la DAOFactory dans DAL
	private UtilisateurDAO daoUtilisateur;

	public UtilisateurManager() {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

//	// Méthode pour obtenir la liste des utilisateurs présents en BDD
//	public List<Utilisateur> getListeUtilisateurs() throws BusinessException {
//		return this.daoUtilisateur.selectAll();
//		}
	
	public void verifierIdentifiants(HttpServletRequest request, Utilisateur utilisateur) {
		
		String identifiant=request.getParameter("identifiant");
		String motDePasse=request.getParameter("motdepasse");
		
		try {
			if (identifiant.equals(utilisateur.getPseudo())
					&& motDePasse.equals(utilisateur.getMotDePasse())) {

	}
	
public Utilisateur retournerUtilisateur(String pseudo) throws BusinessException
{
	return daoUtilisateur.selectByPseudo(pseudo);}
	// Méthode pour obtenir un utilisateur de la BDD
	public void ListeUtilisateur() {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

}
