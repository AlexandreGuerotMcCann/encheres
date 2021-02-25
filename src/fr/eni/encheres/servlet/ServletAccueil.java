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
	 
	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)    
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ACCUEIL).forward( request, response );
		
//		if (session.getAttribute("no_utilisateur")!=null) // Si utilisateur connecté  
//		{
//			this.getServletContext().getRequestDispatcher("/ServletAccueilConnecte").forward(request, response);  // On go à l'accueil en mode connecté
 //   	}
//		else 
//		{fdsfsdfsd
 //   		this.getServletContext().getRequestDispatcher("/ServletAccueilDeconnecte").forward(request, response); // Sinon on go a l'accueil en mode déconnecté
//		}   //(sans display du bouton déconnexion)
//		
//		this.getServletContext().getRequestDispatcher(ACCUEIL).forward( request, response ); // OK A GARDER
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
