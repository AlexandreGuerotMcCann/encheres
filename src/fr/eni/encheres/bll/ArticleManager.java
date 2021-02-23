package fr.eni.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
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
	
	public List<ArticleVendu> listeArticles() throws BusinessException {
		return daoArticleVendu.selectAll();
	}

	
<<<<<<< HEAD
	public ArticleVendu ajoutArticleVendu (String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere, int miseAPrix, int prixVente, int no_utilisateur, int no_categorie) throws BusinessException {
=======
	public ArticleVendu ajoutArticleVendu (String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere, int miseAPrix, int prixVente, Utilisateur noUtilisateur, Categorie noCategorie) throws BusinessException {
>>>>>>> branch 'main' of https://github.com/rambaldi35/encheres.git

		
		ArticleVendu articleVendu = new ArticleVendu();
		articleVendu.setNomArticle(nomArticle);
		articleVendu.setDescription(description);
		articleVendu.setDateDebutEncheres(dateDebutEnchere);
		articleVendu.setDateFinEncheres(dateFinEnchere);
		articleVendu.setMiseAPrix(miseAPrix);
		articleVendu.setPrixVente(prixVente);
		articleVendu.getUtilisateur().getNoUtilisateur();
<<<<<<< HEAD
		articleVendu.setCategorie(no_categorie);
=======
		articleVendu.getCategorie().getNoCategorie();
>>>>>>> branch 'main' of https://github.com/rambaldi35/encheres.git
		
		
		
		this.daoArticleVendu.ajoutArticle(articleVendu);

		return articleVendu;
	}
	
	public void supprimerArticle(int no_Article) throws BusinessException {
		this.daoArticleVendu.supprimerArticle(no_Article);
}
	
	public void modifierArticle (ArticleVendu articleVendu) throws BusinessException {
		
		
		this.daoArticleVendu.modifierArticle(articleVendu);
	}

	
	
	
	
}
