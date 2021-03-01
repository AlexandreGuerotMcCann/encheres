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

	private static final String SELECT_BY_PSEUDO = "SELECT * FROM utilisateurs WHERE pseudo = ?";
	private static final String SELECT_BY_ID = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?";
	private static final String SELECT_ALL = "SELECT * FROM utilisateurs";
	private static final String INSERT = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	private static final String DELETE_USER = "DELETE FROM UTILISATEURS where pseudo = ?";
	private static final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?"; // "credit"
																																																					// et

	private Utilisateur utilisateur = new Utilisateur();

	@Override
	public List<Utilisateur> selectAll() throws BusinessException {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL);

			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) { // on boucle sur le resultset pour transformer le result en lignes***
								// d'utilisateurs
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			}
			listeUtilisateurs.add(utilisateur);
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUN_UTILISATEUR);
			throw businessException;
		}

		return listeUtilisateurs;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_PSEUDO);
			pStatement.setString(1, pseudo);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREURS_IDENTIFIANTS);
			throw businessException;
		}
		if (utilisateur == null) {
			System.out.println("aucun utilisateur");
		}

		return utilisateur;
	}

	@Override
	public Utilisateur selectById(int noUtilisateur) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_ID);
			pStatement.setInt(1, noUtilisateur);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
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
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_ID);
			throw businessException;
		}
		return utilisateur;
	}

	@Override
	public void ajoutUtilisateur(Utilisateur utilisateur) throws BusinessException {

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1, utilisateur.getPseudo());
			rqt.setString(2, utilisateur.getNom());
			rqt.setString(3, utilisateur.getPrenom());
			rqt.setString(4, utilisateur.getEmail());
			rqt.setString(5, utilisateur.getTelephone());
			rqt.setString(6, utilisateur.getRue());
			rqt.setString(7, utilisateur.getCodePostal());
			rqt.setString(8, utilisateur.getVille());
			rqt.setString(9, utilisateur.getMotDePasse());
			rqt.setInt(10, utilisateur.getCredit());
			rqt.setBoolean(11, false);

			rqt.executeUpdate();
			rqt.close();

		} catch (Exception ex) {
			throw new BusinessException(CodesErreursDAL.ERREUR_INSERTION);
		}
	}

	@Override
	public void supprimerUtilisateur(String pseudo) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(DELETE_USER);
			pStatement.setString(1, pseudo);
			pStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_SUPPRESSION_UTILISATEUR);
			throw businessException;
		}
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(UPDATE_USER);
			pStatement.setString(1, utilisateur.getPseudo());
			pStatement.setString(2, utilisateur.getNom());
			pStatement.setString(3, utilisateur.getPrenom());
			pStatement.setString(4, utilisateur.getEmail());
			pStatement.setString(5, utilisateur.getTelephone());
			pStatement.setString(6, utilisateur.getRue());
			pStatement.setString(7, utilisateur.getCodePostal());
			pStatement.setString(8, utilisateur.getVille());
			pStatement.setString(9, utilisateur.getMotDePasse());
			pStatement.setInt(10, utilisateur.getNoUtilisateur());
			pStatement.executeUpdate();
		} catch (SQLException ex) {

			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_MISE_A_JOUR_UTILISATEUR);
			throw businessException;
		}
	}
}
