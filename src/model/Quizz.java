package model;

public class Quizz {
	private int idQuizz;
	private String idCompetence;

	// -----------------------------------------------------------------------------------
	public Quizz(int idQuizz, String idCompetence) {
		super();
		this.idQuizz = idQuizz;
		this.idCompetence = idCompetence;
	}

	public Quizz() {
		super();
	}

	// ---------------------------------------------------------------------------------
	public int getIdQuizz() {
		return idQuizz;
	}

	public void setIdQuizz(int idQuizz) {
		this.idQuizz = idQuizz;
	}

	public String getIdCompetence() {
		return idCompetence;
	}

	public void setIdCompetence(String idCompetence) {
		this.idCompetence = idCompetence;
	}
	// ------------------------------------------------------------------------------
}// - Quizz
