package model;

import java.util.ArrayList;

import bdd.ParcoursBDD;

public class Question {
	protected int idQuestion;
	protected String texte;
	protected int idReponseCorrect;
	protected int idQuizz;
	protected ArrayList<Reponse> listeReponses;
	private ParcoursBDD parcoursBDD;
	// -------------------------------------------------------------------------
	public Question(int idQuestion, String texte, int idReponseCorrect, int idQuizz, ArrayList<Reponse> listeReponses) {
		super();
		this.idQuestion = idQuestion;
		this.texte = texte;
		this.idReponseCorrect = idReponseCorrect;
		this.idQuizz = idQuizz;
		this.listeReponses = listeReponses;
	}
	
	public Question(String texte, int idQuizz) {
		super();
		this.texte = texte;
		this.idQuizz = idQuizz;
	}

	public Question() {
		super();
	}
	

	// -------------------------------------------------------------------------
	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getIdreponseCorrect() {
		return idReponseCorrect;
	}

	public void setIdReponseCorrect(int idReponseCorrect) {
		this.idReponseCorrect = idReponseCorrect;
	}

	public int getIdQuizz() {
		return idQuizz;
	}

	public void setIdQuizz(int idQuizz) {
		this.idQuizz = idQuizz;
	}

	public ArrayList<Reponse> getListeReponses() {
		return listeReponses;
	}

	public void setListeReponses(ArrayList<Reponse> listeReponses) {
		this.listeReponses = listeReponses;
	}

	public int getIdReponseCorrect() {
		return idReponseCorrect;
	}
	
	// -------------------------------------------------------------------------


}// - Question
