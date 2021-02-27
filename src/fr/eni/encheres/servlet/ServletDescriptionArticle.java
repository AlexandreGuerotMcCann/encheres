package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletDescriptionArticle
 */
@WebServlet("/ServletDescriptionArticle")
public class ServletDescriptionArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomArticle=request.getParameter("nom");
		ArticleManager articleManager=new ArticleManager();
		UtilisateurManager utilisateurManager=new UtilisateurManager();
		CategorieManager categorieManager=new CategorieManager();
		RetraitManager retraitManager=new RetraitManager();
		ArticleVendu articleAVendre= new ArticleVendu();
		Utilisateur vendeur=new Utilisateur();
		Categorie categorie= new Categorie();
		Retrait retrait=new Retrait();
		RequestDispatcher rd = null;

		try {
			
			articleAVendre=articleManager.retournerArticle(nomArticle);
			int noVendeur = articleAVendre.getNoUtilisateur();
			int noCategorie= articleAVendre.getNoCategorie();
			int noArticle=articleAVendre.getNoArticle();
			articleAVendre.setPseudo(vendeur.getPseudo());
			articleAVendre.setUtilisateur(vendeur);
			articleAVendre.setCategorie(categorie);
			vendeur=utilisateurManager.retournerUtilisateurParId(noVendeur);
			categorie=categorieManager.retournerCategorieParNoCategorie(noCategorie);
			retrait=retraitManager.retournerRetrait(noArticle);

			request.setAttribute("retrait", retrait);
			request.setAttribute("categorie", categorie);
			request.setAttribute("article", articleAVendre);
			request.setAttribute("vendeur", vendeur);

			rd = request.getRequestDispatcher("/WEB-INF/descriptionVente.jsp");
			rd.forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
