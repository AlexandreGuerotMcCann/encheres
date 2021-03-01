package fr.eni.encheres.bll;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitManager {

	private RetraitDAO daoRetrait;

	public RetraitManager() {
		daoRetrait = DAOFactory.getRetraitDAO();
	}

	public Retrait retournerRetrait(int noArticle) throws BusinessException {
		return daoRetrait.selectByNoArticle(noArticle);
	}

	public Retrait ajoutRetrait(int noArticle) throws BusinessException {

//			TODO: 
		return null;
	}

	public void supprimerRetrait(int noRetrait) throws BusinessException {
		this.daoRetrait.supprimerRetrait(noRetrait);
	}

	public void modifierEnchere(Retrait retrait) throws BusinessException {

//			TODO
		this.daoRetrait.modifierRetrait(retrait);
	}

}