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

	public static final String MDP = "mdp";
	public static final String PSEUDO = "pseudo";
	public static final String CONFIRM_MDP = "confirmMdp";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String MAIL = "mail";
	public static final String TELEPHONE = "telephone";
	public static final String RUE = "rue";
	public static final String CODE_POSTAL = "codePostal";
	public static final String CITY = "city";
	public static final String SINSCRIRE = "/WEB-INF/sinscrire.jsp";

	private static final String ALPHANUMERIQUE = "^[A-Za-z0-9]";
	private static final String CARACTERES_AUTORISES_MAIL = "^[A-Za-z0-9._@-]"; // le - doit être à la fin ou au début
	private static final String ALPHA = "^[A-Za-z]";
	private static final String NUMERIQUE = "^[0-9]";

	HashMap<String, String> listeErreurs = new HashMap<String, String>();
// de
	// l'expression régulière

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(SINSCRIRE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		String confirmMdp = request.getParameter("confirmMdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String city = request.getParameter("city");

		RequestDispatcher rd = null;
		// J'ajoute l'utilisateur
		try {
			validationPseudoBDD(pseudo);
		} catch (Exception e) {
			listeErreurs.put("pseudoBDD", "Ce pseudo existe déjà");
		}
		try {
			validationPseudo(pseudo);
		} catch (Exception e) {
			listeErreurs.put("pseudo", "Le pseudo doit contenir entre 3 et 30 chiffres et lettres");
		}
		try {
			validationEmailBDD(mail);
		} catch (Exception e) {
			listeErreurs.put("mailBDD", "Cet email existe déjà, veuillez vous connecter.");
		}
		try {
			validationEmail(mail);
		} catch (Exception e) {
			listeErreurs.put("mail", "Votre email est incorrect, veuillez le ressaisir.");
		}
		try {
			validationTelephoneBDD(telephone);
		} catch (Exception e) {
			listeErreurs.put("telephoneBDD", "Ce numéro existe déjà");
		}
		try {
			validationTelephone(telephone);
		} catch (Exception e) {
			listeErreurs.put("telephone", "Le numéro de téléphone est incorrect, veuillez le ressaisir.");
		}
		try {
			validationMDP(mdp, confirmMdp);
		} catch (Exception e) {
			listeErreurs.put("motdepasse", "Le mot de passe et la confirmation sont différents.");
		}
		try {
			validationNom(nom);
		} catch (Exception e) {
			listeErreurs.put("nom", "Votre nom doit contenir entre 2 et 30 lettres.");
		}
		try {
			validationPrenom(prenom);
		} catch (Exception e) {
			listeErreurs.put("prenom", "Votre prénom doit contenir entre 2 et 30 lettres.");
		}
		try {
			validationRue(rue);
		} catch (Exception e) {
			listeErreurs.put("rue", "la rue doit contenir entre 2 et 30 lettres.");
		}
		try {
			validationCodePostal(codePostal);
		} catch (Exception e) {
			listeErreurs.put("codePostal", "le code postal doit contenir 5 chiffres.");
		}
		try {
			validationVille(city);
		} catch (Exception e) {
			listeErreurs.put("ville", "La ville doit contenir moins de 50 caractères.");
		}
		if (listeErreurs.isEmpty()) {

			Utilisateur utilisateur;
			try {
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone, rue,
						codePostal, city);
				utilisateur = utilisateurManager.retournerUtilisateur(pseudo);
				HttpSession session = request.getSession();
				session.setAttribute("user", utilisateur);
				session.setAttribute("userTest", utilisateur);
				session.setAttribute("utilisateur", utilisateur);
				rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
				utilisateur = utilisateurManager.retournerUtilisateur(pseudo);

			} catch (BusinessException e) {

				e.printStackTrace();

			}

		} else {
			request.setAttribute("listeErreurs", listeErreurs);
			rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);

		}
	}

//Méthodes de vérification
	private void validationPseudoBDD(String pseudo) throws Exception {
		List<String> listePseudoBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listePseudoBDD.add(utilisateur.getPseudo());
		}
		if (listePseudoBDD.contains(pseudo)) {
			throw new Exception();

		}
	}

	private void validationPseudo(String pseudo) throws Exception {
		if (pseudo == null) {
			throw new Exception();
		}
		if (pseudo.trim().length() <3) {
			throw new Exception();

		}
		if (pseudo.trim().length() > 30) {
			throw new Exception();

		}
		if (!pseudo.matches(ALPHANUMERIQUE)) {
			throw new Exception();

		}
	}

//Vérifie si le mail est présent en BDD
	private void validationEmailBDD(String mail) throws Exception {
		List<String> listeMailBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeMailBDD.add(utilisateur.getEmail());
		}
		if (listeMailBDD.contains(mail)) {
			throw new Exception();
		}
	}

	private void validationEmail(String mail) throws Exception {
		if (mail != null && mail.trim().length() > 0 && mail.trim().length() < 50
				&& mail.matches(CARACTERES_AUTORISES_MAIL)) {
		} else
			throw new Exception();
	}

	private void validationMDP(String mdp, String confirmMdp) throws Exception {
		if (mdp != null && mdp.equals(confirmMdp) && mdp.trim().length() > 7 && mdp.matches(ALPHANUMERIQUE)) {

		} else
			throw new Exception();
	}

	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() > 2 && nom.trim().length() < 30 && nom.matches(ALPHANUMERIQUE)) {

		} else
			throw new Exception();
	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom != null && prenom.trim().length() > 2 && prenom.trim().length() < 30 && prenom.matches(ALPHA)) {

		} else
			throw new Exception();
	}

	private void validationTelephoneBDD(String telephone) throws Exception {
		List<String> listeTelephoneBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeTelephoneBDD.add(utilisateur.getEmail());
		}
		if (listeTelephoneBDD.contains(telephone)) {
			throw new Exception();
		}
	}

	private void validationTelephone(String telephone) throws Exception {
		if (telephone != null && telephone.trim().length() > 0 && telephone.trim().length() < 15
				&& telephone.matches(NUMERIQUE)) {

		} else
			throw new Exception();
	}

	private void validationRue(String rue) throws Exception {
		if (rue != null && rue.trim().length() > 0 && rue.trim().length() < 30 && rue.matches(ALPHANUMERIQUE)) {
		} else
			throw new Exception();
	}

	private void validationCodePostal(String codePostal) throws Exception {
		if (codePostal != null && codePostal.trim().length() > 0 && codePostal.trim().length() == 5
				&& codePostal.matches(NUMERIQUE)) {

		} else
			throw new Exception();
	}

	private void validationVille(String ville) throws Exception {
		if (ville != null && ville.trim().length() > 0 && ville.trim().length() < 50 && ville.matches(ALPHA)) {

		} else
			throw new Exception();
	}
}