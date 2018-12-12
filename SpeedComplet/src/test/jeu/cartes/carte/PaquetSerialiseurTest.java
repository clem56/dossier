package test.jeu.cartes.carte;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.cartes.PaquetCarteSpeed;
import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.ICarte;
import jeu.cartes.carte.Symbole;
import serializer.PaquetSerialiseur;

class PaquetSerialiseurTest {
	PaquetCarteSpeed p1 = null;
	CarteSpeed c1 =null;
	CarteSpeed c2 =null;
	CarteSpeed c3 =null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("lancer avant toute chose");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("fin des tests");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("avant chaque test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("après chaque test");
	}

	@Test
	void testSerialise() {
		//fail("Not yet implemented");
		System.out.println("test de serialise");
		List<ICarte> paquet = new ArrayList<ICarte>();
		//for (int i = 0; i < 2; i++) {
			CarteSpeed c1 = new CarteSpeed(1, 2, Symbole.CHAT);
			CarteSpeed c2 = new CarteSpeed(2, 3, Symbole.ARBRE);
			CarteSpeed c3 = new CarteSpeed(3, 5, Symbole.DIAMANT);
			paquet.add(c1);
			paquet.add(c2);
			paquet.add(c3);
		//}
		
		
		assertEquals(PaquetSerialiseur.getInstance().serialise(new PaquetCarteSpeed(paquet)),"1:2:6\n2:3:1\n3:5:5"); 
		
	}

	@Test
	void testDeserialise() {
		//fail("Not yet implemented");
		System.out.println("test de deserialise");
		List<ICarte> paquetDes = new ArrayList<ICarte>();
		
		//assertEquals(PaquetSerialiseur.getInstance().deserialise(paquetDes));
	}

}
