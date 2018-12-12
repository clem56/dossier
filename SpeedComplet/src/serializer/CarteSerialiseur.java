package serializer;

import java.awt.Color;
import java.util.StringTokenizer;


import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.Symbole;
import jeu.cartes.carte.Carte;


public class CarteSerialiseur implements ISerialiseur<CarteSpeed>{

	public static  String SEPARATEUR = ":";
	
	private static  CarteSerialiseur cs=null;

	public static CarteSerialiseur getInstance() {
		if(cs==null) {
			cs = new CarteSerialiseur();	
		}

		return cs;
	}

	public CarteSerialiseur() {
		super();

	}

	@Override
	public String serialise(CarteSpeed obj) {
		Color indice = obj.getCouleur();		
		String rep=""+obj.getValeur()+SEPARATEUR+Carte.getIntFromColor(indice)+SEPARATEUR+obj.getMotif().ordinal();
		//obj.getValeur();
		//obj.getCouleur();
		return rep;
	}
	@Override
	public CarteSpeed deserialise(String chaine) {
		StringTokenizer st = new StringTokenizer(chaine, SEPARATEUR+"");
		if (st.countTokens()!=3) {
			System.err.println("problème nombre de tokens CarteSpeed");
		}
		int valeur = Integer.parseInt(st.nextToken());
		int couleur= Integer.parseInt(st.nextToken());
		int motif =Integer.parseInt(st.nextToken());
	
		return new CarteSpeed(valeur, couleur, Symbole.get(motif));
	}
	@Override
	public char getSeparateur() {
		// TODO Auto-generated method stub
		return 0;
	}

}



