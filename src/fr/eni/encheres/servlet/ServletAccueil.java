package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ACCUEIL="/WEB-INF/accueil.jsp";
	

     // NOTE POUR SANDRINE : avec les c : if utilisateur connecté, display bouton Déconnexion + action
	
	
	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ACCUEIL).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession ();
		String pseudo = "pseudo";
		request.setAttribute("pseudo", pseudo);
		pseudo = (String)session.getAttribute ( "pseudo" );
		String motdepasse = "motdepasse";
		request.setAttribute("motdepasse", motdepasse);
		pseudo = (String)session.getAttribute ( "pseudo" );
		
		this.getServletContext().getRequestDispatcher(ACCUEIL).forward( request, response );

	}

}
