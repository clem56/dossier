package jeu.cartes;

/**
 * Vous pouvez vous-même déclarer des classes ou interfaces génériques
 * (comme ArrayList) qui sont définies pour un type qui peut être précisé
 * par la suite.  
 * Dans notre contexte, les IPaquet ne fonctionneront que pour des Cartes,
 * mais on peut envisager que le type T ne soit pas toujours Carte (tuiles, billets etc.).
 * 
 * Cette interface définit les méthodes qu'on attend d'un paquet.
 * On peut se rendre compte qu'elles correspondent à certaines méthodes
 * de l'ArrayList.
 */
public interface IPaquet <T>{

	public boolean add(T obj);
	public T  get(int i);
	public T remove(int i);
	public int size();
	
	
}
