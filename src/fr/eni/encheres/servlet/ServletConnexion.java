package fr.eni.encheres.servlet;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
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
 * Servlet implementation class servletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pour récupérer les infos depuis la BDD
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motdepasse");
		RequestDispatcher rd=null;

	
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		String motPasseBDD=utilisateur.getMotDePasse();
		if (motDePasse.equals(motPasseBDD)) {
			rd= request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
		} else {
			 rd = request.getRequestDispatcher("/WEB-INF/erreurAuthentification.jsp");
				rd.forward(request, response);


		}
		
//		RequestDispatcher rd=null;
////pseudo et mot de passe correspondent-ils au pseudo mot de passe en BDD ?
//		try {
//			if (identifiant.equals(utilisateurManager.retournerUtilisateur(identifiant))
//					&& motDePasse.equals(utilisateurManager.retournerUtilisateur(motDePasse))) {
////				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
////	rd.forward(request, response);
//				rd= request.getRequestDispatcher("/WEB-INF/accueil.jsp");
//				// TODO::: ajouter la liste des articles et enchères en mode détails et
//				// cliquables
//			}
//		} catch (BusinessException ex) {
//			ex.printStackTrace();
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodeErreursServlet.ERREUR_AUTHENTIFICATION);
//			request.setAttribute("erreur",ex.getListeErreurs());
////			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Test scunauthorized");
//
//
//			 rd = request.getRequestDispatcher("/WEB-INF/erreurAuthentification.jsp");
////			rd.forward(request, response);
//
//		}
//		rd.forward(request, response);

//doGet(request, response);
	}

}