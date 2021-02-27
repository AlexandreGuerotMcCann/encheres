package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

public interface CategoriesDAO {

	public Categorie selectByNoCategorie(int noCategorie) throws BusinessException;

	List<Categorie> selectAll() throws BusinessException;

	Categorie selectByLibelle(String libelle) throws BusinessException;

	void ajoutCategorie(Categorie categories) throws BusinessException;

	void supprimerCategorie(int noCategories) throws BusinessException;
	
	void modifierCategorie(Categorie categories) throws BusinessException;
}
