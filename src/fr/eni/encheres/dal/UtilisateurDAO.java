package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	public List<Utilisateur> selectAll() throws BusinessException;

	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;

//TODO : checker erreur
	public void ajoutUtilisateur(Utilisateur utlisateur) throws BusinessException;

	// Méthode à tester /!\ => à lier avec pageMonProfil => bouton "Supprimer mon*
	// compte" (cf.maquette)
	public void supprimerUtilisateur(int no_utilisateur) throws BusinessException;

	// Méthode à tester /!\ => à lier avec pageModifierProfil => bouton
	// "Enregistrer" (cf.maquette p.7 & 8/13)
	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur selectById(int id) throws BusinessException;

}
