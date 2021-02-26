package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletDeconnexion
 */
@WebServlet("/ServletDeconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ACCUEIL = "/WEB-INF/ServletAccueil";
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)     
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); // On récupère la session 
		session.invalidate();
		//session = request.getSession(false); // on vérifie bien que la session est invalidée
		//response.getWriter().println("Session : " + session); // test
		// ou HttpServletRequest.getSession().invalidate()  
		// response.sendRedirect(request.getContextPath());    
		this.getServletContext().getRequestDispatcher(ACCUEIL).forward(request, response);

	}

	
	// Je n'envoie rien, donc rien dans doPost
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

// parametrer redirection auto vers page accueil