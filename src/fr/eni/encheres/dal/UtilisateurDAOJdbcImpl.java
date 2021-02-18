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
	private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	// A tester les filles et les gars ;)
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS where no_utilisateur = ?";
	private static final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?"; // "credit" et "administrateur" non modifiables via pageMonProfil
	
	
	@Override
	public List<Utilisateur> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_PSEUDO);
			pStatement.setString(1, pseudo);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) { // on boucle sur le resultset pour transormer le result utilisateur
			}
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
	public void ajoutUtilisateur(Utilisateur utilisateur) throws BusinessException {
		// TODO Auto-generated method stub
		try (Connection connection=ConnectionProvider.getConnection()) 
		{
			PreparedStatement pStatement =connection.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, utilisateur.getPseudo());
			pStatement.setString(2, utilisateur.getNom());
			pStatement.setString(3, utilisateur.getPrenom());
			pStatement.setString(4, utilisateur.getEmail());
			pStatement.setString(5, utilisateur.getTelephone());
			pStatement.setString(6, utilisateur.getRue());
			pStatement.setString(7, utilisateur.getCodePostal());
			pStatement.setString(8, utilisateur.getVille());
			pStatement.setString(9,utilisateur.getMotDePasse());
			pStatement.setInt(10, utilisateur.getCredit());
			pStatement.setBoolean(11, false);
			
			pStatement.executeUpdate();
			
		} catch (Exception ex) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesErreursDAL.ERREUR_INSERTION);
			throw businessException;
		}
	}


	// Méthode à tester /!\ => à lier avec pageMonProfil => bouton "Supprimer mon compte" (cf.maquette)
	@Override
		public void supprimerUtilisateur(int no_utilisateur) throws BusinessException {
			try(Connection connection = ConnectionProvider.getConnection())
			{
				PreparedStatement pStatement = connection.prepareStatement(DELETE_USER); // + Voir si delete avec pseudo aussi
				pStatement.setInt(1, no_utilisateur);
				pStatement.executeUpdate();
			} catch (SQLException ex) {
				//ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesErreursDAL.ERREUR_SUPPRESSION_UTILISATEUR);
				throw businessException;
			}
	}
	
	
	// Méthode à tester /!\ => à lier avec pageModifierProfil => bouton "Enregistrer" (cf.maquette p.7 & 8/13)
	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {
			try (Connection connection = ConnectionProvider.getConnection())
			{
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
				pStatement.setInt(10, utilisateur.getNoUtilisateur()); // Pas sûre de toucher au "no_utilisateur"
				//Com de camille : je ne pense pas car c'est une PK en BDD :)
				pStatement.executeUpdate();
			} catch (SQLException ex) {
			
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesErreursDAL.ERREUR_MISE_A_JOUR_UTILISATEUR);
				throw businessException;
			}
		}
	}

	//
//	}

