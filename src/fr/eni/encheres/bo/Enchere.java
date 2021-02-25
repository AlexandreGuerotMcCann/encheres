package fr.eni.encheres.bo;


import java.util.Date;

public class Enchere {
	
	private Date dateEnchere;
	private int montant_enchere;
	private int noEnchere;
	
	private Utilisateur noUtilisateur;
	private ArticleVendu noArticle;
	
	// Constructeur sans paramètres
	public Enchere() {
		
	}
	
	
	// Getter et Setter
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public void setNoEncheres(int no_enchere) {
		
	}


	public void setNoArticle(ArticleVendu noArticle) {
		
	}


	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	public int getNoEnchere() {
		return 0;
	}


	public int getNoArticle() {
		return 0;
	}


	public int getNoUtilisateur() {
		return 0;
	}

	
}
