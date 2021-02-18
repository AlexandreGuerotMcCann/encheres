package fr.eni.encheres.dal;

public abstract class CodesErreursDAL {
//	convetion : codes entre 10000 et 19999
	
	//
	public static final int ECHEC_LECTURE_LISTE_UTILISATEURS =10001;
//	Message d'erreur si Les ID ne correspondent pas en BDD
	public static final int ERREURS_IDENTIFIANTS= 10002;
	public static final int ERREUR_INSERTION = 10003;
}
