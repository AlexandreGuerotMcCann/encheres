package fr.eni.encheres.bll;

import java.util.List;

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

public Utilisateur retournerUtilisateur(String pseudo) throws BusinessException
{
	return daoUtilisateur.selectByPseudo(pseudo);}
	// Méthode pour obtenir un utilisateur de la BDD


public void ListeUtilisateur() {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

public void ajoutUtilisateur (String mdp, String pseudo, String nom, String prenom, String mail,
		String telephone, String rue, String codePostal, String city) throws BusinessException {
	
	BusinessException businessException = new BusinessException();
	Utilisateur utilisateur = new Utilisateur();
	utilisateur.setPseudo(pseudo);
	utilisateur.setNom(nom);
	utilisateur.setPrenom(prenom);
	utilisateur.setEmail(mail);
	utilisateur.setTelephone(telephone);
	utilisateur.setRue(rue);
	utilisateur.setCodePostal(codePostal);
	utilisateur.setVille(city);
	utilisateur.setMotDePasse(mdp);
	utilisateur.setCredit(100);
	utilisateur.setAdministrateur(false);
	this.daoUtilisateur.ajoutUtilisateur(utilisateur);
}


//Méthode à tester /!\ => à lier avec pageMonProfil => bouton "Supprimer mon compte" (cf.maquette)
public void suppressionUtilisateur(int no_utilisateur) throws BusinessException {
	this.daoUtilisateur.supprimerUtilisateur(no_utilisateur);
}
}
