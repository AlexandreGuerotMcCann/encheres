package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public interface ArticleVenduDAO {
	
	public List<ArticleVendu> selectAll() throws BusinessException;
	
	public ArticleVendu selectByNomArticle(String nomArticle) throws BusinessException;
	
	public void ajoutArticle(ArticleVendu nomArticle) throws BusinessException;
	
	public void supprimerArticle(int noArticle) throws BusinessException;
	
	public void modifierArticle(ArticleVendu nomArticle) throws BusinessException;
	
	public Utilisateur selectByNoArticle(int noArticle) throws BusinessException;
	


}
