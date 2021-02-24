package fr.eni.encheres.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletVendreArticle
 */
@WebServlet("/ServletVendreArticle")
public class ServletVendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String NEWVENTE="/WEB-INF/vendreArticle.jsp";
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(NEWVENTE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		Date dateDebutEnchere = new SimpleDateFormat("yyyy-MM-dd").parse(getInitParameter("dateDebutEnchere"));
		Date dateFinEnchere = new SimpleDateFormat("yyyy-MM-dd").parse(getInitParameter("dateFinEnchere"));
		String misAPrix = request.getParameter("miseAPrix");
		int miseAPrix= Integer.parseInt(misAPrix);
		String prixDepart = request.getParameter("prixVente");
		int prixVente= Integer.parseInt(prixDepart);
		Utilisateur noUtilisateur = Utilisateur.parseInt("noUtilisateur");
		Categorie noCategorie = Categorie.parseInt("noCategorie");
		

		
		/** String DATE a Convertir au format DATE ou LocalDate ligne 42 et 43.
		 * Modifier ensuite paramètre méthode ajoutArticleVendu ligne 58 **/
		
		RequestDispatcher rd = null;
		
		ArticleManager articleManager = new ArticleManager();
		
		ArticleVendu articleVendu= ArticleManager.ajoutArticleVendu(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, prixVente, noUtilisateur, noCategorie);
	 

		rd.forward(request, response);
		
	}

}
