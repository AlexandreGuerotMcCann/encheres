package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
	public static final String IHM = "/WEB-INF/sinscrire.jsp";

	private static final String ALPHANUMERIQUE = "^[A-Za-z0-9]";
	private static final String CARACTERES_AUTORISES_MAIL = "^[A-Za-z0-9._@-]"; // le - doit être à la fin ou au début de
																			// l'expression régulière

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(IHM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String mdp = request.getParameter("mdp");
		String pseudo = request.getParameter("pseudo");
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
//			
			if (validationEmailBDD(mail)==true) {
				request.setAttribute("mail", "Cet email est déjà associé à un compte");
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			else if (validationEmail(mail)==false){
					request.setAttribute("mail", "Cet email est invalide");
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);;

			}
			
//			validationMDP();
//			validationNom();
			Utilisateur utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone,
					rue, codePostal, city);

			// Si tout se passe bien, je vais vers la page d'accueil
			rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

			// Sinon je retourne à la page s'inscrire et j'indique les problèmes:

			rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
		}

	}

//	private void validationNom() {
//		private void validationNom( String nom ) throws Exception {
//		    if ( nom != null && nom.trim().length() < 3 ) {
//		        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
//		    }		
//	}
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
		  if ( mail != null && mail.trim().length() > 0 && mail.matches( CARACTERES_AUTORISES_MAIL) ) {
		           return true;}
		  else return false;
	}
	

}
