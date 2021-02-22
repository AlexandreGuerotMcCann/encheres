package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public abstract class ArticleVenduDAO {
	
	public abstract List<ArticleVendu> selectAll() throws BusinessException;
	
	public Utilisateur selectByPseudo(String nomArticle) throws BusinessException;

}
