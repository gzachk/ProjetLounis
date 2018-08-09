package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import model.Reponse;

public class QuestionnaireController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Questionnaire(doGet) Controller");
		

		
		request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);

		System.out.println("End Questionnaire(doGet) Controller\r");

	}// doGet()
//-----------------------------------------------------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Questionnaire(doPost) Controller");
		
		
//		String erreur = "";
//		
//		//Javascript verified so this is not usefull anymore
//		//String erreurnom = "";
//		
//		String identifiant = request.getParameter("identifiant");
//		String password = request.getParameter("password");
//		
//		if(identifiant.length()==0 || password.length()==0) {
//			erreur = "<br/>Un des champs est vide";
//			request.setAttribute("erreur", erreur);
//			
//			//erreurnom = "style=\"background-color:IndianRed\"";
//			//request.setAttribute("erreurnom", erreurnom);
//			
//			request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);
//		}else {
//			request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);
//			System.out.println("\rLogged in.\rWelcome "+identifiant+"\r");
//		}
		
		//request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);
		response.sendRedirect("questionnaire");
		
		System.out.println("End Questionnaire(doPost) Controller\r");
	}// doPost()
//-----------------------------------------------------------------------------------------------
	
	
}// - QuestionnaireController
