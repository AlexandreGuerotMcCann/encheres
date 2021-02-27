package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import fr.eni.encheres.BusinessException;


import fr.eni.encheres.bo.Retrait;





public class RetraitDAOJdbcImpl implements RetraitDAO {
	
	private static final String SELECT_BY_NO_ARTICLE = "SELECT * FROM retraits WHERE no_article = ?";
//	private static final String INSERT;
//	private static final String DELETE;
//	private static final String UPDATE;
	private Retrait retrait = new Retrait();

	




@Override
public Retrait selectByNoArticle(int noArticle) throws BusinessException {
	try (Connection connection = ConnectionProvider.getConnection()) {
		PreparedStatement pStatement = connection.prepareStatement(SELECT_BY_NO_ARTICLE);
		pStatement.setInt(1, noArticle);
		ResultSet rs = pStatement.executeQuery();
		while (rs.next()) {
			retrait = new Retrait();
			retrait.setNoArticle(rs.getInt("no_article"));
			retrait.setRue(rs.getString("rue"));
			retrait.setCodePostal(rs.getString("code_postal"));
			retrait.setVille(rs.getString("ville"));

}} catch (Exception ex) {
	ex.printStackTrace();
	BusinessException businessException = new BusinessException();
	businessException.ajouterErreur(CodesErreursDAL.ERREUR_AUCUN_ARTICLE);
	throw businessException;
}
	return retrait;}

@Override
public void supprimerRetrait(int noArticle) throws BusinessException {
	// TODO Auto-generated method stub
	
}

@Override
public void modifierRetrait(Retrait retrait) throws BusinessException {
	// TODO Auto-generated method stub
	
}


@Override
public void ajoutRetrait(Retrait retrait) throws BusinessException {
	// TODO Auto-generated method stub
	
}

}