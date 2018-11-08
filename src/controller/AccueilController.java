package controller;

//import java.io.File;
import java.io.IOException;
//import java.io.PrintStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.catalina.SessionEvent;

import bdd.UtilisateurBDD;
import bdd.UtilisateurBDDImpl;
import model.Utilisateur;

public class AccueilController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Accueil(doGet) Controller");
		
		System.out.println(response.getStatus());

		HttpSession session= request.getSession();
		
		request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
		System.out.println("End Accueil(doGet) Controller\r");

	}// doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.setOut(new PrintStream(new File("MonLog.txt")));
		System.out.println("Begin Accueil(doPost) Controller");
		
		HttpSession session= request.getSession();
//		System.out.println(session.isNew());
//		System.out.println("blabla: " + session.getAttribute("MySessionVariable"));
//		session.invalidate();
		
		String erreur = "";
		
		//Javascript verified so this is not usefull anymore
		//String erreurnom = "";
		
		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");
		boolean isAdmin = false;
		boolean isValid = false;
		
		System.out.println();
		
		@SuppressWarnings("unused")
		int indexUtilisateur = 0;
		
		Utilisateur utilisateurConnecte = new Utilisateur(2, false);
		
		UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
		ArrayList<Utilisateur> tableUser = listUtilisateurBDD.getListUsers();
		
		
		if(identifiant.length()==0 || password.length()==0) {
			erreur = "<br/>Un des champs est vide";
			request.setAttribute("erreur", erreur);
			request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
		}else {
			
			for (int i = 0; i < tableUser.size(); i++) {
				if (identifiant.equals(tableUser.get(i).getEmail()) && password.equals(listUtilisateurBDD.getUserPassword(tableUser.get(i).getIdUtilisateur()))) {
					utilisateurConnecte = tableUser.get(i);
					isAdmin = utilisateurConnecte.isAdmin();
					isValid = utilisateurConnecte.isValid();
					indexUtilisateur = i;
				}
			}
			
			
			// Verification si admin
			if(identifiant.equals(utilisateurConnecte.getEmail()) && isAdmin) {
				System.out.println("Bienvenu "+utilisateurConnecte.getPrenom());
				
				//gestion session(?)
				session = request.getSession(true);
				session.setAttribute("MySessionVariable", utilisateurConnecte.getPrenom());
				session.setAttribute("sessionIsAdmin", utilisateurConnecte.isAdmin());
				session.setAttribute("sessionIsValid", utilisateurConnecte.isValid());
				session.setAttribute("sessionUserId", utilisateurConnecte.getIdUtilisateur());
				System.out.print(" - - - Valeurs Session - Prenom(" + session.getAttribute("MySessionVariable"));
				System.out.print(") Admin("+session.getAttribute("sessionIsAdmin"));
				System.out.print(") Valide("+session.getAttribute("sessionIsValid"));
				System.out.println(") ID("+session.getAttribute("sessionUserId")+")");

				request.setAttribute("displayUtilisateurs", "none");
				request.setAttribute("displayParcours", "none");
				
				response.sendRedirect("admin");
			}else if (identifiant.equals(utilisateurConnecte.getEmail()) && isValid){
				
				//HttpServletRequest request1=null;
				
				//request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);
				session = request.getSession(true);
				session.setAttribute("MySessionVariable", utilisateurConnecte.getPrenom());
				session.setAttribute("sessionIsAdmin", utilisateurConnecte.isAdmin());
				session.setAttribute("sessionIsValid", utilisateurConnecte.isValid());
				session.setAttribute("sessionUserId", utilisateurConnecte.getIdUtilisateur());
				System.out.print(" - - - Valeurs Session - Prenom(" + session.getAttribute("MySessionVariable"));
				System.out.print(") Admin("+session.getAttribute("sessionIsAdmin"));
				System.out.print(") Valide("+session.getAttribute("sessionIsValid"));
				System.out.println(") ID("+session.getAttribute("sessionUserId")+")");
//******		session.setAttribute("MySessionVariableParcours", utilisateurConnecte.isAdmin());
				
				response.sendRedirect("parcours");
			}else {
//				response.sendRedirect("accueil");
				session.setAttribute("MySessionVariableAdmin", false);

				System.out.print(" - - - Valeurs Session - Prenom(" + session.getAttribute("MySessionVariable"));
				System.out.print(") Admin("+session.getAttribute("sessionIsAdmin"));
				System.out.print(") Valide("+session.getAttribute("sessionIsValid"));
				System.out.println(") ID("+session.getAttribute("sessionUserId")+")");
				session.invalidate();
				request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
			}
			
		}//end if()
		
		System.out.println("End Accueil(doPost) Controller\r");
	}// doPost()
}// - AccueilController
