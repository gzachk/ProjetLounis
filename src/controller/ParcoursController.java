package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.ParcoursBDD;
import model.Quizz;

public class ParcoursController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Parcours(doGet) Controller");
		
		ParcoursBDD instanceParcoursBDD = new ParcoursBDD();
		ArrayList<Quizz> listeQuizz = instanceParcoursBDD.getAllQuizz();
		if (listeQuizz.size() > 0 ) {
			request.setAttribute("listeDesCompets", listeQuizz );
			
		}
		HttpSession session = request.getSession(true);
		session.getAttribute("MySessionVariable");

		request.getRequestDispatcher("WEB-INF/parcours.jsp").forward(request, response);

		System.out.println("End Parcours(doGet) Controller\r");

	}// doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Parcours(doPost) Controller");
		
		

		System.out.println("End Parcours(doPost) Controller\r");
	}// doPost()

}// - ParcoursController
