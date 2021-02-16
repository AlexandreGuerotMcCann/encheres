package fr.eni.encheres.dal;

public class DAOFactory {
	
	private static UtilisateurDAO utilisateurDao;
	
	public static UtilisateurDAO getUtilisateurDAO() {
		if (utilisateurDao == null) {
			utilisateurDao = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDao;

}
}
