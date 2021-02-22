package fr.eni.encheres.dal;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	public class ArticleDAOjdbcimpl {
		
		private static final String SELECT_BY_NOM_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article = ?";
		private static final String SELECT_BY_NO_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
		private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_catgeorie) VALUES (?,?,?,?,?,?,?,?,?)";		
		private static final String DELETE_ARTICLES_VENDUS = "DELETE FROM ARTICLES_VENDUS where no_article = ?";
		private static final String UPDATE_ARTICLE_VENDUS = "UPDATE ARTICLES_VENDUS SET articles_vendus = ?, nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?"; // "credit"
																																																						// et
		private ArticleVendu ArticleVendu = new ArticleVendu();
		
	}

	@Override
	public List<ArticleVendu> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectByNom_Article(String nomArticle) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajoutArticle(ArticleVendu nomArticle) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerArticle(int noArticle) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierArticle(ArticleVendu nomArticle) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectByNoArticle(int noArticle) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
