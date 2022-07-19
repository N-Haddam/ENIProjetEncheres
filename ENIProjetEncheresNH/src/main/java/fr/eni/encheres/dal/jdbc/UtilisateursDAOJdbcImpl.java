package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.UtilisateursDAO;
import fr.eni.encheres.exceptions.BusinessException;
import fr.eni.encheres.dal.CodesResultatDAL;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {

	private static final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";

	@Override
	public Utilisateurs selectByPseudo(String pseudo)throws BusinessException {
		
		Utilisateurs retour = new Utilisateurs();
		
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				retour.setNoUtilisateur(rs.getInt("no_utilisateur"));
				retour.setPseudo(rs.getString("pseudo"));
				retour.setNom(rs.getString("nom"));
				retour.setPrenom(rs.getString("Prenom"));
				retour.setEmail(rs.getString("email"));
				retour.setTelephone(rs.getString("telephone"));
				retour.setRue(rs.getString("rue"));
				retour.setCodePostal(rs.getString("code_postal"));
				retour.setVille(rs.getString("ville"));
				retour.setMotDePasse(rs.getString("mot_de_passe"));
				retour.setCredit(rs.getInt("credit"));
				retour.setAdministrateur(rs.getBoolean("administrateur"));
			}else {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.PSEUDO_INEXISTANT);
				throw businessException;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECTION_BY_PSEUDO_CONNEXION_ECHEC);
			throw businessException;
			
		}

		return retour;
	}
	

}
