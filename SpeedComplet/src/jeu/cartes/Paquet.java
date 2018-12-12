package jeu.cartes;

import java.util.ArrayList;
import java.util.List;

public abstract class Paquet<T> implements IPaquet<T>{
	
	protected List<T> lePaquet = new ArrayList<T>();

	
	
	
	public Paquet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paquet(List<T> lePaquet) {
		super();
		this.lePaquet = lePaquet;
	}

	public List<T> getLePaquet() {
		return lePaquet;
	}

	public void setLePaquet(List<T> lePaquet) {
		this.lePaquet = lePaquet;
	}

	@Override
	public boolean add(T obj) {
		
		return lePaquet.add(obj);
	}

	@Override
	public T get(int i) {
		
		return lePaquet.get(i);
	}

	@Override
	public T remove(int i) {
		
		return lePaquet.remove(i);
	}

	@Override
	public int size() {
		
		return lePaquet.size();
	}
	
	
}
