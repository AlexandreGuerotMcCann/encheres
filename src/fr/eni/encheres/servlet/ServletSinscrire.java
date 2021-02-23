package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSinscrire
 ***/
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String MDP = "mdp";
	public static final String PSEUDO = "pseudo";
	public static final String CONFIRM_MDP = "confirmMdp";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String MAIL = "mail";
	public static final String TELEPHONE = "telephone";
	public static final String RUE = "rue";
	public static final String CODE_POSTAL = "codePostal";
	public static final String CITY = "city";
	public static final String SINSCRIRE = "/WEB-INF/sinscrire.jsp";
										

	private static final String ALPHANUMERIQUE = "^[A-Za-z0-9]";
	private static final String CARACTERES_AUTORISES_MAIL = "^[A-Za-z0-9._@-]"; // le - doit être à la fin ou au début
																				// de
	// l'expression régulière

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(SINSCRIRE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		String confirmMdp = request.getParameter("confirmMdp");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String city = request.getParameter("city");

		RequestDispatcher rd = null;
		// J'ajoute l'utilisateur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			if (validationPseudoBDD(pseudo) == false) {

//					if (validationEmailBDD(mail) == false) {
//
//						if (validationEmail(mail) == true) {
//
//							if (validationTelephoneBDD(telephone) == false) {
//
//								if (validationTelephone(telephone) == true) {
//
//									if (validationMDP(mdp, confirmMdp) == true) {
//
//										if (validationNom(nom) == true) {
//
//											if (validationPrenom(prenom) == true) {
//
//												if (validationRue(rue) == true) {
//
//													if (validationCodePostal(codePostal) == true) {
//
//														if (validationVille(city) == true) {

															Utilisateur utilisateur = utilisateurManager
																	.ajoutUtilisateur(mdp, pseudo, nom, prenom, mail,
																			telephone, rue, codePostal, city);
															utilisateur = utilisateurManager
																	.retournerUtilisateur(pseudo);
															HttpSession session = request.getSession();

//        	clé "user" pour le code java page accueuil
															session.setAttribute("user", utilisateur);
//        	clé "userTest" pour le jsp:useBean page accueuil
															session.setAttribute("userTest", utilisateur);
//        	clé "utilisateur" pour l'expression Language page accueil
															session.setAttribute("utilisateur", utilisateur);
															rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
															rd.forward(request, response);
														}
//													}
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
		}
		catch (Exception e) {
			ArrayList<String>listeErreursInscription = new ArrayList<String>();
		
			e.printStackTrace();
			try {
				if (validationPseudoBDD(pseudo) == true) {
					request.setAttribute("pseudoBDD", "Ce pseudo existe déjà");

					
				}
				if (validationPseudo(pseudo) == false) {
					request.setAttribute("pseudo", "Ce Pseudo est invalide. Il doit contenir moins de 30 caractères et contenir uniquement des lettres et des chiffres");

				}
//				if (validationEmailBDD(mail) == true) {
//					request.setAttribute("Erreur", "Cet email est déjà associé à un compte");
//
//				}
//				if (validationEmail(mail) == false) {
//					request.setAttribute("Erreur", "Cet email est invalide");
//
//				} if (validationTelephoneBDD(telephone) == true) {
//					request.setAttribute("Erreur", "Ce numéro de téléphone est déjà associé à un compte");
//
//				} if (validationEmail(mail) == false) {
//					request.setAttribute("Erreur", "Cet email est invalide");
//
//				} if (validationMDP(mdp, confirmMdp) == false) {
//					request.setAttribute("Erreur",
//							"Les mots de passe ne sont pas identiques (mininimum 8 caractères. Seules les lettres et chiffres sont autorisés.");
//
//				} if (validationNom(nom) == false) {
//					request.setAttribute("Erreur", "Votre nom doit contenir entre 2 et 30 caractères");
//
//				}if (validationPrenom(prenom) == false) {
//					request.setAttribute("Erreur", "Votre prénom doit contenir entre 2 et 30 caractères");
//
//				} if (validationRue(rue) == false) {
//					request.setAttribute("Erreur", "la rue doit contenir moins de 30 caractères");
//
//				}  if (validationCodePostal(codePostal) == false) {
//					request.setAttribute("Erreur", "Le code postal doit contenir moins de 10 caractères");
//
//				}  if (validationVille(city) == false) {
//					request.setAttribute("Erreur", "La ville doit contenir moins de 50 caractères.");
//
//				}
				request.setAttribute("pseudoBDD", "Ce pseudo existe déjà");
				
				
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();// Sinon je retourne à la page s'inscrire et j'indique les problèmes:
				rd = request.getRequestDispatcher("/WEB-INF/sinscrire.jsp");
				rd.forward(request, response);
			}
			
		}

	}

	boolean validationPseudoBDD(String pseudo) throws Exception {
		List<String> listePseudoBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listePseudoBDD.add(utilisateur.getEmail());
		}
		if (listePseudoBDD.contains(pseudo)) {
			return true;
		} else {
			return false;
		}
	}

	boolean validationPseudo(String pseudo) {
		if (pseudo != null && pseudo.trim().length() > 0 && pseudo.trim().length() < 30
				&& pseudo.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

//Vérifie si le mail est présent en BDD
	boolean validationEmailBDD(String mail) throws Exception {
		List<String> listeMailBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeMailBDD.add(utilisateur.getEmail());
		}
		if (listeMailBDD.contains(mail)) {
			return true;
		} else {
			return false;
		}
	}

	boolean validationEmail(String mail) {
		if (mail != null && mail.trim().length() > 0 && mail.trim().length() < 50
				&& mail.matches(CARACTERES_AUTORISES_MAIL)) {
			return true;
		} else
			return false;
	}

	boolean validationMDP(String mdp, String confirmMdp) {
		if (mdp != null && mdp.equals(confirmMdp) && mdp.trim().length() > 7 && mdp.matches(ALPHANUMERIQUE)) {

			return true;
		} else
			return false;
	}

	private boolean validationNom(String nom) {
		if (nom != null && nom.trim().length() > 2 && nom.trim().length() < 30 && nom.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	private boolean validationPrenom(String prenom) {
		if (prenom != null && prenom.trim().length() > 2 && prenom.trim().length() < 30
				&& prenom.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	boolean validationTelephoneBDD(String telephone) throws Exception {
		List<String> listeTelephoneBDD = new ArrayList<String>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		List<Utilisateur> listeUser = utilisateurManager.ListeUtilisateurs();
		for (Utilisateur utilisateur : listeUser) {
			listeTelephoneBDD.add(utilisateur.getEmail());
		}
		if (listeTelephoneBDD.contains(telephone)) {
			return true;
		} else {
			return false;
		}
	}

	boolean validationTelephone(String telephone) {
		if (telephone != null && telephone.trim().length() > 0 && telephone.trim().length() < 15
				&& telephone.matches(CARACTERES_AUTORISES_MAIL)) {
			return true;
		} else
			return false;
	}

	boolean validationRue(String rue) {
		if (rue != null && rue.trim().length() > 0 && rue.trim().length() < 30 && rue.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	boolean validationCodePostal(String codePostal) {
		if (codePostal != null && codePostal.trim().length() > 0 && codePostal.trim().length() < 10
				&& codePostal.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}

	boolean validationVille(String ville) {
		if (ville != null && ville.trim().length() > 0 && ville.trim().length() < 50 && ville.matches(ALPHANUMERIQUE)) {
			return true;
		} else
			return false;
	}
}