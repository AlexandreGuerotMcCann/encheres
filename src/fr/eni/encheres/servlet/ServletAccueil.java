package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ACCUEIL = "/WEB-INF/accueil.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		ArticleManager articleManager = new ArticleManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur vendeur= new Utilisateur();
		List<ArticleVendu> listeArticlesVendus = new ArrayList<ArticleVendu>();
		HttpSession session = request.getSession();
		try {
			listeArticlesVendus = articleManager.listeArticles();
			for (ArticleVendu articleVendu : listeArticlesVendus) {
				int noVendeur = articleVendu.getNoUtilisateur();
		vendeur=utilisateurManager.retournerUtilisateurParId(noVendeur);
						articleVendu.setPseudo(vendeur.getPseudo());
	
			}
			session.setAttribute("vendeur", vendeur);
			session.setAttribute("listeArticlesVendus", listeArticlesVendus);
			rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);

		} catch (BusinessException e) {
			rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");

			e.printStackTrace();
		}
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		String pseudo = "pseudo";
		request.setAttribute("pseudo", pseudo);
		pseudo = (String) session.getAttribute("pseudo");
		String motdepasse = "motdepasse";
		request.setAttribute("motdepasse", motdepasse);
		pseudo = (String) session.getAttribute("pseudo");

		this.getServletContext().getRequestDispatcher(ACCUEIL).forward(request, response);

	}

}
