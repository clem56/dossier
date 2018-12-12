package jeu;

import jeu.cartes.PaquetCarteSpeed;
import jeu.cartes.carte.ICarte;

public class JoueurSpeed extends Joueur {


	private int penalite = 0;
	private static final int PENALITE = 3;
	private PaquetCarteSpeed paquet;

	public JoueurSpeed(String nom, PaquetCarteSpeed pc) {
		super(nom);
		paquet=pc;
	}
	
	public JoueurSpeed(String nom, int penalite, PaquetCarteSpeed paquet) {
		super(nom);
		this.penalite = penalite;
		this.paquet = paquet;
	}

	@Override
	public void annulerPenalite() {
		this.penalite=0;

	}

	@Override
	public ICarte remove(int i) {

		return this.paquet.remove(i);
	}

	@Override
	public int size() {

		return this.paquet.size();
	}

	@Override
	public ICarte get(int i) {

		return this.paquet.get(i);
	}

	@Override
	public ICarte testerCarteSommet(int position, ICarte sommet1, IJoueur joueur2) {
		ICarte rep=null;
		if(this.paquet.get(position).estCompatible(sommet1)) {
			rep=this.paquet.remove(position);
			joueur2.oterEventuellementUnePenalite();
		}
		return rep;
	}

	@Override
	public void gererErreur(IJoueur joueur2) {
		this.ajouterPenalite();
		joueur2.annulerPenalite();
	}

	@Override
	public void oterEventuellementUnePenalite() {
		if(this.penalite>0) {
			this.penalite--;
		}

	}

	@Override
	public boolean add(ICarte carte) {

		return this.paquet.add(carte);
	}

	@Override
	public boolean gagne() {
		ICarte premièreCarte = paquet.get(0);
		return premièreCarte.isVide();
	}

	@Override
	public boolean sansPenalite() {

		return this.penalite==0;
	}



	@Override
	public void ajouterPenalite() {
		this.penalite=PENALITE;
	}
	
	public PaquetCarteSpeed getPaquet() {
		return paquet;
	}
	public int getPenalite() {
		return penalite;
	}
	

	

}


