package jeu;




import java.awt.Color;

import controleur.Controleur;
import jeu.cartes.PaquetCarteSpeed;
import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.ICarte;
import jeu.cartes.carte.Symbole;
import serializer.CarteSerialiseur;
import serializer.JoueurSerialiseur;
import serializer.PaquetSerialiseur;
public class Speed implements ISpeed {

	public static void main(String[] args) {
		
		new Controleur();
		/*JoueurSpeed js = new JoueurSpeed(null, null);
		String rep = JoueurSerialiseur.getInstance().serialise(js);
		System.out.println(rep);*/
		/*CarteSpeed cs = new CarteSpeed(1, 3, Symbole.DIAMANT);
		String rep = CarteSerialiseur.getInstance().serialise(cs);
		System.out.println(rep);*/
		/*CarteSpeed cs = CarteSerialiseur.getInstance().deserialise("3:4:5");
		System.out.println(cs);*/
		/*PaquetCarteSpeed lePaquet = new PaquetCarteSpeed();
		String rep = PaquetSerialiseur.getInstance().serialise(lePaquet);
		System.out.println(rep);*/
		/*PaquetCarteSpeed lePaquet = new PaquetCarteSpeed();
		String paq = PaquetSerialiseur.getInstance().serialise(lePaquet);
		PaquetCarteSpeed ps = PaquetSerialiseur.getInstance().deserialise(paq);
		System.out.println(ps);*/
	}
	
	private IJoueur joueur1;
	private IJoueur joueur2;
	private ICarte sommet1;
	private ICarte sommet2;

	
	public Speed() {
		super();
		PaquetCarteSpeed pc = new PaquetCarteSpeed();
		joueur1 = new JoueurSpeed("joueur 1", pc);
		joueur2 = new JoueurSpeed("joueur 2",new PaquetCarteSpeed(pc, pc.size()/2));

		sommet1=joueur1.remove(0);
		sommet2=joueur2.remove(0);
		
		System.out.println(joueur1.size());
		System.out.println(joueur2.size());
	}
	@Override
	public IJoueur getJoueur1() {
		
		return joueur1;
	}

	@Override
	public IJoueur getJoueur2() {
		
		return joueur2;
	}

	@Override
	public ICarte getSommet1() {
		
		return sommet1;
	}

	@Override
	public ICarte getSommet2() {
		
		return sommet2;
	}

	@Override
	public void setSommet1(ICarte nouveauSommet) {
		sommet1=nouveauSommet;
	}

	@Override
	public void setSommet2(ICarte nouveauSommet) {
		sommet2=nouveauSommet;
		
	}
	
}
