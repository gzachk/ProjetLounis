package model;

public class Utilisateur {
	protected int idUtilisateur;
	protected boolean isAdmin;
	protected boolean isValid;
	
	protected String nom;
	protected String prenom;
	protected String email;
	protected String telephone;
	protected String societe;
	protected String password;
//-------------------------------------------------------------------------
	public Utilisateur(int idUtilisateur, boolean isAdmin) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.isAdmin = isAdmin;
	}

	public Utilisateur(int idUtilisateur, String nom, String prenom, String email, String telephone,
			String societe, boolean isValid, boolean isAdmin) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.isAdmin = isAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.societe = societe;
		this.isValid = isValid;
	}
//-------------------------------------------------------------------------
@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", isAdmin=" + isAdmin + ", isValid=" + isValid
				+ ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", societe="
				+ societe + "]";
	}

	//-------------------------------------------------------------------------
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}// - Utilisateur
