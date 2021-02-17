package fr.eni.encheres.servlet;

import java.io.IOException;
import java.security.interfaces.RSAKey;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		UtilisateurManager utilisateurManager = new UtilisateurManager();

		try {
			if (identifiant.equals(utilisateurManager.retournerUtilisateur(identifiant))&&motDePasse.equals(utilisateurManager.retournerUtilisateur(motDePasse))) {

			}
		} catch (BusinessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

//doGet(request, response);
	}

}