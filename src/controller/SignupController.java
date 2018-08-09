package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.UtilisateurBDD;
import model.Utilisateur;

public class SignupController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Signup(doGet) Controller");

		request.getRequestDispatcher("WEB-INF/signup.jsp").forward(request, response);

		System.out.println("End Signup(doGet) Controller\r");

	}// doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Signup(doPost) Controller");
		
		String erreur = "";
		
		//Javascript verified so this is not usefull anymore
		//String erreurnom = "";
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String societe = request.getParameter("societe");
		String password = request.getParameter("password");
		
		if(nom.length()==0 || prenom.length()==0 || email.length()==0 || telephone.length()==0 || societe.length()==0 || password.length() ==0) {
			erreur = "<br/>Un des champs est vide";
			request.setAttribute("erreur", erreur);
			
			//erreurnom = "style=\"background-color:IndianRed\"";
			//request.setAttribute("erreurnom", erreurnom);
			
			request.getRequestDispatcher("WEB-INF/signup.jsp").forward(request, response);
		}else {

			UtilisateurBDD listUtilisateurBDD = new UtilisateurBDD();
			Utilisateur nouvelUtilisateur = new Utilisateur(0, nom, prenom, email, telephone, societe, false, false);
			nouvelUtilisateur.setPassword(password);
			listUtilisateurBDD.addUser(nouvelUtilisateur);
			
			
			request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
			System.out.println("\rNew user is:\r"+nom+" "+prenom);
			System.out.println(email+"\r"+telephone+"\r"+societe+"\r");
		}
		
		System.out.println("End Signup(doPost) Controller\r");
	}// doPost()
}// - SignupController
