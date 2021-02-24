package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/ServletModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String MODIFIER_PROFIL = "/WEB-INF/modifierProfil.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(MODIFIER_PROFIL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("pseudo");

		RequestDispatcher rd = null;

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		HttpSession session = request.getSession();

		// On va chercher méthode de la BLL qui descend jusqu'à la BDD
		// Types doivent être cohérents !
		if (request.getParameter("supprimer") != null)
			try {

				utilisateurManager.suppressionUtilisateur(identifiant);
				// On déconnecte la session
				session.invalidate();

				// Redirection vers accueil en mode déconnecté
				rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (request.getParameter("modifier") != null) {
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String telephone = request.getParameter("telephone");
			String codePostal = request.getParameter("codePostal");
			String rue = request.getParameter("rue");
			String ville = request.getParameter("ville");
			String motdepasse = request.getParameter("motdepasse");
			String nouveau_motdepasse = request.getParameter("nouveau_motdepasse");
			String confirmation_mdp = request.getParameter("confirmation_mdp");
			String email = request.getParameter("email");
			try {
				utilisateur=utilisateurManager.retournerUtilisateur(identifiant);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
