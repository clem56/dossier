package jeu;

import jeu.cartes.carte.ICarte;

public interface ISpeed {
	public IJoueur getJoueur1();
	public IJoueur getJoueur2();
	public ICarte getSommet1();
	public ICarte getSommet2();
	public void setSommet1(ICarte nouveauSommet);
	public void setSommet2(ICarte nouveauSommet);
	
}
