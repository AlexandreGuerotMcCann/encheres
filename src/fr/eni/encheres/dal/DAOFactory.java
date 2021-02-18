package fr.eni.encheres.dal;

public class DAOFactory {
	
	private static UtilisateurDAO utilisateurDao;
	
	public static UtilisateurDAO getUtilisateurDAO() {
		
		return new UtilisateurDAOJdbcImpl();

}}
