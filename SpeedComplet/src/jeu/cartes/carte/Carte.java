package jeu.cartes.carte;



import java.awt.Color;



public abstract class Carte implements ICarte{
	public static final int NBR_COULEURS = 5;
	public static final int NBR_VALEURS = 5;
	public static final int NBR_MOTIFS = 5;
	public static final int NBR_CARTES = 72;

	protected  int valeur;
	protected  Color couleur;
	



	

	public Carte(int valeur, int couleur) {
		super();
		if (valeur>0 && valeur<=NBR_VALEURS && couleur>0 &&couleur <=NBR_COULEURS) {
			this.valeur = valeur;
			this.couleur = getColor(couleur);
		}
		
		


	}

	/*private void forcerCarteVide() {

		this.valeur = -1;
		this.couleur = Color.darkGray;
		this.motif = Symbole.VIDE;
	}*/


	public static Color getColor(int indice) {
		Color coul = null;
		switch (indice) {

		case 1:  coul = Color.blue;         break;
		case 2:  coul = Color.orange;       break;	
		case 3:  coul = Color.cyan;         break;	
		case 4:  coul = Color.black;        break;
		case 5:  coul = Color.lightGray;    break;
		default: coul = Color.darkGray;     break;

		}
		return coul;
	}
	public static int getIntFromColor(Color couleur) {
		int indice;
		if(couleur.equals(Color.blue))  {
			indice=1;
		}
		else if(couleur.equals(Color.orange)) {
			indice=2;
		}
		else if(couleur.equals(Color.cyan)) {
			indice=3;
		}
		else if(couleur.equals(Color.black)) {
			indice=4;
		}
		else if(couleur.equals(Color.lightGray)) {
			indice=5;
		}
		else {
			indice=0;
		}
		return indice;
	}
	
	public int getValeur() {
		return valeur;
	}
	public Color getCouleur() {
		return couleur;
	}
	public Symbole getMotif() {
		return null;
	}
	
	
	// sur un booléen en premier mettre la réponse du booléen avec le true et false et le retour de la réponse
	
	
	public boolean isVide() {
		return false;
	}
	
		
	
	


	
	
}
