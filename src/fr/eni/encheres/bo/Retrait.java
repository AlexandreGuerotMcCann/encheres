package fr.eni.encheres.bo;

public class Retrait {

	private int noArticle;
	private String rue;
	private String codePostal; // String car VARCHAR en BDD
	private String ville;

	// Constructeur sans paramètres
	public Retrait() {

	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	// Getter et Setter
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @return the code_postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCodePostal(String code_postal) {
		this.codePostal = code_postal;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
}
