package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

public class CategoriesDAOJdbcImpl implements CategoriesDAO {
	
	
	private static final String SELECT_BY_LIBELLE = "SELECT * FROM categories WHERE libelle = ?";
	private static final String SELECT_BY_NO_CATEGORIE = "SELECT * FROM categories";
	private static final String SELECT_ALL = "SELECT * FROM categories";
	private static final String INSERT = "INSERT INTO utilisateurs (libelle, noCategorie) VALUES (?,?)";

	private static final String DELETE_CATEGORIE = "DELETE FROM CATEGORIES where no_categorie = ?";
	private static final String UPDATE_CATEGORIE = "UPDATE CATEGORIES SET libelle = ?, noCategorie = ?";
				
	
	
	private Categorie categories = new Categorie();

	
	@Override
	public List<Categorie> selectAll() throws BusinessException {
		List<Categorie> listeUtilisateurs = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL);

			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) { // on boucle sur le resultset pour transformer le result en lignes***
								// d'utilisateurs
				categories = new Categorie();
				categories.setLibelle(rs.getString("libelle"));
				
			}
			listeCategorie.add(categories);
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUN_UTILISATEUR);
			throw businessException;
		}

		return listeUtilisateurs;
	}
	

	@Override
	public Object selectById(int int1) {
		return null;
	}

}
