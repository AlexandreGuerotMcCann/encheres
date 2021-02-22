package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public class EncheresDAOJdbcImpl implements EncheresDAO {
	
	private static final String SELECT_BY_NO_ENCHERE = "SELECT * FROM encheres WHERE no_enchere = ?";
	private static final String SELECT_ALL = "SELECT * FROM encheres;";
	private static final String INSERT = "INSERT INTO encheres (no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur) VALUES (?,?,?,?,?)";
	private static final String DELETE_ENCHERE = "DELETE FROM encheres WHERE no_enchere = ?";
	private static final String UPDATE_ENCHERE= "UPDATE encheres SET no_enchere = ?, date_enchere= ?, montant_enchere = ?, no_article = ?, no_utilisateur = ?";

	private Enchere enchere = new Enchere();

	@Override
	public List<Enchere> selectAll() throws BusinessException {
		List<Enchere> listeEncheres = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL);

			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) { // on boucle sur le resultset pour transformer le result en lignes***
							
				enchere = new Enchere();
				enchere.setNoEncheres(rs.getInt("no_enchere"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				
			}
			listeEncheres.add(enchere);
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			//CODE ERREUR A MODIFIER ET VERIFIER
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUN_UTILISATEUR);
			throw businessException;
		}

		return listeEncheres;
	}}