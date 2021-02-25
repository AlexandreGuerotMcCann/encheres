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
	private static final String ALPHANUMERIQUE = "^[A-Za-z0-9]";
	private static final String CARACTERES_AUTORISES_MAIL = "^[A-Za-z0-9._@-]"; // le - doit être à la fin ou au début
																				// de l'expression régulière
	private static final String ALPHA = "^[A-Za-z]";
	private static final String NUMERIQUE = "^[0-9]";
	HashMap<String, String> listeErreurs = new HashMap<String, String>();

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
			String mail = request.getParameter("email");
			String motDePasseUpdate = null;
			try {
				utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
				String motdePasseBDD = utilisateur.getMotDePasse();
				validationMotDePasseBDD(motdepasse, motdePasseBDD);
				validationMDP(nouveau_motdepasse, confirmation_mdp);
				if (validationMDP(nouveau_motdepasse, confirmation_mdp) == true) {
					motDePasseUpdate = nouveau_motdepasse;

				} else {
					motDePasseUpdate = motdepasse;

				}
				validationTelBDD(telephone);
				validationMailBDD(mail);
				listeErreurs.remove("null"); // retire les lignes sans erreurs.

				if (listeErreurs.isEmpty()) {
					utilisateur.setPseudo(identifiant);
					utilisateur.setNom(nom);
					utilisateur.setPrenom(prenom);
					utilisateur.setEmail(mail);
					utilisateur.setTelephone(telephone);
					utilisateur.setCodePostal(codePostal);
					utilisateur.setRue(rue);
					utilisateur.setVille(ville);
					utilisateur.setMotDePasse(motDePasseUpdate);
					utilisateurManager.modificationUtilisateur(utilisateur);

				} else {
					request.setAttribute("listeErreurs", listeErreurs);
					rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	private void validationMailBDD(String mail) throws Exception {
		List<String> listeMailBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeMailBDD.add(utilisateur.getEmail());
		}
		if (listeMailBDD.contains(mail)) {
			listeErreurs.put("mail", "Cet email est déjà présent en BDD.");
		} else
			listeErreurs.put("null", "");
	}

	private void validationTelBDD(String telephone) throws Exception {
		List<String> listeMailTel = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeMailTel.add(utilisateur.getEmail());
		}
		if (listeMailTel.contains(telephone)) {
			listeErreurs.put("telBDD", "Ce numéro existe déjà.");
		} else
			listeErreurs.put("null", "");
	}

	private void validationMotDePasseBDD(String motdepasse, String motdePasseBDD) {
		if (motdepasse.equals(motdePasseBDD)) {
			listeErreurs.put("null", "");
		} else
			listeErreurs.put("mdpBDD", "Le mot de passe actuel est incorrect.");
	}

	private boolean validationMDP(String nouveau_motdepasse, String confirmMdp) {
		if (nouveau_motdepasse.equals(confirmMdp)) {
			listeErreurs.put("null", "");
			return true;
		} else
			listeErreurs.put("mdp", "Les mots de passe de correspondent pas.");
		return false;
	}
}
