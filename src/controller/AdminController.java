package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.ParcoursBDD;
import bdd.UtilisateurBDD;
import bdd.UtilisateurBDDImpl;
import model.Question;
import model.Quizz;
import model.Utilisateur;

public class AdminController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Admin(doGet) Controller");
		
		HttpSession session= request.getSession();
//		System.out.println(session.isNew());
		
		if ((boolean) session.getAttribute("MySessionVariableAdmin")) {
			ParcoursBDD listParcoursBDD = new ParcoursBDD();
			request.setAttribute("tableQuizz", listParcoursBDD.getAllQuizz());
			
			UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
			ArrayList<Utilisateur> listeUsers= listUtilisateurBDD.getListUsers(); 
			ArrayList<Utilisateur> tableUser = new ArrayList<>();
			for (int i = 0; i < listeUsers.size(); i++) {
				if (!listeUsers.get(i).isAdmin()) {
					tableUser.add(listeUsers.get(i));
				}
			}
			request.setAttribute("tableUser", tableUser);
			
			request.setAttribute("displayUtilisateurs", "none");
			request.setAttribute("displayParcours", "none");
			request.setAttribute("displayAttributionParcours", "none");
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		}else {
			response.sendRedirect("parcours");
		}
		

		
		System.out.println("End Admin(doGet) Controller\r");

	}// doGet()
		// -----------------------------------------------------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Admin(doPost) Controller");
		
		request.setAttribute("displayUtilisateurs", "none");
		request.setAttribute("displayParcours", "none");
		request.setAttribute("displayAttributionParcours", "none");

		if (request.getParameter("adminStg").equals("Search")) {
			System.out.println(request.getParameter("adminStg"));
			rechercheStg(request, response);
		}
		if (request.getParameter("adminStg").equals("Get New Users")) {
			System.out.println(request.getParameter("adminStg"));
			recupererNouveauxStg(request, response);
		}
		if (request.getParameter("adminStg").equals("Get All Users")) {
			System.out.println(request.getParameter("adminStg"));
			recupererTousStg(request, response);
		}
		if (request.getParameter("adminStg").equals("Valider")) {
			System.out.println(request.getParameter("adminStg"));
			validerNouveauxStg(request, response);
		}
		if (request.getParameter("adminStg").equals("Supprimer")) {
			System.out.println(request.getParameter("adminStg"));
			supprimerStg(request, response);
		}
		if (request.getParameter("adminStg").equals("Get Quizz")) {
			System.out.println(request.getParameter("adminStg"));
			recupererTousQuizz(request, response);
			
		}
		if (request.getParameter("adminStg").equals("Ajouter")) {
			System.out.println(request.getParameter("adminStg"));
			insererCompetence(request, response);
		}
		if (request.getParameter("adminStg").equals("SupprimerQuizz")) {
			System.out.println(request.getParameter("adminStg"));
			supprimerCompetence(request, response);
		}
		if (request.getParameter("adminStg").equals("Nouvelle Question")) {
			System.out.println(request.getParameter("adminStg"));
			creationQuestion(request, response);
		}
		if (request.getParameter("adminStg").equals("Inserer")) {
			System.out.println(request.getParameter("adminStg"));
			insererQuestion(request, response);
		}

		System.out.println("End Admin(doPost) Controller\r");
	}// doPost()
		// -----------------------------------------------------------------------------------------------

	protected void rechercheStg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String erreur = "";
		String retrouve = "";
		String testRetour = "";
		String recherche = request.getParameter("recherche");
		
		request.setAttribute("displayUtilisateurs", "block");

		UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
		ArrayList<Utilisateur> userTrouve = new ArrayList<>();

		if (recherche.length() == 0) {
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		} else {
			
			userTrouve = listUtilisateurBDD.getUser(recherche);
			System.out.println(recherche);
			
			
			if (userTrouve.size()>0) {
				retrouve = "stagiaireListe.jsp";
				request.setAttribute("retrouve", retrouve);

				request.setAttribute("testRetour", testRetour);

				request.setAttribute("tableUser", userTrouve);
				
			} else {
				erreur = "<br/>" + recherche + " n'existe pas.";
				request.setAttribute("erreur", erreur);
			}
			// request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			request.getRequestDispatcher("WEB-INF/admin.jsp").include(request, response);

		} // end if()

	}// rechercheStg()
		// -----------------------------------------------------------------------------------------------

	protected void recupererTousStg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";
		String retrouve = "";

		request.setAttribute("displayUtilisateurs", "block");

		UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
		ArrayList<Utilisateur> tableUser = listUtilisateurBDD.getListUsers();

		if (tableUser.size() > 0) {
			// placeholder
			retrouve = "stagiaireListe.jsp";
			request.setAttribute("retrouve", retrouve);
			request.setAttribute("tableUser", tableUser);
			
			
			// A REVOIR !
//			getServletContext().setAttribute("tableUserAll", tableUser);

		} else {
			erreur = "<br/>Liste vide.";
			request.setAttribute("erreur", erreur);
		}
		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

	}// recupererTousStg()
// -----------------------------------------------------------------------------------------------

	protected void recupererNouveauxStg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";
		String retrouve = "";

		request.setAttribute("displayUtilisateurs", "block");

		UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
		ArrayList<Utilisateur> tableUser = listUtilisateurBDD.getListNewUsers();

		if (tableUser.size() > 0) {
			// placeholder
			retrouve = "newStagiaireListe.jsp";
			request.setAttribute("retrouveNew", retrouve);
			request.setAttribute("tableUser", tableUser);

		} else {
			erreur = "<br/>Liste vide.";
			request.setAttribute("erreur", erreur);
		}
		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	}// recupererNouveauxStg()
// -----------------------------------------------------------------------------------------------

		protected void validerNouveauxStg(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String erreur = "";

			request.setAttribute("displayUtilisateurs", "block");

			UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
			ArrayList<Utilisateur> tableUser = listUtilisateurBDD.getListNewUsers();
			ArrayList<Utilisateur> tableUtilisateurValider = new ArrayList<>();
			
			System.out.println("valider");
			System.out.println(request.getParameter("validerUser0")+" ----------------------- ");
			
			for (int i = 0; i < tableUser.size(); i++) {
				
				if (request.getParameter("validerUser" +i)!= null) {
					System.out.println("user "+i+  " valider" );
					
					if (request.getParameter("user"+i+"IsAdmin")!=null) {
						System.out.println(("user "+i+ " is Admin"));
						
						tableUser.get(i).setAdmin(true);
					}
					
					tableUser.get(i).setValid(true);
					tableUtilisateurValider.add(tableUser.get(i));
				}//end if
				
			}// end for 
			
			if (tableUtilisateurValider.size()> 0) {
				System.out.println("liste valider");
				
				listUtilisateurBDD.validerUser(tableUtilisateurValider);
				
				erreur = "<br/>Utilisateur(s) valide";
				request.setAttribute("erreur", erreur);
			}else {				
				erreur = "<br/>Aucun utilisateurs de valide";
				request.setAttribute("erreur", erreur);
			}
			

			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		}// validerNouveauxStg()
// -----------------------------------------------------------------------------------------------

	protected void supprimerStg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";

		request.setAttribute("displayUtilisateurs", "block");
		
		System.out.println("method supprimerStg");
		
		UtilisateurBDDImpl listUtilisateurBDD = new UtilisateurBDD();
		ArrayList<Utilisateur> tableUtilisateurSupprimer = new ArrayList<>();
		
		ArrayList<Integer> idUtilisateurASupprimer = new ArrayList<>();
		
		int nbrOfRows = Integer.parseInt(request.getParameter("nbrOfRowsInTable"));
		System.out.println("\r - - - - - - > "+nbrOfRows+"\r");
		
		
		// Recuperation Id Utilisateur
		for (int i = 0; i < nbrOfRows; i++) {
			String testParse = request.getParameter("delUser"+i);
			if(testParse != null) {
				idUtilisateurASupprimer.add(Integer.parseInt(request.getParameter("delUser"+i)));
			}
		}
		if(!idUtilisateurASupprimer.isEmpty()) {
			tableUtilisateurSupprimer = listUtilisateurBDD.getUserById(idUtilisateurASupprimer);
		}
		//Suppression Utilisateur
		if (!tableUtilisateurSupprimer.isEmpty()) {

			listUtilisateurBDD.deleteUser(tableUtilisateurSupprimer);

			erreur = "<br/>Utilisateur(s) supprime";
			request.setAttribute("erreur", erreur);
		} else {
			erreur = "<br/>Aucun utilisateurs de supprime";
			request.setAttribute("erreur", erreur);
		}
		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	}// supprimerStg()
// -----------------------------------------------------------------------------------------------

	protected void recupererTousQuizz(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erreur = "";
		String retrouve = "";
		
		request.setAttribute("displayParcours", "block");

		ParcoursBDD listParcoursBDD = new ParcoursBDD();
		ArrayList<Quizz> tableQuizz = listParcoursBDD.getAllQuizz();

		if (tableQuizz.size() > 0) {
			// placeholder
			retrouve = "listeQuizz.jsp";
			request.setAttribute("retrouve", retrouve);
			request.setAttribute("tableQuizz", tableQuizz);

		} else {
			erreur = "<br/>Liste competence vide.";
			request.setAttribute("erreur", erreur);
		}
		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

	}// recupererTousQuizz()
	
// -----------------------------------------------------------------------------------------------

	protected void insererCompetence(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String erreur = "";
		String retrouve = "";
		String testRetour = "";
		String nouvelleCompetence = request.getParameter("nouvelleCompetence");
		
		request.setAttribute("displayParcours", "block");

		ParcoursBDD listParcoursBDD = new ParcoursBDD();
//		ArrayList<Utilisateur> userTrouve = new ArrayList<>();

		if (nouvelleCompetence.length() == 0) {
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		} else {

//			userTrouve = listUtilisateurBDD.getUser(nouvelleCompetence);
			System.out.println(nouvelleCompetence);
			
			if(listParcoursBDD.addCompetence(nouvelleCompetence)) {
				erreur = "<br/>Competence inserer.";
				request.setAttribute("erreur", erreur);

			} else {
				System.out.println("  Echec de l'insertion");
				erreur = "<br/>Echec insertion.";
				request.setAttribute("erreur", erreur);
			}
				
			
			// request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			request.getRequestDispatcher("WEB-INF/admin.jsp").include(request, response);

		} // end if()
	}// insererCompetence()
	
// -----------------------------------------------------------------------------------------------

		protected void supprimerCompetence(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String erreur = "";

			request.setAttribute("displayParcours", "block");
			
			System.out.println("method supprimerCompetence");
			
			ParcoursBDD listParcoursBDD = new ParcoursBDD();
			ArrayList<Quizz> tableQuizz = new ArrayList<>();
			
			ArrayList<String> idCompetence= new ArrayList<>();
			
			int nbrOfRows = Integer.parseInt(request.getParameter("nbrOfRowsInTable"));
			System.out.println("\r nbre de matiere "+nbrOfRows+"\r");
			
			
			// Recuperation Id Competence
			for (int i = 0; i < nbrOfRows; i++) {
				String testParse = request.getParameter("delQuizz"+i);
				if(testParse != null) {
					idCompetence.add(request.getParameter("delQuizz"+i));
					System.out.println(request.getParameter("delQuizz"+i));
				}
			}
			if(!idCompetence.isEmpty()) {
				listParcoursBDD.deleteCompetence(idCompetence);
				erreur = "<br/>Quizz(s) supprime";
				
			}else {
				erreur = "<br/>Aucun quizz de supprime";
				request.setAttribute("erreur", erreur);
			}
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		}// supprimerCompetence()
	
// -----------------------------------------------------------------------------------------------

		protected void creationQuestion(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String erreur = "";
			String retrouve = "";
			
			request.setAttribute("displayParcours", "block");

			ParcoursBDD listParcoursBDD = new ParcoursBDD();

				retrouve = "question.jsp";
				request.setAttribute("retrouve", retrouve);
				request.setAttribute("tableQuizz", listParcoursBDD.getAllQuizz());

			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

		}// creationQuestion()
		
// -----------------------------------------------------------------------------------------------

		protected void insererQuestion(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String erreur = "";
			String retrouve = "";
			ArrayList<String> listeReponse = new ArrayList<>();
			
			request.setAttribute("displayParcours", "block");
			
			System.out.println("inserer question");
			System.out.println(request.getParameter("questionAInserer"));
			System.out.println(request.getParameter("competenceChoisie"));
//			System.out.println(request.getParameter("bonnereponse"));
//			System.out.println(request.getParameter(request.getParameter("bonnereponse")));
	
			for (int i = 1; i <= 4; i++) {
				listeReponse.add(request.getParameter("reponse" + i ));
				System.out.println(listeReponse.get(i-1));
			}
			
			ParcoursBDD listParcoursBDD = new ParcoursBDD();
			Question questionAInserer = new Question(request.getParameter("questionAInserer"), listParcoursBDD.getIdQuizz(request.getParameter("competenceChoisie")));
			listParcoursBDD.addQuestion(questionAInserer, listeReponse, request.getParameter(request.getParameter("bonnereponse")));
			
			
			
			
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

		}// insererQuestion()
		
		
		

}// - AdminController
