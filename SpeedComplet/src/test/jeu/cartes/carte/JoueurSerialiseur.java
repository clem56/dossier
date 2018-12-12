package test.jeu.cartes.carte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JoueurSerialiseur {

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
		fail("Not yet implemented");
		System.out.println("test de serialise");
		
	}

	@Test
	void testDeserialise() {
		fail("Not yet implemented");
		System.out.println("test de deserialise");
		
	}

}
