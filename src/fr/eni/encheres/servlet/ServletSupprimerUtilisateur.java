package fr.eni.encheres.servlet;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSupprimerUtilisateur
 */
@WebServlet("/ServletSupprimerUtilisateur")
public class ServletSupprimerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	Utilisateur utilisateur= null;
//	private static UtilisateurManager utilisateur ;

	public static final String ACCUEIL = "/WEB-INF/accueil.jsp";

	// On inclut la méthode pour supprimer l'utilisateur et ses données
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String identifiant=request.getParameter("pseudo");
		
			// On va chercher méthode de la BLL qui descend jusqu'à la BDD  
			// Types doivent être cohérents !
			try {
				utilisateur= utilisateurManager.retournerUtilisateur(identifiant);
				
				utilisateurManager.suppressionUtilisateurTest(identifiant);
				// On déconnecte la session
				session.invalidate();

				//Redirection vers accueil en mode déconnecté
				this.getServletContext().getRequestDispatcher(ACCUEIL).forward(request, response);
		
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
