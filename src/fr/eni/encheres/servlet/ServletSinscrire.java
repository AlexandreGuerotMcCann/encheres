package fr.eni.encheres.servlet;

import java.io.IOException;
import fr.eni.encheres.bll.UtilisateurManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSinscrire
 */
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	public static final String mdp="mdp";
	public static final String pseudo ="pseudo";
	public static final String confirmMdp="confirmMdp";
	public static final String nom ="nom";
	public static final String prenom="prenom";
	public static final String mail="mail";
	public static final String telephone="telephone";
	public static final String rue="rue";
	public static final String codePostal="codePostal";
	public static final String city="city";
	public static final String ihm="/WEB-INF/sinscrire.jsp";
	

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(ihm).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
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
		
		
		try {
            validationMotsDePasse( mdp, confirmMdp );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
	}
	} 

			private void validationMotsDePasse( String mdp, String confirmMdp) throws Exception{
				 if (mdp != null && mdp.length() >7 && mdp.equals(confirmMdp)) {
				            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
				        } else if (mdp.length() < 8) {
				            throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
				        }
				        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
				        
			}
			}
				
		




