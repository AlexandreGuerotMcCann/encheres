package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ServletSinscrire
 ***/
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	boolean pseudoEnBDD;
	boolean emailEnBDD;
	boolean telephoneEnBDD;
	
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
		// METHODE VérifMDP OK FONCTIONNE PARFAITEMENT !
		if (!mdp.equals(confirmMdp))
		{
			request.setAttribute("erreur", "ERREUR : Les mots de passe ne correspondent pas.");
			rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
		}
		validationPseudoBDD(pseudo);  
		validationEmailBDD(mail);
		validationTelephoneBDD(telephone);
		// Vérifie si pseudo existe déjà en BDD
		if (pseudoEnBDD==false) 
		{ 
			request.setAttribute("erreur", "ERREUR : Ce pseudo existe déjà.");
			rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
		}
		  
		
		// Vérifie si email existe déjà en BDD
		
		else if (emailEnBDD==true)
		{
			request.setAttribute("erreur", "ERREUR : Cet e-mail existe déjà, veuillez vous connecter.");
			rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
		}

		// Vérifie si téléphone existe déjà en BDD
		
		else if (telephoneEnBDD==true)
		{
			request.setAttribute("erreur", "ERREUR : Ce numéro existe déjà");
			rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
		}
	
		 		 	
		// SINON, si tout est OK : METHODE POUR INSCRIPTION + REDIRECTION VERS PAGE ACCUEIL
		else 
		{	
			utilisateur = utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone, rue, codePostal, ville);
			utilisateur = utilisateurManager.retournerUtilisateur(pseudo);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);

			rd = request.getRequestDispatcher("ServletAccueil");

			rd.forward(request, response);
		}
		
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}

 
private boolean validationPseudoBDD(String pseudo) throws Exception {
	List<String> listePseudoBDD = new ArrayList<String>();
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) 
		{
			listePseudoBDD.add(utilisateur.getPseudo());
		}
		if (listePseudoBDD.contains(pseudo)) {
			pseudoEnBDD = true;
		}
		else {
			pseudoEnBDD = false;
		}
		return pseudoEnBDD;
}

private boolean validationEmailBDD(String mail) throws Exception {
	List<String> listeMailBDD = new ArrayList<String>();
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
	for (Utilisateur utilisateur : listeUser) {
		listeMailBDD.add(utilisateur.getEmail());
	}
	if (listeMailBDD.contains(mail)) {
		emailEnBDD = true;
	}
	else {
	emailEnBDD = false;
	}
	return emailEnBDD;
}

private boolean validationTelephoneBDD(String telephone) throws Exception {
	List<String> listeTelephoneBDD = new ArrayList<String>();
	UtilisateurManager utilisateurManager = new UtilisateurManager();
	List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
	for (Utilisateur utilisateur : listeUser) {
		listeTelephoneBDD.add(utilisateur.getTelephone());
	}
	if (listeTelephoneBDD.contains(telephone)) {
		telephoneEnBDD = true;
	}
	else {
		telephoneEnBDD = false;
		}
	return telephoneEnBDD;	
	}
}

	