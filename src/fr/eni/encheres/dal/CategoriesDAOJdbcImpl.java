package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;

public class CategoriesDAOJdbcImpl implements CategoriesDAO {

	private static final String SELECT_BY_LIBELLE = "SELECT * FROM categories WHERE libelle = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM categories WHERE no_categorie=?";
	private static final String SELECT_ALL = "SELECT * FROM categories";
	private static final String INSERT = "INSERT INTO categories (noCategorie,libelle) VALUES (?,?)";

	private static final String DELETE_CATEGORIE = "DELETE FROM CATEGORIES where no_categorie = ?";
	private static final String UPDATE_CATEGORIE = "UPDATE CATEGORIES SET libelle = ?, noCategorie = ?";

	private Categorie categorie = new Categorie();

	@Override
	public List<Categorie> selectAll() throws BusinessException {
		List<Categorie> listeCategorie = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL);

			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) { // on boucle sur le resultset pour transformer le result en lignes***
								// d'utilisateurs
				categorie = new Categorie();
				categorie.setLibelle(rs.getString("libelle"));

			}
			listeCategorie.add(categorie);
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUNE_CATEGORIE);
			throw businessException;
		}

		return listeCategorie;
	}

	@Override
	public Categorie selectByNoCategorie(int noCategorie) throws BusinessException {

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_ID);
			pStatement.setInt(1, noCategorie);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_ID_CATEGORIE);
			throw businessException;
		}
		return categorie;
	}

	@Override
	public Categorie selectByLibelle(String libelle) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_LIBELLE);
			pStatement.setString(1, libelle);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) { // on boucle sur le resultset pour transformer le result en lignes
								// d'utilisateurs

				categorie = new Categorie();
				categorie.setLibelle(rs.getString("libelle"));
				categorie.setNoCategorie(rs.getInt("noCategorie"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREURS_LIBELLE);
			throw businessException;
		}
		if (categorie == null) {
			System.out.println("aucun libelle");
		}

		return categorie;
	}

	@Override
	public void ajoutCategorie(Categorie categories) throws BusinessException {

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1, categories.getLibelle());
			rqt.setInt(2, categories.getNoCategorie());

			rqt.executeUpdate();
			rqt.close();

		} catch (Exception ex) {
			ex.printStackTrace();

			throw new BusinessException(CodesErreursDAL.ERREUR_INSERTION_LIBELLE);
		}
	}

	@Override
	public void supprimerCategorie(int noCategories) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(DELETE_CATEGORIE);
			pStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_SUPPRESSION_CATEGORIE);
			throw businessException;
		}
	}

	public void modifierCategorie(Categorie categories) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(UPDATE_CATEGORIE);
			pStatement.setString(1, categories.getLibelle());
			pStatement.setInt(2, categories.getNoCategorie());
			pStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_MISE_A_JOUR_CATEGORIE);
			throw businessException;
		}
	}
}
