package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ParcoursBDD;
import model.Quizz;

public class QuizzController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Quizz(doGet) Controller");
		ParcoursBDD instanceParcoursBDD = new ParcoursBDD();
		ArrayList<Quizz> listeQuizz = instanceParcoursBDD.getAllQuizz();
		
		System.out.println("blabla:" + request.getParameter("competence"));
		
		for (int i = 0; i < listeQuizz.size(); i++) {
			
			if (request.getParameter("competence").equals(listeQuizz.get(i).getIdCompetence())) {
				request.setAttribute("listeQuestions", instanceParcoursBDD.getQuizz(listeQuizz.get(i).getIdCompetence()));
				request.setAttribute("competenceQuizz", listeQuizz.get(i).getIdCompetence());
			}
			
		}
		request.getRequestDispatcher("WEB-INF/quizz.jsp").forward(request, response);

		System.out.println("End Quizz(doGet) Controller\r");

	}// doGet()
	// -----------------------------------------------------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Quizz(doPost) Controller");
		
		
		System.out.println("\rNombre de Question dans le quizz: "+request.getParameter("nbrOfQuestions"));
		int nbreQuestions = Integer.parseInt(request.getParameter("nbrOfQuestions"));
		for (int i = 1; i <= nbreQuestions; i++) {
			int nbreReponses = Integer.parseInt(request.getParameter("nbrOfReponses"+i));
			
			System.out.println(" - Nombre de reponse possible(Q"+i+"): " + nbreReponses);
			System.out.println("    -> Reponse choisie: "+request.getParameter("reponseCoche" + i)+"\r");
		}// for(i)
	//	System.out.println(request.getParameter("reponseCoche2cdevfrvgrgt"));
		

		System.out.println("End Quizz(doPost) Controller\r");
	}// doPost()

}// - QuizzController