package jeu;

import jeu.cartes.carte.ICarte;

public interface IJoueur {

	public String getNom();
	public void annulerPenalite();
	public ICarte remove(int i);
	public int size();
	public ICarte get(int i);
	public ICarte testerCarteSommet(int i, ICarte sommet1, IJoueur joueur2);
	public void gererErreur(IJoueur joueur2);
	public void oterEventuellementUnePenalite();
	public boolean add(ICarte carte);
	public boolean gagne();
	public boolean sansPenalite();
	public void ajouterPenalite();
}
