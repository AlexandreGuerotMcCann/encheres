package fr.eni.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;

import fr.eni.encheres.bo.Enchere;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;

public class EncheresManager {

	private EncheresDAO daoEncheres;

	public EncheresManager() {
		daoEncheres = DAOFactory.getEncheresDAO();
	}

	public Enchere retournerEnchere(int no_enchere) throws BusinessException {
		return daoEncheres.selectByNoEnchere(no_enchere);
	}

	public List<Enchere> ListeEncheres() throws BusinessException {
		return daoEncheres.selectAll();
	}

	public Enchere ajoutEnchere(int noEnchere, Date dateEnchere, int montantEnchere, int noArticle,
			int noUtilisateur) throws BusinessException {

		Enchere enchere = new Enchere();
		enchere.setNoEncheres(noEnchere);
		enchere.setDateEnchere(dateEnchere);
		enchere.setMontantEnchere(montantEnchere);
		enchere.setNoArticle(noArticle);
		enchere.setNoUtilisateur(noUtilisateur);

		this.daoEncheres.ajoutEnchere(enchere);

		return enchere;
	}

	public void supprimerEnchere(int no_enchere) throws BusinessException {
		this.daoEncheres.supprimerEnchere(no_enchere);
	}

	public void modifierEnchere(Enchere enchere) throws BusinessException {

		this.daoEncheres.modifierEnchere(enchere);
	}

}