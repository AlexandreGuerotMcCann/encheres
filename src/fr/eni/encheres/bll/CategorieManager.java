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

	public Categorie ajoutCategorie(String libelle, int noCategorie) throws BusinessException {

		Categorie categorie = new Categorie();
		categorie.setLibelle(libelle);
		categorie.setNoCategorie(noCategorie);


		this.daoCategories.ajoutCategorie(categorie);

		return categorie;
	}
	
	public void modifierCategorie(Categorie categorie) throws BusinessException {
		
		
		this.daoCategories.modifierCategorie(categorie);
	}

	public void supprimerCategorie(int noCategories) throws BusinessException {
		this.daoCategories.supprimerCategorie(noCategories);
	}
}
