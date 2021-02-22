package fr.eni.encheres.dal;
 
public class DAOFactory {
	private static UtilisateurDAO utilisateurDao;
	private static EncheresDAO encheresDAO;
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static EncheresDAO getEncheresDAO () {
		return new EncheresDAOJdbcImpl();
	}
	
	
	
}
