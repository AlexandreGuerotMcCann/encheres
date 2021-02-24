package fr.eni.encheres.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	private static final String ALPHANUMERIQUE = "^[A-Za-z0-9]";
	private static final String CARACTERES_AUTORISES_MAIL = "^[A-Za-z0-9._@-]"; // le - doit être à la fin ou au début de l'expression régulière
	private static final String ALPHA = "^[A-Za-z]";
	private static final String NUMERIQUE = "^[0-9]";

	HashMap<String, String> listeErreurs = new HashMap<String, String>();


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
		
		int erreur = 0;
		
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
	
		
// VERIFS EN RAPPORT AVEC BDD (contrainte unicité)
		
		//Pseudo
		try {
			if (utilisateurManager.retournerUtilisateur(pseudo) == null)
			 {
				erreur ++;
				listeErreurs.put("pseudoBDD", "Ce pseudo existe déjà");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			 }
			
			// Mail
			if (utilisateurManager.retournerUtilisateur(mail) == null)
			{
				erreur ++;
				listeErreurs.put("mailBDD", "Cet email existe déjà, veuillez vous connecter.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			// Téléphone
			if (utilisateurManager.retournerUtilisateur(telephone) == null)
			{
				erreur ++;
				listeErreurs.put("telephoneBDD", "Ce numéro existe déjà");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			
// VERIFS AUTRES
			
		if (pseudo == null || pseudo.trim().length() < 3 || pseudo.trim().length() > 30 || !pseudo.matches(ALPHANUMERIQUE))
			{
				erreur ++;
				listeErreurs.put("pseudo", "Le pseudo doit contenir entre 3 et 30 chiffres et lettres");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
					
			if (mail == null || mail.trim().length() > 50 || !mail.matches(CARACTERES_AUTORISES_MAIL))
			{
				erreur ++;
				listeErreurs.put("mail", "Votre email est incorrect, veuillez le ressaisir.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (telephone == null || telephone.trim().length() > 15 || !telephone.matches(NUMERIQUE))
			{
				erreur ++;
				listeErreurs.put("telephone", "Le numéro de téléphone est incorrect, veuillez le ressaisir.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			
			// A REVOIR POUR FAIRE L INVERSE PEUT ETRE
			if (mdp == null || !mdp.equals(confirmMdp) || mdp.trim().length() < 7 || !mdp.matches(ALPHANUMERIQUE))
				// if (mdp != null && mdp.equals(confirmMdp) && mdp.trim().length() > 7 && mdp.matches(ALPHANUMERIQUE)) 
			{
				erreur ++;
				listeErreurs.put("motdepasse", "Le mot de passe et la confirmation sont différents.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (nom == null || nom.trim().length() < 2 || nom.trim().length() > 30 || !nom.matches(ALPHANUMERIQUE))
			{
				erreur ++;
				listeErreurs.put("nom", "Votre nom doit contenir entre 2 et 30 lettres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (prenom == null || prenom.trim().length() < 2 || prenom.trim().length() > 30 || !prenom.matches(ALPHA))
			{
				erreur ++;
				listeErreurs.put("prenom", "Votre prénom doit contenir entre 2 et 30 lettres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (rue == null || rue.trim().length() > 30 || !rue.matches(ALPHANUMERIQUE))
			{
				erreur ++;
				listeErreurs.put("rue", "la rue doit contenir entre 2 et 30 lettres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (codePostal == null || codePostal.trim().length() != 5 || !codePostal.matches(NUMERIQUE))
			{
				erreur ++;
				listeErreurs.put("codePostal", "le code postal doit contenir 5 chiffres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			if (ville == null || ville.trim().length() > 50 || !ville.matches(ALPHA))
			{
				erreur ++;
				listeErreurs.put("ville", "La ville doit contenir moins de 50 caractères.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			else if (erreur == 0)
			{
				Utilisateur utilisateur;
			
					utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone, rue, codePostal, ville);
					utilisateur = utilisateurManager.retournerUtilisateur(pseudo);
					HttpSession session = request.getSession();
					//session.setAttribute("user", utilisateur);
					//session.setAttribute("userTest", utilisateur);
					session.setAttribute("utilisateur", utilisateur);
					rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
					rd.forward(request, response);
			} 
			
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
