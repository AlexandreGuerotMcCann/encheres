package fr.eni.encheres.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletVendreArticle
 */
@WebServlet("/ServletVendreArticle")
public class ServletVendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String NEWVENTE = "/WEB-INF/vendreArticle.jsp";
	public static final String MESVENTES = "/WEB-INF/mesVentes.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(NEWVENTE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			Date dateDebutEnchere = new SimpleDateFormat("dd-MM-yyyy").parse(getInitParameter("dateDebutEnchere"));
			Date dateFinEnchere = new SimpleDateFormat("dd-MM-yyyy").parse(getInitParameter("dateFinEnchere"));
			String misAPrix = request.getParameter("miseAPrix");
			int miseAPrix = Integer.parseInt(misAPrix);
			String prixDepart = request.getParameter("prixVente");
			int prixVente = Integer.parseInt(prixDepart);
			Utilisateur noUtilisateur = Utilisateur.parseInt("noUtilisateur");
			Categorie noCategorie = Categorie.parseInt("noCategorie");

			ArticleManager articleManager = new ArticleManager();

			ArticleVendu articleVendu = articleManager.ajoutArticleVendu(nomArticle, description, dateDebutEnchere,
					dateFinEnchere, miseAPrix, prixVente, noUtilisateur, noCategorie);
			RequestDispatcher rd = null;
			this.getServletContext().getRequestDispatcher(MESVENTES).forward(request, response);
			rd.forward(request, response);
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		
		
	}

}
