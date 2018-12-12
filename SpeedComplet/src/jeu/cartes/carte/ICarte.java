package jeu.cartes.carte;

import java.awt.Color;

public interface ICarte {

	public Color getCouleur() ;

	public int getValeur() ;

	public Symbole getMotif();
	
	public boolean estCompatible(ICarte c2);
	
	public boolean isVide();

}
