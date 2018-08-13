package model;

public class Parcours {
	protected int idParcours;
	protected int idQuizz;
	protected int idUtilisateur;
	protected int score = 0;
	protected boolean parcoursValider;
	protected String dureeParcours; 
// ---------------------------------------------------------------------------------
	public Parcours() {
		super();
	}
	public Parcours(int idParcours, int idQuizz, int idUtilisateur, int score, boolean parcoursValider,
			String dureeParcours) {
		super();
		this.idParcours = idParcours;
		this.idQuizz = idQuizz;
		this.idUtilisateur = idUtilisateur;
		this.score = score;
		this.parcoursValider = parcoursValider;
		this.dureeParcours = dureeParcours;
	}
	public Parcours(int idParcours, int idQuizz, int idUtilisateur, int score) {
		super();
		this.idParcours = idParcours;
		this.idQuizz = idQuizz;
		this.idUtilisateur = idUtilisateur;
		this.score = score;
	}
	public Parcours(int idParcours, int idQuizz, int idUtilisateur) {
		super();
		this.idParcours = idParcours;
		this.idQuizz = idQuizz;
		this.idUtilisateur = idUtilisateur;
	}
	public Parcours(int idQuizz, int idUtilisateur) {
		super();
		this.idQuizz = idQuizz;
		this.idUtilisateur = idUtilisateur;
	}
	
// ---------------------------------------------------------------------------------
	public int getIdParcours() {
		return idParcours;
	}
	public void setIdParcours(int idParcours) {
		this.idParcours = idParcours;
	}
	public int getIdQuizz() {
		return idQuizz;
	}
	public void setIdQuizz(int idQuizz) {
		this.idQuizz = idQuizz;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isParcoursValider() {
		return parcoursValider;
	}
	public void setParcoursValider(boolean parcoursValider) {
		this.parcoursValider = parcoursValider;
	}
	public String getDureeParcours() {
		return dureeParcours;
	}
	public void setDureeParcours(String dureeParcours) {
		this.dureeParcours = dureeParcours;
	}
	
// ---------------------------------------------------------------------------------
	
	
}// - Parcours
