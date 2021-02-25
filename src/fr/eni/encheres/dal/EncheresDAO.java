package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;

public interface EncheresDAO {

	List<Enchere> selectAll() throws BusinessException;

	Enchere selectByNoEnchere(int no_enchere) throws BusinessException;

	public void supprimerEnchere(int no_enchere) throws BusinessException;

	public void modifierEnchere(Enchere enchere) throws BusinessException;

	public void ajoutEnchere(Enchere enchere) throws BusinessException;

}
