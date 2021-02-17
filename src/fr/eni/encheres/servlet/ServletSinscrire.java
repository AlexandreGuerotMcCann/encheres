package fr.eni.encheres.servlet;

import java.io.IOException;
import bo.Utilisateur;
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
	
	
	
	private static final String mdp="mdp";
	private static final String pseudo ="pseudo";
	private static final String confirmMdp="confirmMdp";
	private static final String nom ="nom";
	private static final String prenom="prenom";
	private static final String mail="mail";
	private static final String telephone="telephone";
	private static final String rue="rue";
	private static final String codePostal="codePostal";
	private static final String city="city";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
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
            validationEmail( mail );
            validationMotsDePasse( mdp, confirmMdp );
            validationNom( nom );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
	}


	} 


			private void validationEmail( String mail ) throws Exception{
				 if ( mail != null && mail.trim().length() != 0 ) {
				        if ( mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				            throw new Exception( "Merci de saisir une adresse mail valide." );
				        }
				    } else {
				        throw new Exception( "Merci de saisir une adresse mail." );
				    }
				
			}
			private void validationMotsDePasse( String mdp, String confirmMdp) throws Exception{
				 if (mdp != null && mdp.trim().length() != 0 && confirmMdp != null && confirmMdp.trim().length() != 0) {
				        if (mdp.equals(confirmMdp)) {
				            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
				        } else if (mdp.trim().length() < 3) {
				            throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
				        }
				    } else {
				        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
				    }
				
				
			}
			
			
			
			private void validationNom( String nom ) throws Exception
			
			{
				
				if ( nom != null && nom.trim().length() < 3 ) {
			        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
			    }
			}
}




