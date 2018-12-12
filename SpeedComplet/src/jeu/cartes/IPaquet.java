package jeu.cartes;

/**
 * Vous pouvez vous-m�me d�clarer des classes ou interfaces g�n�riques
 * (comme ArrayList) qui sont d�finies pour un type qui peut �tre pr�cis�
 * par la suite.  
 * Dans notre contexte, les IPaquet ne fonctionneront que pour des Cartes,
 * mais on peut envisager que le type T ne soit pas toujours Carte (tuiles, billets etc.).
 * 
 * Cette interface d�finit les m�thodes qu'on attend d'un paquet.
 * On peut se rendre compte qu'elles correspondent � certaines m�thodes
 * de l'ArrayList.
 */
public interface IPaquet <T>{

	public boolean add(T obj);
	public T  get(int i);
	public T remove(int i);
	public int size();
	
	
}
