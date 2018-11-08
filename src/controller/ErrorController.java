package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ErrorController
 */
@WebServlet("/ErrorController")
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Begin Error(doGet) Controller");

		System.out.println(response.getStatus());
		request.setAttribute("errorCode", response.getStatus());
		// HttpSession session= request.getSession();

		if(response.getStatus() == 200) {			
			response.sendRedirect("accueil");
		}else {
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);			
		}
		
		System.out.println("End Error(doGet) Controller\r");
	}// doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Begin Error(doPost) Controller");

		System.out.println(response.getStatus());

		// HttpSession session= request.getSession();

		request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		System.out.println("End Error(doPost) Controller\r");
	}
}// - ErrorController
