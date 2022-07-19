package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.UtilisateursDAOJdbcImpl;

public abstract class DAOFactory {
	
	public static UtilisateursDAO getUtilisateursDAO()
	{
		return new UtilisateursDAOJdbcImpl();
	}
}
	