package test.jeu.cartes.carte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.Symbole;
import serializer.CarteSerialiseur;

class CarteSerialiseurTest {
	private CarteSpeed c1 = null;
	private CarteSpeed c2 = null;
	
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
		c1 = new CarteSpeed(2, 2, Symbole.DIAMANT);
		assertEquals(CarteSerialiseur.getInstance().serialise(c1),"2:2:5");	
		//assertTrue(CarteSerialiseur.getInstance().serialise(c1).equals("2:2:5"));	
		}

	@Test
	void testDeserialise() {
		//fail("Not yet implemented");
		System.out.println("test de deserialise");
		c2 = new CarteSpeed(2, 3, Symbole.FANION);
		String rep = "2:3:3";
		assertEquals(CarteSerialiseur.getInstance().deserialise(rep), c2);
		
	}

}
