package fr.eni.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;


public class EncheresManager {

	
		private static final String INSTANCE = null;//
		// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de
		// la DAOFactory dans DAL
		private EncheresDAO daoEncheres;
		
		public EncheresManager() {
			daoEncheres = DAOFactory.getEncheresDAO();
		
			
		}
	

		public Enchere retournerEnchere(int no_enchere) throws BusinessException {
			return daoEncheres.selectByNoEnchere(no_enchere);
		}
	
		public List<Enchere> ListeEncheres() throws BusinessException {
			return daoEncheres.selectAll();
		}
		
		
		public Enchere ajoutEnchere (int no_enchere, Date dateEnchere, int montant_enchere, ArticleVendu noArticle, Utilisateur noUtilisateur) throws BusinessException {

		
			Enchere enchere = new Enchere();
			enchere.setNoEncheres(no_enchere);
			enchere.setDateEnchere(dateEnchere);
			enchere.setMontant_enchere(montant_enchere);
			enchere.setNoArticle(noArticle);
			enchere.setNoUtilisateur(noUtilisateur);

			this.daoEncheres.ajoutEnchere(enchere);

			return enchere;
		}
		
		
		public void supprimerEnchere(int no_enchere) throws BusinessException {
			this.daoEncheres.supprimerEnchere(no_enchere);
}
		
		
		public void modifierEnchere (Enchere enchere) throws BusinessException {
			
			
			this.daoEncheres.modifierEnchere(enchere);
		}

}