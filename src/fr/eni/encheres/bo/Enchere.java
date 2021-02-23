package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {
	
	private Date dateEnchere;
	private int montant_enchere;
	
	// Constructeur sans paramètres
	public Enchere() {
		
	}
	
	
	// Getter et Setter
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date date_enchere) {
		this.dateEnchere = date_enchere;
	}
	public int getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public void setNoEncheres(int no_enchere) {
		// TODO Auto-generated method stub
		
	}


	public void setNoArticle(int no_article) {
		// TODO Auto-generated method stub
		
	}


	public void setNoUtilisateur(int no_utiilisateur) {
		// TODO Auto-generated method stub
		
	}


	public int getNoEnchere() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getNoArticle() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getNoUtilisateur() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
