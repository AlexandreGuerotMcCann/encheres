package fr.eni.encheres.dal;

public abstract class CodesErreursDAL {
/* CONVENTION : codes entre 10000 et 19999 */
	
//
	public static final int ECHEC_LECTURE_LISTE_UTILISATEURS =10001;
	
// Erreur si Les ID ne correspondent pas en BDD
	public static final int ERREURS_IDENTIFIANTS= 10002;
	
// Erreur lors de la création d'un compte utilisateur
	public static final int ERREUR_INSERTION = 10003;
	
// Erreur lors de la suppression du compte de l'utilisateur
	public static final int ERREUR_SUPPRESSION_UTILISATEUR = 10004;
	
// Erreur lors de la mise à jour du compte de l'utilisateur
	public static final int ERREUR_MISE_A_JOUR_UTILISATEUR = 10005;

	public static final int ERREUR_ID = 10006;
//Aucun utilisateur enregistré en BDD
	public static final int ERREUR_AUCUN_UTILISATEUR = 10007;
}
