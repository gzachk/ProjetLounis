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
		
		HttpSession session = request.getSession();
//		session.getAttribute("MySessionVariable");
//		session.getAttribute("sessionIsAdmin");
//		session.getAttribute("sessionUserId");

		System.out.print(" - - - Valeurs Session - Prenom(" + session.getAttribute("MySessionVariable"));
		System.out.print(") Admin("+session.getAttribute("sessionIsAdmin"));
		System.out.print(") Valide("+session.getAttribute("sessionIsValid"));
		System.out.println(") ID("+session.getAttribute("sessionUserId")+")");
		
		if(session.getAttribute("sessionIsValid") == null) {
			System.out.println(" - - - Redirection page accueil(login)");
			response.sendRedirect("accueil");
		}else {
			int idUserConnecte = (Integer) session.getAttribute("sessionUserId");
			
			ParcoursBDD instanceParcoursBDD = new ParcoursBDD();
			ArrayList<Quizz> listeQuizz = new ArrayList<>();
			
			//Parcours pour utilisateur admin(if) et non admin(else)
			if((boolean) session.getAttribute("sessionIsAdmin")) {
				listeQuizz = instanceParcoursBDD.getAllQuizz();				
			}else {
				try {
					listeQuizz = instanceParcoursBDD.getListQuizzUtilisateur(idUserConnecte);
				} catch (Exception e) {
					//Quizz emptyQuizz = new Quizz(-999, "En cours d'attribution");
					//listeQuizz.add(emptyQuizz);
					System.out.println("/!\\ - Utilisateur sans parcours - /!\\");
				}
			}
			
			//Transfert liste a la jsp
			if (listeQuizz.size() > 0 ) {
				request.setAttribute("listeDesCompets", listeQuizz);
			}else {
				System.out.println("Retour de parcours vide.");
			}
			request.getRequestDispatcher("WEB-INF/parcours.jsp").forward(request, response);
		}
		
		System.out.println("End Parcours(doGet) Controller\r");
	}// doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Parcours(doPost) Controller");
		
		

		System.out.println("End Parcours(doPost) Controller\r");
	}// doPost()
}// - ParcoursController
