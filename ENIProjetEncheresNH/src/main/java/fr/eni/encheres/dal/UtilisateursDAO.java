package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.exceptions.BusinessException;

public interface UtilisateursDAO {
	
	public Utilisateurs selectByPseudo(String pseudo)throws BusinessException;

}
