package fr.eni.encheres;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

// BusinessException = Erreur liées aux données du projets incomplètes ou manquantes 
public class BusinessException extends Exception {
	private List<Integer> listeCodesErreurs;

	public BusinessException() {
		super();
		this.listeCodesErreurs = new ArrayList<>();

	}

//Ajout du code d'erreur, s'il est inexistant.
	public void ajouterErreur(int codeErreur) {
		if (!this.listeCodesErreurs.contains(codeErreur)) {
			this.listeCodesErreurs.add(codeErreur);
		}
}


//	Getter retournant la liste des codes erreurs
	public List<Integer> getListeCodesErreurs() {
		return this.listeCodesErreurs;
	}

//		public boolean hasErreurs()
//	{
//		return this.listeCodesErreurs.size()>0;
//	}
}
