package test.jeu.cartes.carte;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.cartes.carte.Carte;
import jeu.cartes.carte.CarteSpeed;
import jeu.cartes.carte.CarteVide;
import jeu.cartes.carte.Symbole;

class CarteSpeedTest {
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
	void testIsVide() {
		//fail("Not yet implemented");
		System.out.println("test de isVide");
		c1 = new CarteSpeed(1, 3, Symbole.ARBRE);
		assertFalse(c1.isVide());
		c1 = new CarteVide();
		assertTrue(c1.isVide());
		
	}

	

	

	@Test
	void testEstCompatible() {
		//fail("Not yet implemented");
		System.out.println("test de estCompatible");
		c1 = new CarteSpeed(2, 5, Symbole.DIAMANT);
		c2 = new CarteSpeed(3, 1, Symbole.ARBRE);
		assertFalse(c1.estCompatible(c2));
		c1 = new CarteSpeed(2, 4, Symbole.BALLON);
		c2 = new CarteSpeed(2, 4, Symbole.BALLON);
		assertTrue(c1.estCompatible(c2));
	}

	@Test
	void testGetColor() {
		//fail("Not yet implemented");
		System.out.println("test de getColor");
		
		assertFalse(Carte.getColor(3).equals(Color.blue));
		assertEquals(Carte.getColor(3),Color.cyan);
	}

	@Test
	void testGetIntFromColor() {
		//fail("Not yet implemented");
		System.out.println("test de getIntFromColor");
		assertEquals(Carte.getIntFromColor(Color.blue), 1);
		assertEquals(Carte.getIntFromColor(Color.orange),2);
	}

}
