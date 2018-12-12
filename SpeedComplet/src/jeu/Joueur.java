package jeu;

public abstract class Joueur implements IJoueur{
	
	
	
	protected String nom;
	
		
	
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String getNom() {
		
		return nom;
	}

	
}
