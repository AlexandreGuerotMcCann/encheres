package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;

public interface CategoriesDAO {

	Object selectById(int int1);

	List<Categorie> selectAll() throws BusinessException;

}
