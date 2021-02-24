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
	private String erreurMessage=null;												// de
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
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			validationPseudoBDD(pseudo);
			validationPseudo(pseudo);
			validationEmailBDD(mail);
			validationEmail(mail);
			validationTelephoneBDD(telephone);
			validationTelephone(telephone);
			validationMDP(mdp, confirmMdp);
			validationNom(nom);
			validationPrenom(prenom);
			validationRue(rue);
			validationCodePostal(codePostal);
			validationVille(city);

				Utilisateur utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone,
						rue, codePostal, city);
				utilisateur = utilisateurManager.retournerUtilisateur(pseudo);
				HttpSession session = request.getSession();
				session.setAttribute("user", utilisateur);
				session.setAttribute("userTest", utilisateur);
				session.setAttribute("utilisateur", utilisateur);
				rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			}	
		catch (Exception e) {
			HashMap<String, String> listeErreurs= new HashMap<String, String>();
			listeErreurs.put("erreur", erreurMessage);
		}}

private	void validationPseudoBDD(String pseudo) throws Exception {
		List<String> listePseudoBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listePseudoBDD.add(utilisateur.getPseudo());
		}
		if (listePseudoBDD.contains(pseudo)) {
		throw new Exception("Ce pseudo existe déjà en BDD");
		
	}}

	boolean validationPseudo(String pseudo) {
		if (pseudo != null && pseudo.trim().length() > 0 && pseudo.trim().length() < 30
				&& pseudo.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

//Vérifie si le mail est présent en BDD
	boolean validationEmailBDD(String mail) throws Exception {
		List<String> listeMailBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeMailBDD.add(utilisateur.getEmail());
		}
		if (listeMailBDD.contains(mail)) {
			return true;
		} else {
			return false;
		}
	}

	boolean validationEmail(String mail) {
		if (mail != null && mail.trim().length() > 0 && mail.trim().length() < 50
				&& mail.matches(CARACTERES_AUTORISES_MAIL)) {
			return true;
		} else
			return false;
	}

	boolean validationMDP(String mdp, String confirmMdp) {
		if (mdp != null && mdp.equals(confirmMdp) && mdp.trim().length() > 7 && mdp.matches(ALPHANUMERIQUE)) {

			return true;
		} else
			return false;
	}

	private boolean validationNom(String nom) {
		if (nom != null && nom.trim().length() > 2 && nom.trim().length() < 30 && nom.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	private boolean validationPrenom(String prenom) {
		if (prenom != null && prenom.trim().length() > 2 && prenom.trim().length() < 30
				&& prenom.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	boolean validationTelephoneBDD(String telephone) throws Exception {
		List<String> listeTelephoneBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeTelephoneBDD.add(utilisateur.getEmail());
		}
		if (listeTelephoneBDD.contains(telephone)) {
			return true;
		} else {
			return false;
		}
	}

	boolean validationTelephone(String telephone) {
		if (telephone != null && telephone.trim().length() > 0 && telephone.trim().length() < 15
				&& telephone.matches(CARACTERES_AUTORISES_MAIL)) {
			return true;
		} else
			return false;
	}

	boolean validationRue(String rue) {
		if (rue != null && rue.trim().length() > 0 && rue.trim().length() < 30 && rue.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	boolean validationCodePostal(String codePostal) {
		if (codePostal != null && codePostal.trim().length() > 0 && codePostal.trim().length() < 10
				&& codePostal.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	boolean validationVille(String ville) {
		if (ville != null && ville.trim().length() > 0 && ville.trim().length() < 50 && ville.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}
}