package serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import jeu.cartes.PaquetCarteSpeed;
import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.ICarte;

public class PaquetSerialiseur implements ISerialiseur<PaquetCarteSpeed>{

	
	private static final String SEPARATEUR = "\n";
	//private static final String PaquetVide = "Vide";
	private static  PaquetSerialiseur ps=null;

	public static PaquetSerialiseur getInstance() {
		if(ps==null) {
			ps = new PaquetSerialiseur();	
		}

		return ps;
	}
	@Override
	public char getSeparateur() {
		
		return 0;
	}

	@Override
	public String serialise(PaquetCarteSpeed obj) {
		String rep="";
		for (int i = 0; i < obj.size(); i++) {
			if (i!=0) {
				rep+=SEPARATEUR;
			}
			CarteSpeed carte = (CarteSpeed) obj.get(i);
			 rep+=CarteSerialiseur.getInstance().serialise(carte);
			}
		/*if(obj.size()==0) {
			String rep1=PaquetVide;
		}*/
		return rep;
	}

	@Override
	public PaquetCarteSpeed deserialise(String chaine) {
		String carte = "" ;
		StringTokenizer st = new StringTokenizer(chaine, SEPARATEUR+"");
		List<ICarte> paquetDeserialise = new ArrayList<ICarte>();
		while (st.hasMoreTokens()) {
		carte = st.nextToken();	
			paquetDeserialise.add(CarteSerialiseur.getInstance().deserialise(carte));
		}
		return new PaquetCarteSpeed(paquetDeserialise);
	}
}

