package fr.eni.encheres;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

// BusinessException = Erreur liées aux données du projets incomplètes ou manquantes 
public class BusinessException extends Exception {
	private List<Integer> listeErreurs;

	public BusinessException() {
		super();
		this.listeErreurs = new ArrayList<>();

	}

public BusinessException(int erreurInsertion) {
	}

	//Ajout du code d'erreur, s'il est inexistant.
	public void ajouterErreur(int codeErreur) {
		if (!this.listeErreurs.contains(codeErreur)) {
			this.listeErreurs.add(codeErreur);
		}
}


//	Getter retournant la liste des codes erreurs
	public List<Integer> getListeErreurs() {
		return this.listeErreurs;
	}

//		public boolean hasErreurs()
//	{
//		return this.listeCodesErreurs.size()>0;
//	}
}