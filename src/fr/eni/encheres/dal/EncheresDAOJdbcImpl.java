package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;



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
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUNE_ENCHERES);
			throw businessException;
		}

		return listeEncheres;
	}




@Override
public Enchere selectByNoEnchere(int no_utilisateur) throws BusinessException {
	try (Connection connection = ConnectionProvider.getConnection()) {
		PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_NO_ENCHERE);
		pStatement.setInt(1, no_utilisateur);
		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			enchere = new Enchere();
			enchere.setNoEncheres(rs.getInt("no_enchere"));
			enchere.setDateEnchere(rs.getDate("date_enchere"));
			enchere.setMontant_enchere(rs.getInt("montant_enchere"));
			enchere.setNoArticle(rs.getInt("no_article"));
			enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
			
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesErreursDAL.ERREUR_NO_ENCHERE);
		
		//ERREUR A MODIFIER/VERIFIER
		
		throw businessException;
	}
	return enchere;
}


public void ajoutEnchere (Enchere enchere) throws BusinessException {
	// TODO Auto-generated method stub
	ResultSet rs;

	try {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setInt(1, enchere.getNoEnchere());
			rqt.setDate(2, enchere.getDateEnchere());
			rqt.setInt(3, enchere.getMontant_enchere());
			rqt.setInt(4, enchere.getNoArticle());
			rqt.setInt(5, enchere.getNoUtilisateur());
			

			rqt.executeUpdate();
			rqt.close();

		} catch (Exception ex) {
			throw new BusinessException(CodesErreursDAL.ERREUR_AJOUT_ENCHERE);
			
		}
	} catch (BusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override


public void supprimerEnchere(int no_enchere) throws BusinessException {
	try (Connection connection = ConnectionProvider.getConnection()) {
		PreparedStatement pStatement = connection.prepareStatement(DELETE_ENCHERE);
																				
		pStatement.setInt(1, no_enchere);
		pStatement.executeUpdate();
	} catch (SQLException ex) {
		// ex.printStackTrace();
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesErreursDAL.ERREUR_SUPPRESSION_ENCHERE);
		throw businessException;
	}
}
@Override

public void modifierEnchere (Enchere enchere) throws BusinessException {
	try (Connection connection = ConnectionProvider.getConnection()) {
		PreparedStatement pStatement = connection.prepareStatement(UPDATE_ENCHERE);
		pStatement.setInt(1, enchere.getNoEnchere());
		pStatement.setDate(2, enchere.getDateEnchere());
		pStatement.setInt(3, enchere.getMontant_enchere());
		pStatement.setInt(4, enchere.getNoArticle());
		pStatement.setInt(5, enchere.getNoUtilisateur());
		
		pStatement.executeUpdate();
	} catch (SQLException ex) {

		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesErreursDAL.ERREUR_MISE_A_JOUR_ENCHERE);
		throw businessException;
	}
}

}