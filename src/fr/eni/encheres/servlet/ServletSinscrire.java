package fr.eni.encheres.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

/**
 * Servlet implementation class ServletSinscrire
 ***/
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String SINSCRIRE = "/WEB-INF/sinscrire.jsp";


	//Map<String, String> listeErreurs = new HashMap<String, String>();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(SINSCRIRE).forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		UtilisateurManager utilisateurManager = new UtilisateurManager();	
		Utilisateur utilisateur;
		
		
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		String confirmMdp = request.getParameter("confirmMdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		
		try {
			
			if (!mdp.equals(confirmMdp))
			{
				request.setAttribute("erreurMDP", "Les mots de passe ne correspondent pas.");
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (utilisateurManager.retournerUtilisateur(pseudo) != null)
			 {
				request.setAttribute("pseudoBDD", "Ce pseudo existe déjà");
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			 }
			
			else if (utilisateurManager.retournerUtilisateur(mail) != null)
			{
				request.setAttribute("mailBDD", "Cet e-mail existe déjà, veuillez vous connecter.");
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			else if (utilisateurManager.retournerUtilisateur(telephone) != null)
			{
				request.setAttribute("telephoneBDD", "Ce numéro existe déjà");
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			// METHODE POUR INSCRIPTION + REDIRECTION VERS PAGE ACCUEIL
			else {
			utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone, rue, codePostal, ville);
			utilisateur = utilisateurManager.retournerUtilisateur(pseudo);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
} 
}



		
	