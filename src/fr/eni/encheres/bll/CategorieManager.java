package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategoriesDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManager {

	private CategoriesDAO daoCategories;

	public CategorieManager() {
		daoCategories = DAOFactory.getCategorieDAO();
	}

	public Categorie retournerCategorieParNoCategorie(int noCategorie) throws BusinessException {
		return daoCategories.selectByNoCategorie(noCategorie);
	}

	public List<Categorie> ListeCategorie() throws BusinessException {
		return daoCategories.selectAll();
	}

}
