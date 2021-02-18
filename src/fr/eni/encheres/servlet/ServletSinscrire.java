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

	public static final String MDP="mdp";
	public static final String PSEUDO ="pseudo";
	public static final String CONFIRM_MDP="confirmMdp";
	public static final String NOM ="nom";
	public static final String PRENOM="prenom";
	public static final String MAIL="mail";
	public static final String TELEPHONE="telephone";
	public static final String RUE="rue";
	public static final String CODE_POSTAL="codePostal";
	public static final String CITY="city";
	public static final String IHM="/WEB-INF/sinscrire.jsp";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(IHM).forward( request, response );	
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
		
		//J'ajoute l'utilisateur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try { validationMotsDePasse( mdp, confirmMdp );
			utilisateurManager.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail, telephone, rue, codePostal, city);
			//Si tout se passe bien, je vais vers la page d'accueil
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			
			//Sinon je retourne à la page s'inscrire et j'indique les problèmes:
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
			rd.forward(request, response);
		}		
	
	} 
			private void validationMotsDePasse( String mdp, String confirmMdp) throws Exception {
				 if (mdp != null && mdp.length() > 7 && mdp.equals(confirmMdp)) {
				        
				            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
				        } else if (mdp.length() < 8) {
				            throw new Exception("Les mots de passe doivent contenir au moins 8 caractères.");
				        }
				     else {
				        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
				        }
			}
			}
				
		




