package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	private static final String INSTANCE = null;//
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

	public Utilisateur retournerUtilisateur(String pseudo) throws BusinessException {
		return daoUtilisateur.selectByPseudo(pseudo);
	}

	public Utilisateur retournerUtilisateurParId(int id) throws BusinessException {
		return daoUtilisateur.selectById(id);
	}

	public List<Utilisateur> ListeUtilisateurs() throws BusinessException {
		return daoUtilisateur.selectAll();
	}

	public Utilisateur ajoutUtilisateur(String mdp, String pseudo, String nom, String prenom, String mail,
			String telephone, String rue, String codePostal, String city) throws BusinessException {

	
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

		return utilisateur;
	}

//public static UtilisateurManager getInstance() { //
//	if (INSTANCE == null)//
//		INSTANCE = new UtilisateurManager();//
//	return INSTANCE;//
//}

//Méthode à tester /!\ => à lier avec pageMonProfil => bouton "Supprimer mon compte" (cf.maquette)
	public void suppressionUtilisateur(int no_utilisateur) throws BusinessException {
		this.daoUtilisateur.supprimerUtilisateur(no_utilisateur);
	}

//Méthode à tester /!\ => à lier avec pageModifierProfil => bouton "Enregistrer" (cf.maquette p.7 & 8/13)
	public void modificationUtilisateur(Utilisateur utilisateur) throws BusinessException {
		this.daoUtilisateur.modifierUtilisateur(utilisateur);
	}

}
