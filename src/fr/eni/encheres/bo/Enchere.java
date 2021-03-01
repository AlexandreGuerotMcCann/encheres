package fr.eni.encheres.bo;


import java.util.Date;

public class Enchere {
	
	private Date dateEnchere;
	private int montantEnchere;
	private int noEnchere;
	
	private int noUtilisateur;
	private int noArticle;
	
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
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montant_enchere) {
		this.montantEnchere = montant_enchere;
	}


	public void setNoEncheres(int noEnchere) {
		this.noEnchere=noEnchere;
	}


	public void setNoArticle(int noArticle) {
		
	}


	public void setNoUtilisateur(int noUtilisateur) {
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
