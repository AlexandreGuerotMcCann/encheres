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
 * Servlet implementation class ServletMonProfil
 */
@WebServlet("/ServletAfficherProfilVendeur")
public class ServletAfficherProfilVendeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PROFIL="/WEB-INF/monProfil.jsp";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudoVendeur=request.getParameter("nom");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		RequestDispatcher rd = null;

		Utilisateur vendeur=new Utilisateur();
	try {
		vendeur= utilisateurManager.retournerUtilisateur(pseudoVendeur);
		request.setAttribute("vendeur", vendeur);
		rd = request.getRequestDispatcher("/WEB-INF/profilVendeur.jsp");
		rd.forward(request, response);
		
	} catch (BusinessException e) {
		e.printStackTrace();
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudoVendeur=request.getParameter("nom");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		RequestDispatcher rd = null;

		Utilisateur vendeur=new Utilisateur();
	try {
		vendeur= utilisateurManager.retournerUtilisateur(pseudoVendeur);
		request.setAttribute("vendeur", vendeur);
		rd = request.getRequestDispatcher("/WEB-INF/profilVendeur.jsp");
		rd.forward(request, response);
		
	} catch (BusinessException e) {
		e.printStackTrace();
	}
	

	}
}
