package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SELECT_BY_PSEUDO = "SELECT * FROM utilisateurs WHERE pseudo=?";
	private static final String SELECT_ALL = "SELECT pseudo,mot_de_passe FROM utiliseurs;";

	@Override
	public List<Utilisateur> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_PSEUDO,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, pseudo);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) { // on boucle sur le resultset pour transormer le result utilisateur

			}
			ResultSet key = pStatement.getGeneratedKeys();// Colonne noUtilisateur generatedKey
			utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
			utilisateur.setPseudo(rs.getString("pseudo"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setRue(rs.getString("rue"));
			utilisateur.setCodePostal(rs.getString("code_postal"));
			utilisateur.setVille(rs.getString("ville"));
			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateur.setCredit(rs.getInt("credit"));
			utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ECHEC_LECTURE_UTILISATEUR_SELECTIONNE);
			throw businessException;
		}
		return utilisateur;
	}

	@Override
	public void ajoutUtilisateur(Utilisateur utlisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	// Lors de se connecter, il faudra vérif si le pseudo instanceOf pseudo de la
	// table
//Lors de la création de compte il faudra vérif que le pseudo n'est pas déjà en BDD
//	@Override
//	public List<Utilisateur> selectAll() throws BusinessException {
//		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();// On initialise sa liste d'utilisateurs
//
//		try (Connection connexion = ConnectionProvider.getConnection()) // On est miantnenant connectés à la BDD
//		{
//			PreparedStatement pstmt = connexion.prepareStatement(SELECT_ALL);
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) { // on boucle sur le resultset pour transormer les result en liste
//				Utilisateur utilisateur = new Utilisateur();
//				utilisateur.setPseudo(rs.getString("pseudo")); // Fait référence aux colonnes pseudo et nom
//				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
//				listeUtilisateur.add(utilisateur);// On ajoute ce nouvel objet au résultat , donc à liste des
//													// utilisateurs
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			BusinessException businessException= new BusinessException();
//			businessException.ajouterErreur(CodesErreursDAL.ECHEC_LECTURE_LISTE_UTILISATEURS);
//			throw businessException;
//		}
//		return listeUtilisateur;
//	}
}
