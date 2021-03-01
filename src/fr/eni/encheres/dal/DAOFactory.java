package fr.eni.encheres.dal;

public class DAOFactory {
	private static UtilisateurDAO utilisateurDao;

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static CategoriesDAO getCategorieDAO() {
		return new CategoriesDAOJdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}

	public static EncheresDAO getEncheresDAO() {

		return new EncheresDAOJdbcImpl();
	}

	public static RetraitDAO getRetraitDAO() {

		return new RetraitDAOJdbcImpl();
	}
}
