package jeu.cartes.carte;

public class CarteSpeed extends Carte{
	
	public static final int NBR_MOTIFS=5;
	private Symbole motif;

	public CarteSpeed(int valeur, int couleur, Symbole motif) {
		super(valeur,couleur);

		if (NBR_MOTIFS<Symbole.NBR_SYMBOLES ) {
			this.valeur = valeur;
			this.couleur = getColor(couleur);
			this.motif = motif;
		}
		else {
			System.err.println("Problème de carte");
			//forcerCarteVide();
		}
	}

	

	@Override
	public Symbole getMotif() {
		
		return motif;
	}

	

	@Override
	public boolean estCompatible(ICarte c2) {
		
		return (!this.isVide() && 
				   ((this.valeur == c2.getValeur() 
				   || this.motif.equals(c2.getMotif()) 
				   || this.couleur.equals(c2.getCouleur()))));
	}

	
	
	@Override
	public boolean equals(Object arg0) {
		CarteSpeed c2 = (CarteSpeed) arg0;
		return (/*!this.isVide() && */
				   ((this.valeur == c2 .getValeur() 
				   && this.motif.equals(c2.getMotif()) 
				   && this.couleur.equals(c2.getCouleur()))));
	}



	@Override
	public boolean isVide() {
		
		return false;
	}

	@Override
	public String toString() {
		return "Carte [valeur=" + valeur + ", couleur=" + couleur + ", motif=" + motif  +"]"+"\n";
	}


	

}
