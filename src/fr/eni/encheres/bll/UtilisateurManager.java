package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO daoUtilisateur;

	public UtilisateurManager() {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur retournerUtilisateur(String pseudo) throws BusinessException {
		return daoUtilisateur.selectByPseudo(pseudo);
	}

	public Utilisateur retournerUtilisateurParId(int noUtilisateur) throws BusinessException {
		return daoUtilisateur.selectById(noUtilisateur);
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

	public void modificationUtilisateur(Utilisateur utilisateur) throws BusinessException {

		this.daoUtilisateur.modifierUtilisateur(utilisateur);
	}

	public void suppressionUtilisateur(String pseudo) throws BusinessException {
		this.daoUtilisateur.supprimerUtilisateur(pseudo);
	}

}
