package jeu.cartes;

import java.util.Collections;
import java.util.List;

import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.ICarte;
import jeu.cartes.carte.Symbole;

public class PaquetCarteSpeed extends Paquet<ICarte>{

	public static final int NBR_CARTES = 72;


	public PaquetCarteSpeed(List<ICarte> lePaquet) {
		super(lePaquet);
		}


	public PaquetCarteSpeed(PaquetCarteSpeed p1, int n) {
		if (p1.size()<n) {
			System.err.println("Paquet trop petit");
	}
		
	else {
		for (int i = 0; i < n; i++) {
			//Carte c1 = p1.remove(0);
			//this.cartes.add(p1.cartes.remove(0));
			this.add(p1.remove(0));
		}
	}
}	
	
	
	public PaquetCarteSpeed() {
		super();
		for (int val = 1; val <= CarteSpeed.NBR_VALEURS; val++) {
			for (int symb = 0; symb <= CarteSpeed.NBR_MOTIFS; symb++) {
				for (int coul = 1; coul <= CarteSpeed.NBR_COULEURS; coul++) {
					Symbole symbol = Symbole.get(symb);
					CarteSpeed c = new CarteSpeed(val, coul, symbol);
					//cartes.add(c);
					super.add(c);
				}
			}

		}
		
		Collections.shuffle(lePaquet);
		int taille =this.size(); 
		while (taille>NBR_CARTES) {
			super.remove(0);
			taille--;
		}
		for (int i = this.size(); i>NBR_CARTES; i --) {
			super.remove(0);
		}
	}
	
	
	
	@Override
	public String toString() {
		return "PaquetCartesSpeed [lePaquet=" + lePaquet + ", size()=" + size() + "]";
	}

	

	
	
	

}
