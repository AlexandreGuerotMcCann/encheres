package fr.eni.encheres.servlet;

import java.io.IOException;
import java.text.Format;
import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletEncheres    
 */
@WebServlet("/ServletEncheres")
public class ServletEncheres extends HttpServlet {
	
	/**Ici il ne veut pas prendre de Int ni de DATE, seulement des String, à vérifier ! **/
	
	private static final long serialVersionUID = 1L;
	public static final String ENCHERES="/WEB-INF/encheres.jsp";
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ENCHERES).forward( request, response );
	}      

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n_enchere= request.getParameter("no_enchere");
		int no_enchere= Integer.parseInt(n_enchere);
		String date_enchere = request.getParameter("date_enchere");
		Date date = Date.parse(date_enchere);
		String montantEnchere = request.getParameter("montant_enchere");
		int montant_enchere  = Integer.parseInt(montantEnchere);
		String article = request.getParameter("no_article");
		int no_article = Integer.parseInt(article);
		String utilisateur = request.getParameter("no_utilisateur");
		int no_utilisateur = Integer.parseInt(utilisateur);
		
		
		RequestDispatcher rd = null;
		
		EncheresManager encheresManager = new EncheresManager();
		
		/**Probleme ici avec la conversion de la date ligne 48. Pour le moment on ne peut pas remplacer "date_enchere" par "date" 
		 * dans les param de la méthode "ajoutEnchere() ligne 65 **/
		

		Enchere enchere= EncheresManager.ajoutEnchere(no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur);
		enchere = encheresManager.retournerEnchere(no_enchere);
		HttpSession session = request.getSession();
		session.setAttribute("enchere", enchere);
		rd.forward(request, response);

}}
