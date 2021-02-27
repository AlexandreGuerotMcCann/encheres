package fr.eni.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;
import fr.eni.encheres.dal.RetraitDAO;


public class RetraitManager {

	
		
		// Doit disposer d'un accès à la DAL en passant par le DAOFactory => Création de
		// la DAOFactory dans DAL
		private RetraitDAO daoRetrait;
		
		public RetraitManager() {
			daoRetrait = DAOFactory.getRetraitDAO();
		
			
		}
	

		public Retrait retournerRetrait(int noArticle) throws BusinessException {
			return daoRetrait.selectByNoArticle(noArticle);
		}
	
		
		
		public Retrait ajoutRetrait(int noArticle ) throws BusinessException {

		
//			TODO: 

			return null;
		}
		
		
		public void supprimerRetrait(int noRetrait) throws BusinessException {
			this.daoRetrait.supprimerRetrait(noRetrait);
}
		
		
		public void modifierEnchere (Retrait retrait) throws BusinessException {
			
//			TODO
			this.daoRetrait.modifierRetrait(retrait);
		}

}