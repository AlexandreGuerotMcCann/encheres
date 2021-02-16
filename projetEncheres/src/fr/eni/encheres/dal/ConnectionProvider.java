package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

abstract class ConnectionProvider {
//	Variable permettant de manipuler le pool de connexion
//	Pour obtenir une connexion vers la BDD
	private static DataSource dataSource;
	
	/** 
	 * Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
	 */
	static
	{
//		Création d'un objet de type context permettant de rechercher dans l'arbre JNDI ??
		Context context;
		try {
			context = new InitialContext();
//			La méthode lookup permet de cherhcer la ressource (entre Parenthèses)
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}
	
	/**
	 * Cette méthode retourne une connection opérationnelle issue du pool de connexion
	 * vers la base de données. 
	 * @return
	 * @throws SQLException
	 * 
	 */
//	Methode permettant d'obtenir une connexion à partir de la dataSource
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();
	}
}
