package fr.eni.encheres.dal;


import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import java.time.LocalDate;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	p
		private static final String SELECT_BY_NOM_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article = ?";
		private static final String SELECT_BY_NO_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
		private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
		private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
		private static final String DELETE_ARTICLES_VENDUS = "DELETE FROM ARTICLES_VENDUS where no_article = ?";
		private static final String UPDATE_ARTICLE_VENDUS = "UPDATE ARTICLES_VENDUS SET articles_vendus = ?, nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";
		private ArticleVendu articleVendu = new ArticleVendu();

		public List<ArticleVendu> selectAll() throws BusinessException {
			List<ArticleVendu> listeArticleVendu = new ArrayList<>();
			try (Connection connection = ConnectionProvider.getConnection()) {
				PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL);

				ResultSet rs = pStatement.executeQuery();
				UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
				CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
				
				while (rs.next()) { // on boucle sur le resultset pour transformer le result en lignes***
									// d'utilisateurs
					articleVendu = new ArticleVendu();
					articleVendu.setUtilisateur(utilisateurDAO.selectById(rs.getInt("no_utilisateur")));
					articleVendu.setNoArticle(rs.getInt("no_article"));
					articleVendu.setNomArticle(rs.getString("nom_article"));
					articleVendu.setDescription(rs.getString("description"));
					articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
					articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres"));
					articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
					articleVendu.setPrixVente(rs.getInt("prix_vente"));
					articleVendu.setCategorie((Categorie) categorieDAO.selectById(rs.getInt("no_categorie")));
//REVENIR QUAND INTERFACE DONE
					
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUN_ARTICLE);
				throw businessException;
			}

			return listeArticleVendu;

		}


	@Override
	public ArticleVendu selectByNomArticle(String nomArticle) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_NOM_ARTICLE);
			pStatement.setString(1, nomArticle);
			ResultSet rs = pStatement.executeQuery(); 
			UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
			CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
			if (rs.next()) {

				articleVendu = new ArticleVendu();
				articleVendu.setUtilisateur(utilisateurDAO.selectById(rs.getInt("no_utilisateur")));
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
				articleVendu.setPrixVente(rs.getInt("prix_vente"));
				articleVendu.setCategorie((Categorie) categorieDAO.selectById(rs.getInt("no_categorie")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_NOM_DARTICLE);
			throw businessException;
		}
		if (articleVendu == null) {
			System.out.println("aucun article");
		}

		return articleVendu;
	}
	
	
	@Override
	public Utilisateur selectByNoArticle(int noArticle) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_NO_ARTICLE);
			pStatement.setInt(1, noArticle);
			ResultSet rs = pStatement.executeQuery();
			UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
			CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
			while (rs.next()) {
				articleVendu = new ArticleVendu();
				articleVendu.setUtilisateur(utilisateurDAO.selectById(rs.getInt("no_utilisateur")));
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
				articleVendu.setPrixVente(rs.getInt("prix_vente"));
				articleVendu.setCategorie((Categorie) categorieDAO.selectById(rs.getInt("no_categorie")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_NO_ARTICLE);
			throw businessException;
		}
		return articleVendu;
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
	public List<ArticleVendu> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}



	

}