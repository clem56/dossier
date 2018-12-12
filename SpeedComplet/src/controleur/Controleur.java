package controleur;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ihm.FenetreHote;
import ihm.Touches;
import jeu.ISpeed;
import jeu.Speed;
import jeu.cartes.carte.CarteVide;
import jeu.cartes.carte.ICarte;

public class Controleur implements KeyListener {

	private static final int ERREUR_FRAPPE = KeyEvent.VK_A;
	private static final int TOUCHE1_J1 = Touches.TOUCHE1_J1;
	private static final int TOUCHE2_J1 = Touches.TOUCHE2_J1;
	private static final int TOUCHE3_J1 = Touches.TOUCHE3_J1;
	private static final int TOUCHE1_J2 = Touches.TOUCHE1_J2;
	private static final int TOUCHE2_J2 = Touches.TOUCHE2_J2;
	private static final int TOUCHE3_J2 = Touches.TOUCHE3_J2;

	private static final int POS_C1_J1 = 3;
	private static final int POS_C2_J1 = 4;
	private static final int POS_C3_J1 = 5;
	private static final int POS_C1_J2 = 6;
	private static final int POS_C2_J2 = 7;
	private static final int POS_C3_J2 = 8;

	private static ISpeed speed;
	
	private static boolean stop = false;

	private FenetreHote ihm ;

	/**
	 * Le constructeur du contrôleur initialise la partie (deux joueurs = deux paquets) et deux sommets de tas.
	 * Puis, il crée une fenêtre hôte et lui transmet l'information à afficher.
	 */
	public Controleur() {
		super();
		speed = new Speed();
		
		ihm = new FenetreHote();
		this.afficherCartes();

		ihm.setNoms(speed.getJoueur1().getNom(), speed.getJoueur2().getNom());

		/* Activer le contrôleur de touche frappée */
		ihm.addKeyListener(this);
	}

	private void afficherCartes() {
		ihm.setSommets(speed.getSommet1().getMotif().toString(),
						Controleur.getCouleur(speed.getSommet1()), speed.getSommet1().getValeur(),
						speed.getSommet2().getMotif().toString(), getCouleur(speed.getSommet2()), speed.getSommet2().getValeur());
		ICarte carte1=speed.getJoueur1().get(0);
		ICarte carte2=speed.getJoueur1().get(1);
		ICarte carte3=speed.getJoueur1().get(2);
		ihm.setCartesJoueur1(carte1.getMotif().toString(), getCouleur(carte1), carte1.getValeur(), carte2.getMotif().toString(), getCouleur(carte2), carte2.getValeur(), carte3.getMotif().toString(), getCouleur(carte3), carte3.getValeur());
		carte1=speed.getJoueur2().get(0);
		carte2=speed.getJoueur2().get(1);
		carte3=speed.getJoueur2().get(2);
		ihm.setCartesJoueur2(carte1.getMotif().toString(), getCouleur(carte1), carte1.getValeur(), carte2.getMotif().toString(), getCouleur(carte2), carte2.getValeur(), carte3.getMotif().toString(), getCouleur(carte3), carte3.getValeur());		
	}
	
	private static Color getCouleur(ICarte carte) {
		return carte.getCouleur();
	}

	/**
	 * Cette procédure indique la marche à suivre quand une touche est enfoncée
	 */
	public void keyPressed (final KeyEvent e)
	{
		// La gestion du booléen stop permet d'éviter de garder une touche enfoncée		
		if (!stop) {
			stop = true;
			int toucheFrappee=e.getKeyCode();

			/* La fonction getPositionCarte permet de transformer une touche frappée,
			un caractère, en une des positions figurées sur la table de jeu.
			 */

			int position = Controleur.getPositionCarte(toucheFrappee);

			/*
			position indique quelle carte a été choisie par le clavier.
			Les cartes du joueur 1 sont en position 3-5,
			celles du joueur 2 en position 6-8

			Avant de prendre en compte le choix d'une carte, on vérifie qu'elle
			est compatible avec la carte du sommet d'un des tas. Si c'est le cas,
			on la supprime de la main du joueur et on la place sur le sommet du tas.

			Il est possible que les deux tas puissent accueillir la carte jouée.
			Le programme privilégie le tas 1 pour le joueur 1 et le tas 2 pour le joueur 2 
			 */
			switch (position) {
			case POS_C1_J1 :
				// nouveauSommet va prendre la valeur de la 1ère carte du joueur 1 si celle-ci peut être posée sur le sommet 1 courant.
				// nouveauSommet reste null sinon.
				ICarte nouveauSommet = speed.getJoueur1().testerCarteSommet(0,speed.getSommet1(),speed.getJoueur2()); 
				if (nouveauSommet==null) {
					// nouveauSommet va prendre la valeur de la 1ère carte du joueur 1 si celle-ci peut être posée sur le sommet 2 courant.
					// nouveauSommet reste null sinon.
					nouveauSommet = speed.getJoueur1().testerCarteSommet(0,speed.getSommet2(),speed.getJoueur2());
					if (nouveauSommet==null) {
						// le joueur a fait une erreur, il va être pénalisé et le joueur 2 va perdre toute éventuelle pénalité
						speed.getJoueur1().gererErreur(speed.getJoueur2());
					}
					else {
						// la carte va sur le sommet 2 et a été ôtée du jeu du joueur 1
						speed.setSommet2(nouveauSommet);
					}
				}
				else {
					// la carte va sur le sommet 1 et a été ôtée du jeu du joueur 1
					speed.setSommet1(nouveauSommet);
				}
				break;

			case POS_C2_J1 :			
				nouveauSommet = speed.getJoueur1().testerCarteSommet(1,speed.getSommet1(),speed.getJoueur2()); 
				if (nouveauSommet==null) {
					nouveauSommet = speed.getJoueur1().testerCarteSommet(1,speed.getSommet2(),speed.getJoueur2());
					if (nouveauSommet==null) {
						speed.getJoueur1().gererErreur(speed.getJoueur2());
					}
					else {
						speed.setSommet2(nouveauSommet);
					}
				}
				else {
					speed.setSommet1(nouveauSommet);
				}

				break;
			case POS_C3_J1 :	
				nouveauSommet = speed.getJoueur1().testerCarteSommet(2,speed.getSommet1(),speed.getJoueur2()); 
				if (nouveauSommet==null) {
					nouveauSommet = speed.getJoueur1().testerCarteSommet(2,speed.getSommet2(),speed.getJoueur2());
					if (nouveauSommet==null) {
						speed.getJoueur1().gererErreur(speed.getJoueur2());
					}
					else {
						speed.setSommet2(nouveauSommet);
					}
				}
				else {
					speed.setSommet1(nouveauSommet);
				}


				break;
			case POS_C1_J2 :
				nouveauSommet = speed.getJoueur2().testerCarteSommet(0,speed.getSommet1(),speed.getJoueur1()); 
				if (nouveauSommet==null) {
					nouveauSommet = speed.getJoueur2().testerCarteSommet(0,speed.getSommet2(),speed.getJoueur1());
					if (nouveauSommet==null) {
						speed.getJoueur2().gererErreur(speed.getJoueur1());
					}
					else {
						speed.setSommet2(nouveauSommet);
					}
				}
				else {
					speed.setSommet1(nouveauSommet);
				}

				break;
			case POS_C2_J2:
				nouveauSommet = speed.getJoueur2().testerCarteSommet(1,speed.getSommet1(),speed.getJoueur1()); 
				if (nouveauSommet==null) {
					nouveauSommet = speed.getJoueur2().testerCarteSommet(1,speed.getSommet2(),speed.getJoueur1());
					if (nouveauSommet==null) {
						speed.getJoueur2().gererErreur(speed.getJoueur1());
					}
					else {
						speed.setSommet2(nouveauSommet);
					}
				}
				else {
					speed.setSommet1(nouveauSommet);
				}
				break;
			case POS_C3_J2 :	
				nouveauSommet = speed.getJoueur2().testerCarteSommet(2,speed.getSommet1(),speed.getJoueur1()); 
				if (nouveauSommet==null) {
					nouveauSommet = speed.getJoueur2().testerCarteSommet(2,speed.getSommet2(),speed.getJoueur1());
					if (nouveauSommet==null) {
						speed.getJoueur2().gererErreur(speed.getJoueur1());
					}
					else {
						speed.setSommet2(nouveauSommet);
					}
				}
				else {
					speed.setSommet1(nouveauSommet);
				}
				break;
			default: // C'était une mauvaise touche ou la touche d'un joueur bloqué
				break;
			}
			// les mains sont éventuellement complétées par des cartes vides pour toujours pouvoir afficher 3 cartes, ce qui simplifie la lecture du code et permet de varier les constructeurs sur ce TP
			if (speed.getJoueur1().size()==2) {				speed.getJoueur1().add(new CarteVide());			}
			if (speed.getJoueur2().size()==2) {				speed.getJoueur2().add(new CarteVide());			}
			if (speed.getJoueur1().gagne()) {ihm.setGagnant(speed.getJoueur1().getNom());}
			if (speed.getJoueur2().gagne()) {ihm.setGagnant(speed.getJoueur2().getNom());}

			this.afficherCartes();
			
			// Cet appel permet de réafficher l'état actuel du jeu.
			ihm.repaint();
		}
	}

	/**
	 * Cette procédure indique la marche à suivre lorsqu'une touche est relâchée.
	 */
	public void keyReleased (final KeyEvent e)
	{

		//code pour un key released  

		// Si personne n'a gagné, on permet de retaper une touche au clavier -stop passe à faux-
		// sinon, la partie est terminée.
		if (!speed.getJoueur1().gagne() && !speed.getJoueur2().gagne()) {stop=false;}
	}

	public void keyTyped (final KeyEvent e)
	{
		//code pour un key typed  
	} 

	
	
	/**
	 * La touche est prise en compte si le joueur n'a pas de penalite. 
	 * @param toucheFrappee
	 * @return
	 */
	private static int getPositionCarte(final int toucheFrappee) {
		int rep = ERREUR_FRAPPE;
		if (speed.getJoueur1().sansPenalite()) {
			switch (toucheFrappee) {
			case TOUCHE1_J1 : rep = POS_C1_J1;			break;
			case TOUCHE2_J1 : rep = POS_C2_J1;			break;
			case TOUCHE3_J1 : rep = POS_C3_J1;			break;
			default: break;
			}
		}

		if (speed.getJoueur2().sansPenalite()) {
			switch (toucheFrappee) {
			case TOUCHE1_J2 : rep = POS_C1_J2;			break;
			case TOUCHE2_J2 : rep = POS_C2_J2;			break;
			case TOUCHE3_J2 : rep = POS_C3_J2;			break;
			default: break;
			}
		}

		return rep;
	}


}
