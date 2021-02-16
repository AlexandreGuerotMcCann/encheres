package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

private static final String SELECT_ALL = "SELECT * FROM UTILISATEURS;";
	
	@Override
	public List<Utilisateur> selectAll() {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();// On initialise sa liste de listes 
		
		try(Connection connexion = ConnectionProvider.getConnection()) // On est miantnenant connectész à la BDD
		{
			PreparedStatement pstmt = connexion.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) { // on boucle sur le resultset pour transormer mes result en liste
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString("identifiant")); // Fait référence aux colonnes Id et nom
				utilisateur.setMotDePasse(rs.getString("nom"));
				listeUtilisateur.add(utilisateur);// On ajoute ce nouvel objet au résultat , donc à liste des utilisateurs
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateur;
	}
}
