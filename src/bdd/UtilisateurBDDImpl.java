package bdd;

import java.util.ArrayList;

import model.Utilisateur;

public interface UtilisateurBDDImpl {
	public void jdbcConnect();

	public void jdbcDisconnect();
	
// -------------------------------------------------------------------------------

	public ArrayList<Utilisateur> getUser(String valeurRecherche);
	// -------------------------------------------------------------------------------
	
	public ArrayList<Utilisateur> getUserById(ArrayList<Integer> idRecherche);
	// -------------------------------------------------------------------------------
	
	public ArrayList<Utilisateur> getListUsers();
	// ----------------------------------------------------------------------------------
	
	public ArrayList<Utilisateur> getListNewUsers();
	// ----------------------------------------------------------------------------------

	public  boolean addUser(Utilisateur nouvelUtilisateur);
	// ----------------------------------------------------------------------------------

	public void validerUser(ArrayList<Utilisateur> utilisateurValider);
	//---------------------------------------------------------------------------------------
	
	public void removeFromNewUserTable(Utilisateur utilisateur);
	//---------------------------------------------------------------------------------------
	
	public void deleteUser(ArrayList<Utilisateur> utilisateurList);
	//---------------------------------------------------------------------------------------
	
	public void linkUserPassword(Utilisateur nouvelUtilisateur/*, String password*/);
	//---------------------------------------------------------------------------------------
	public String getUserPassword(int userID);
	//---------------------------------------------------------------------------------------
}// - UtilisateurBDDImpl
