package serializer;

import java.util.StringTokenizer;

import jeu.JoueurSpeed;
import jeu.cartes.PaquetCarteSpeed;

public  class JoueurSerialiseur implements ISerialiseur<JoueurSpeed>{
	private static  JoueurSerialiseur js=null;

	public static JoueurSerialiseur getInstance() {
		if(js==null) {
			js = new JoueurSerialiseur();	
		}

		return js;
	}
	
	private static final String SEPARATEUR = ":";
	@Override
	public char getSeparateur() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String serialise(JoueurSpeed obj) {
		String rep=""+obj.getNom()+SEPARATEUR+PaquetSerialiseur.getInstance().serialise(obj.getPaquet())+SEPARATEUR+obj.getPenalite()+SEPARATEUR;
		return rep;
	}

	@Override
	public JoueurSpeed deserialise(String chaine) {
		StringTokenizer st1 = new StringTokenizer(chaine, SEPARATEUR+"");
		if (st1.countTokens()!=3) {
			System.err.println("problème nombre de tokens CarteSpeed");
				}
		
		
		int penalite = Integer.parseInt(st1.nextToken());
		PaquetCarteSpeed paquet = new PaquetCarteSpeed();
		return new JoueurSpeed(chaine, penalite, paquet);
		
	}

}
