package jeu.cartes.carte;



public enum Symbole {
	ETOILE("étoile"),ARBRE("arbres"), MAISON("maison"), FANION("fanion"), BALLON("ballon"), DIAMANT("diaman"), CHAT("chat"), VIDE("VIDE");
	private final String nomAffichage;
	
	private static final Symbole [] TABLEAU = Symbole.values();	
	public static final int NBR_SYMBOLES = TABLEAU.length;
	
	
	private Symbole(String chaine) {
		this.nomAffichage = chaine;
	}
	
	@Override
	public String toString() {
		
		return nomAffichage;
	}

	public static Symbole get(int motif) {
		
		return TABLEAU[motif];
	}

	
	
}
