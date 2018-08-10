package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Parcours;
import model.Question;
import model.Quizz;
import model.Reponse;

public class ParcoursBDD {
	protected static Connection conn = null;
	protected static PreparedStatement prepStmt = null;

	public static void jdbcConnect() {
		// Print.tirets();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// System.out.println("- Driver loading succesful -");

			// Connect (localhost:3306 -> Windows ports)
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_questionnaire", "root", "");
			System.out.println("- Connection opened -");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// jdbcConnect()

	public static void jdbcDisconnect() {
		try {
			if (prepStmt != null)
				prepStmt.close();
			// System.out.println("Statement closed");
		} catch (SQLException se2) {
		}

		try {
			if (conn != null)
				conn.close();
			System.out.println("- Connection closed -");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}// jdbcDisconnect()

	// -------------------------------------------------------------------------------

	public ArrayList<Question> getQuestion(int idQuizzRecherche) {
		ResultSet res = null;
		Question question = null;

		String sql = "SELECT * FROM `question` WHERE `id_quizz` = '" + idQuizzRecherche + "'";

		ArrayList<Question> listQuestions = new ArrayList<Question>();

		try {
			int idQuestion;
			String texte = null;
			int idReponseCorrect;
			int idQuizz;

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);

			int numeroTemporairePourSysout = 0;
			while (res.next()) {
				idQuestion = res.getInt("ID_QUESTION");
				texte = res.getString("TEXTE");
				idReponseCorrect = res.getInt("ID_REPONSE_CORRECT");
				idQuizz = res.getInt("ID_QUIZZ");

				numeroTemporairePourSysout++;
				System.out.println("QUESTION " + numeroTemporairePourSysout + ": " + texte);
				question = new Question(idQuestion, texte, idReponseCorrect, idQuizz, getReponse(idQuestion));

				listQuestions.add(question);
				// System.out.println(question.getTexte());
				// System.out.println("nbre rep possible: " +
				// question.getListeReponses().size());
				System.out.println(" --> id rep correcte: " + question.getIdreponseCorrect());
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listQuestions;
	}// getQuestion();

	// -------------------------------------------------------------------------------

	public ArrayList<Reponse> getReponse(int idQuestionRecherche) {
		ResultSet res = null;

		String sql = "SELECT * FROM `reponse` WHERE `id_question` = '" + idQuestionRecherche + "'";

		ArrayList<Reponse> listReponses = new ArrayList<Reponse>();

		try {
			int idQuestion;
			String texte = null;
			int idReponse;

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);

			int numeroTemporairePourSysout = 0;
			while (res.next()) {
				idQuestion = res.getInt("ID_QUESTION");
				texte = res.getString("TEXTE");
				idReponse = res.getInt("ID_REPONSE");

				Reponse reponse = new Reponse(idReponse, texte, idQuestion);

				listReponses.add(reponse);

				numeroTemporairePourSysout++;
				System.out.println(numeroTemporairePourSysout + ") " + reponse.getTexte());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listReponses;
	}// getReponse();

	// -------------------------------------------------------------------------------

	public ArrayList<Question> getQuizz(String competence) {

		jdbcConnect();

		ResultSet res = null;

		String sql = "SELECT * FROM `quizz` WHERE `id_competence` = '" + competence + "'";

		Quizz quizzRecupere = new Quizz();

		try {
			int idQuizz;
			String idCompetence = null;

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);

			while (res.next()) {
				idQuizz = res.getInt("ID_QUIZZ");
				idCompetence = res.getString("ID_COMPETENCE");

				quizzRecupere = new Quizz(idQuizz, idCompetence);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\rCompetence: " + quizzRecupere.getIdCompetence());

		ArrayList<Question> questionsDuQuizz = getQuestion(quizzRecupere.getIdQuizz());

		// -- Test Nombre Aleatoire --
		// int randomNumberTest = questionsDuQuizz.size();
		//
		// for (int i = 0; i < 10; i++) {
		//
		//// randomNumberTest = (int) (Math.random()*randomNumberTest +1);
		// randomNumberTest = (int) (Math.random()*10+1);
		// System.out.println(" -- -- -- -- -- -- Numero
		// aleatoire("+questionsDuQuizz.size()+"): "+randomNumberTest);
		// }
		// -- Fin du TEST --

		jdbcDisconnect();
		return questionsDuQuizz;
	}// getQuizz();

	// ----------------------------------------------------------------------------------

	public boolean addQuestion(Question question, ArrayList<String> listesDesReponses, String reponseCorrecte) {
		boolean statut = false;
		String sql = "";
		ResultSet res = null;

		jdbcConnect();
		// Insertion de la nouvelle question
		try {
			sql = "INSERT INTO QUESTION (texte, id_quizz)" + "VALUES (?, ?)";

			prepStmt = conn.prepareStatement(sql);

			prepStmt.setString(1, question.getTexte());

			prepStmt.setInt(2, question.getIdQuizz());

			prepStmt.executeUpdate();

			System.out.println("1/ insertion question reussi");

			// Recuperation id_question insere
			int idQuestion = 0;

			// sql = "SELECT id_question FROM QUESTION where texte=\""+ question.getTexte()
			// +"\"";

			// prepStmt = conn.prepareStatement(sql);
			prepStmt = conn.prepareStatement("SELECT id_question FROM QUESTION where texte=?");
			prepStmt.setString(1, question.getTexte());
			// res = prepStmt.executeQuery(sql);
			res = prepStmt.executeQuery();

			while (res.next()) {
				idQuestion = res.getInt("id_question");
			}
			System.out.println("2/ recuperation id question reussi(" + idQuestion + ")");

			// avec l'id_question, insertion des reponse
			for (int i = 0; i < listesDesReponses.size(); i++) {

				sql = "INSERT INTO REPONSE (texte, id_question)" + "VALUES (?, ?)";

				prepStmt = conn.prepareStatement(sql);

				prepStmt.setString(1, listesDesReponses.get(i));

				prepStmt.setInt(2, idQuestion);

				prepStmt.executeUpdate();

				if (i == listesDesReponses.size() - 1) {
					System.out.println("3/ insertion reponses possibles reussi");
				}

			} // fin for()

			// recuperation de l'id de la reponse correcte
			int idReponse = 0;

			// sql = "SELECT id_reponse FROM REPONSE where texte='" + reponseCorrecte + "'";

			// prepStmt = conn.prepareStatement(sql);
			prepStmt = conn.prepareStatement("SELECT id_reponse FROM REPONSE where texte=?");
			prepStmt.setString(1, reponseCorrecte);
			res = prepStmt.executeQuery();

			while (res.next()) {
				idReponse = res.getInt("id_reponse");
			}
			System.out.println("4/ recuperation id reponse correcte reussi(" + idReponse + ")");

			// injection id rep correcte dans question.

			sql = "UPDATE question SET `id_reponse_correct`= " + idReponse + " WHERE id_question = " + idQuestion;

			prepStmt = conn.prepareStatement(sql);

			prepStmt.executeUpdate();

			statut = true;
			System.out.println("5/ mise a jour question reussi");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Deconnexion imminente....");
		jdbcDisconnect();

		return statut;
	}// addQuestion()

	// -------------------------------------------------------------------------------

	public ArrayList<Quizz> getAllQuizz() {

		jdbcConnect();

		int numQuizz = 0;
		ResultSet res = null;

		String sql = "SELECT * FROM `quizz`";

		Quizz quizzRecupere = new Quizz();
		ArrayList<Quizz> listQuizz = new ArrayList<>();

		System.out.println();

		try {
			int idQuizz;
			String idCompetence = null;

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);

			while (res.next()) {
				idQuizz = res.getInt("ID_QUIZZ");
				idCompetence = res.getString("ID_COMPETENCE");

				quizzRecupere = new Quizz(idQuizz, idCompetence);
				listQuizz.add(quizzRecupere);

				numQuizz++;
				System.out.println("Competence(" + numQuizz + "): " + quizzRecupere.getIdCompetence());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("nbre de competence: " + listQuizz.size());
		System.out.println();
		jdbcDisconnect();
		return listQuizz;
	}// getAllQuizz();

	// ----------------------------------------------------------------------------------

	public boolean addCompetence(String competence) {
		boolean statut = false;
		String sql = "";

		jdbcConnect();
		// Insertion de la nouvelle competence

		if (!recuperationCompetence(competence)) {
			try {
				sql = "INSERT INTO COMPETENCE (sujet)" + "VALUES (?)";

				prepStmt = conn.prepareStatement(sql);

				prepStmt.setString(1, competence);

				prepStmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				sql = "INSERT INTO quizz (id_competence)" + "VALUES (?)";

				prepStmt = conn.prepareStatement(sql);

				prepStmt.setString(1, competence);

				prepStmt.executeUpdate();
				statut = true;

				System.out.println("  Competence " + competence + " inserer");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/*
		 * try { sql = "INSERT INTO QUIZZ (sujet)" + "VALUES (?)";
		 * 
		 * statut = true;
		 * 
		 * prepStmt = conn.prepareStatement(sql);
		 * 
		 * prepStmt.setString(1, competence);
		 * 
		 * prepStmt.executeUpdate();
		 * 
		 * System.out.println("	competence " + competence); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */

		System.out.println("Deconnexion imminente....");
		jdbcDisconnect();

		return statut;
	}// addCompetence()
	// ----------------------------------------------------------------------------------

	public boolean recuperationCompetence(String competence) {
		boolean statut = false;
		ResultSet res = null;
		String sql = "";

		try {
			sql = "SELECT * FROM COMPETENCE where sujet='" + competence + "'";

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);

			String idCompetence = null;

			while (res.next()) {
				idCompetence = res.getString("sujet");
			}
			if (idCompetence != null) {
				System.out.println("  La competence " + idCompetence + " existe deja");
				statut = true;
			} else {
				System.out.println("  La competence " + competence + " n'existe pas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statut;
	}// recuperationCompetence()

	// ---------------------------------------------------------------------------------------

	public void deleteCompetence(ArrayList<String> competenceList) {
		if (competenceList.size() > 0) {

			jdbcConnect();

			for (int i = 0; i < competenceList.size(); i++) {

				try {
					String sql = "DELETE FROM quizz WHERE id_competence = '" + competenceList.get(i) + "'";

					prepStmt = conn.prepareStatement(sql);
					prepStmt.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					String sql = "DELETE FROM competence WHERE sujet = '" + competenceList.get(i) + "'";
					System.out.println(" sujet a supprime: " + competenceList.get(i));

					prepStmt = conn.prepareStatement(sql);
					prepStmt.executeUpdate(sql);
					System.out.println(" - - > sujet supprime.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // end for

			jdbcDisconnect();
		}
	}// deleteCompetence()

	// -------------------------------------------------------------------------------

	public int getIdQuizz(String competence) {

		jdbcConnect();

		ResultSet res = null;

		String sql = "SELECT * FROM `quizz` WHERE `id_competence` = '" + competence + "'";

		Quizz quizzRecupere = new Quizz();

		try {
			int idQuizz;
			String idCompetence = null;

			prepStmt = conn.prepareStatement(sql);
			res = prepStmt.executeQuery(sql);

			while (res.next()) {
				idQuizz = res.getInt("ID_QUIZZ");
				idCompetence = res.getString("ID_COMPETENCE");

				quizzRecupere = new Quizz(idQuizz, idCompetence);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\rCompetence: " + quizzRecupere.getIdCompetence());
		System.out.println("\rIdQuizz: " + quizzRecupere.getIdQuizz());

		jdbcDisconnect();
		return quizzRecupere.getIdQuizz();
	}// getIdQuizz();

	// -------------------------------------------------------------------------------
	
	public Parcours getParcours(int idParcoursVoulu) {
		jdbcConnect();

		ResultSet res = null;

		String sql ="SELECT * FROM parcours WHERE id_parcours=?";
		Parcours parcoursRecupere = new Parcours();

		try {
			int idParcours;// p-e redondant...
			int idQuizz;
			int idUtilisateur;
			int score;

			prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, idParcoursVoulu);
			res = prepStmt.executeQuery(sql);

			while (res.next()) {
				idParcours = res.getInt("ID_PARCOURS");
				idQuizz = res.getInt("ID_QUIZZ");
				idUtilisateur = res.getInt("ID_UTILISATEUR");
				score = res.getInt("SCORE");
				
				parcoursRecupere = new Parcours(idParcours, idQuizz, idUtilisateur, score);
			}
			
			System.out.println(" - Recuperation Parcour reussi - ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		jdbcDisconnect();
		return parcoursRecupere;
	}
	// -------------------------------------------------------------------------------
	
	public Parcours getlistParcours(int idParcoursVoulu) {
		jdbcConnect();

		ResultSet res = null;

		String sql ="SELECT * FROM parcours WHERE id_parcours=?";
		
		Parcours parcoursRecupere = new Parcours();

		try {
			int idParcours;// p-e redondant...
			int idQuizz;
			int idUtilisateur;
			int score;

			prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, idParcoursVoulu);
			res = prepStmt.executeQuery(sql);

			while (res.next()) {
				idParcours = res.getInt("ID_PARCOURS");
				idQuizz = res.getInt("ID_QUIZZ");
				idUtilisateur = res.getInt("ID_UTILISATEUR");
				score = res.getInt("SCORE");
				
				parcoursRecupere = new Parcours(idParcours, idQuizz, idUtilisateur, score);
			}
			
			System.out.println(" - Recuperation Parcour reussi - ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		jdbcDisconnect();
		return parcoursRecupere;
	}
	// -------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------
}// - ParcoursBDD
