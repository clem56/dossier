package jeu.cartes.carte;

public class CarteVide extends CarteSpeed{
		private final static int valeurVide=-1;
		private final static int couleurVide=999;
		private final static Symbole motifVide=Symbole.VIDE;

		public CarteVide() {
		super(valeurVide, couleurVide, motifVide);
		
		
	}
	
	public boolean isVide() {
		return true;
		
	}
	
	
}
