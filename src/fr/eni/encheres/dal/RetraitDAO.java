package fr.eni.encheres.dal;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;

public interface RetraitDAO {

	public Retrait selectByNoArticle(int noArticle) throws BusinessException;
public void supprimerRetrait(int noArticle) throws BusinessException;
public void modifierRetrait(Retrait retrait) throws BusinessException;

public void ajoutRetrait(Retrait retrait) throws BusinessException;

}
