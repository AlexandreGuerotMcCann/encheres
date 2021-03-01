package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public List<ArticleVendu> selectAll() throws BusinessException;
	
	public ArticleVendu selectByNomArticle(String nomArticle) throws BusinessException;
	
	public void ajoutArticle(ArticleVendu nomArticle) throws BusinessException;
	
	public void supprimerArticle(int noArticle) throws BusinessException;
	
	public void modifierArticle(ArticleVendu nomArticle) throws BusinessException;
	
	public  ArticleVendu selectByNoArticle(int noArticle) throws BusinessException;
	


}
