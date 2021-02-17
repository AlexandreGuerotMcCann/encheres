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

	private static final String SELECT_ALL = "SELECT pseudo,mot_de_passe FROM utiliseurs;";

	// Lors de se connecter, il faudra vérif si le pseudo instanceOf pseudo de la
	// table
//Lors de la création de compte il faudra vérif que le pseudo n'est pas déjà en BDD
	@Override
	public List<Utilisateur> selectAll() {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();// On initialise sa liste d'utilisateurs

		try (Connection connexion = ConnectionProvider.getConnection()) // On est miantnenant connectés à la BDD
		{
			PreparedStatement pstmt = connexion.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // on boucle sur le resultset pour transormer les result en liste
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString("pseudo")); // Fait référence aux colonnes pseudo et nom
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				listeUtilisateur.add(utilisateur);// On ajoute ce nouvel objet au résultat , donc à liste des
													// utilisateurs
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException= new Busi
		}
		return listeUtilisateur;
	}
}
