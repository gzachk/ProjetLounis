package model;

public class Reponse {
	protected int idReponse;
	protected String texte;
	protected int idQuestion;
//-------------------------------------------------------------------------
	public Reponse(int idReponse, String texte, int idQuestion) {
	super();
	this.idReponse = idReponse;
	this.texte = texte;
	this.idQuestion = idQuestion;
}
	public Reponse(String texte) {
		super();
		this.texte = texte;
	}
	public Reponse() {
		super();
	}
//-------------------------------------------------------------------------
	public int getIdReponse() {
		return idReponse;
	}
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
//-------------------------------------------------------------------------

}// - Reponse
