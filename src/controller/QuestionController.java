package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.ParcoursBDD;
import model.Utilisateur;

public class QuestionController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Begin Question(doGet) Controller");
		

		
		
		request.getRequestDispatcher("WEB-INF/question.jsp").forward(request, response);

		System.out.println("End Question(doGet) Controller\r");

	}// doGet()
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Begin Question(doPost) Controller");
		
		System.out.println("End Question(doPost) Controller");		
	}// doPost()
	// ----------------------------------------------------------------------------------

}// -QuestionController