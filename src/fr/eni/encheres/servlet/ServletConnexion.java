package fr.eni.encheres.servlet;

import java.io.IOException;

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
	public static final String CONNEXION = "/WEB-INF/connexion.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pour récupérer les infos depuis la BDD
		this.getServletContext().getRequestDispatcher(CONNEXION).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Méthode OK :)
		String identifiant = request.getParameter("identifiant");		
		String motDePasse = request.getParameter("motdepasse");
        RequestDispatcher rd = null;

        UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur = null;
        try {
            utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
            String motPasseBDD = utilisateur.getMotDePasse();
            if (motDePasse.equals(motPasseBDD)) {
                rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("/WEB-INF/erreurAuthentification.jsp");
                rd.forward(request, response);
        } }
            catch (BusinessException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }

       

        }
        

	}

