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

	private static final String ALPHANUMERIQUE = "^[A-Za-z0-9]";
	private static final String CARACTERES_AUTORISES_MAIL = "^[A-Za-z0-9._@-]"; // le - doit être à la fin ou au début de l'expression régulière
	private static final String ALPHA = "^[A-Za-z]";
	private static final String NUMERIQUE = "^[0-9]";

	Map<String, String> listeErreurs = new HashMap<String, String>();


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
			if (utilisateurManager.retournerUtilisateur(pseudo) != null)
			 {
				listeErreurs.put("pseudoBDD", "Ce pseudo existe déjà");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			 }
			
			// Mail
			else if (utilisateurManager.retournerUtilisateur(mail) != null)
			{
				listeErreurs.put("mailBDD", "Cet email existe déjà, veuillez vous connecter.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			// Téléphone
			else if (utilisateurManager.retournerUtilisateur(telephone) != null)
			{
				listeErreurs.put("telephoneBDD", "Ce numéro existe déjà");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			
// VERIFS AUTRES, EFFECTUEES DANS CODE HTML DE LA JSP sinscrire.jsp
			
		/*	else if (pseudo == null || pseudo.trim().length() < 3 || pseudo.trim().length() > 30 || !pseudo.matches(ALPHANUMERIQUE))
			{
				listeErreurs.put("pseudo", "Le pseudo doit contenir entre 3 et 30 chiffres et lettres");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}*/

				
					
		/*	else if (mail == null || mail.trim().length() > 50 || !mail.matches(CARACTERES_AUTORISES_MAIL))

			{
				listeErreurs.put("mail", "Votre email est incorrect, veuillez le ressaisir.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}*/
			
		/*	else if (telephone == null || telephone.trim().length() > 15 || !telephone.matches(NUMERIQUE))
			{
				listeErreurs.put("telephone", "Le numéro de téléphone est incorrect, veuillez le ressaisir.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}*/
			
			
			// A REVOIR POUR FAIRE L INVERSE PEUT ETRE
		/*	else if (mdp == null || !mdp.equals(confirmMdp) || mdp.trim().length() < 7 || !mdp.matches(ALPHANUMERIQUE))
				// if (mdp != null && mdp.equals(confirmMdp) && mdp.trim().length() > 7 && mdp.matches(ALPHANUMERIQUE)) 
			{
				listeErreurs.put("motdepasse", "Le mot de passe et la confirmation sont différents.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}*/
			
		/*	else if (nom == null || nom.trim().length() < 2 || nom.trim().length() > 30 || !nom.matches(ALPHANUMERIQUE))
			{
				listeErreurs.put("nom", "Votre nom doit contenir entre 2 et 30 lettres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			else if (prenom == null || prenom.trim().length() < 2 || prenom.trim().length() > 30 || !prenom.matches(ALPHA))
			{
				listeErreurs.put("prenom", "Votre prénom doit contenir entre 2 et 30 lettres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}*/
			
			/*else if (rue == null || rue.trim().length() > 30 || !rue.matches(ALPHANUMERIQUE))
			{
				listeErreurs.put("rue", "la rue doit contenir entre 2 et 30 lettres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			else if (codePostal == null || codePostal.trim().length() != 5 || !codePostal.matches(NUMERIQUE))
			{
				listeErreurs.put("codePostal", "le code postal doit contenir 5 chiffres.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
			else if (ville == null || ville.trim().length() > 50 || !ville.matches(ALPHA))
			{
				listeErreurs.put("ville", "La ville doit contenir moins de 50 caractères.");
				request.setAttribute("listeErreurs", listeErreurs);
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}*/
			
			else 
			{
				Utilisateur utilisateur;
			
					utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone, rue, codePostal, ville);
					utilisateur = utilisateurManager.retournerUtilisateur(pseudo);
					HttpSession session = request.getSession();
					session.setAttribute("user", utilisateur);
					session.setAttribute("userTest", utilisateur);
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
