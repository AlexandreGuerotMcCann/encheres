package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	boolean modificationMDP = false;

//	HashMap<String, String> listeErreurs = new HashMap<String, String>();
	String erreur;

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
		request.setCharacterEncoding("UTF-8");
		String identifiant = request.getParameter("pseudo");

		RequestDispatcher rd = null;

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		HttpSession session = request.getSession();

		// On va chercher méthode de la BLL qui descend jusqu'à la BDD
		// Types doivent être cohérents !
		if (request.getParameter("supprimer") != null) {
			try {
				utilisateurManager.suppressionUtilisateur(identifiant);
				// On déconnecte la session
				session.invalidate();

				// Redirection vers accueil en mode déconnecté
				rd = request.getRequestDispatcher("ServletAccueil");
				rd.forward(request, response);

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			String mail = request.getParameter("email");
			try {
				if ((nouveau_motdepasse.length()>0& nouveau_motdepasse.length()<8)| (confirmation_mdp.length()>0&confirmation_mdp.length()<8 )) {
					request.setAttribute("erreurMDP", "ERREUR : Le nouveau mot de passe doit avoir entre 8 et 30 caractères.");
					rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
					rd.forward(request, response);
				}
				if (nouveau_motdepasse.length() > 7 ) {
					if (!nouveau_motdepasse.equals(confirmation_mdp)) {
						request.setAttribute("erreurMDP", "ERREUR : Les mots de passe ne correspondent pas.");
						rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
						rd.forward(request, response);
					} else {
						utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
						utilisateur.setPseudo(identifiant);
						utilisateur.setNom(nom);
						utilisateur.setPrenom(prenom);
						utilisateur.setEmail(mail);
						utilisateur.setTelephone(telephone);
						utilisateur.setCodePostal(codePostal);
						utilisateur.setRue(rue);
						utilisateur.setVille(ville);
						utilisateur.setMotDePasse(nouveau_motdepasse);
						utilisateurManager.modificationUtilisateur(utilisateur);
						utilisateur=utilisateurManager.retournerUtilisateur(identifiant);
						session.setAttribute("utilisateur", utilisateur);
						rd = request.getRequestDispatcher("ServletAccueil");
						rd.forward(request, response);
					}
				} else {
					utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
					utilisateur.setPseudo(identifiant);
					utilisateur.setNom(nom);
					utilisateur.setPrenom(prenom);
					utilisateur.setEmail(mail);
					utilisateur.setTelephone(telephone);
					utilisateur.setCodePostal(codePostal);
					utilisateur.setRue(rue);
					utilisateur.setVille(ville);
					utilisateur.setMotDePasse(motdepasse);
					utilisateurManager.modificationUtilisateur(utilisateur);
					utilisateur=utilisateurManager.retournerUtilisateur(identifiant);
					session.setAttribute("utilisateur", utilisateur);

					rd = request.getRequestDispatcher("ServletAccueil");
					rd.forward(request, response);
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}