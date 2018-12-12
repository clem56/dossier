package serializer;

import jeu.Speed;

public class SpeedSerialiseur implements ISerialiseur<Speed>{

	
	private static final String SEPARATEUR = ":";

	@Override
	public char getSeparateur() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String serialise(Speed obj) {
		String rep=""+obj.getJoueur1()+SEPARATEUR+obj.getJoueur2()+SEPARATEUR+obj.getSommet1()+SEPARATEUR+obj.getSommet2()+SEPARATEUR;
		
		return rep;
	}

	@Override
	public Speed deserialise(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

}
