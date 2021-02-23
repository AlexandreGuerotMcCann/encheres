package fr.eni.encheres.bll;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;


public class ArticleManager {

	
	private static final String INSTANCE = null;//
	// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de
	// la DAOFactory dans DAL
	private ArticleVenduDAO daoArticleVendu;
	
	public ArticleManager() {
		daoArticleVendu = DAOFactory.getArticleVenduDAO();
	
		
	}
	
	
	public ArticleVendu retournerArticle(String nomArticle) throws BusinessException {
		return daoArticleVendu.selectByNomArticle(nomArticle);
	}

}
