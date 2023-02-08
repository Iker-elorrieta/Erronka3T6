package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Modelo.Areto;
import Modelo.Zinema;

class ZinemaTest {

	int id = 1;
	String izena = "Wario";
	String lokalitatea = "Reino Champiñon";
	Areto [] ar1 = new Areto [1]; 
	
	@Test
	void testGetetaSet() {
		Zinema z1 = new Zinema ();
		z1.setID_zinema(id);
		z1.setIzena(izena);
		z1.setLokalitatea(lokalitatea);
		z1.setAretoak(ar1);
		assertEquals(z1.getID_zinema(), id);
		assertEquals(z1.getIzena(), izena);
		assertEquals(z1.getLokalitatea(), lokalitatea);
		assertEquals(z1.getAretoak(), ar1);
	}
	@Test
	void testToString() {
		Zinema z1 = new Zinema (id, izena, lokalitatea, ar1);
		assertEquals(z1.toString(), izena);
	}
	@Test
	void testEquals() {
		Zinema z1 = new Zinema ();
		Zinema z2 = new Zinema ();
		z2.setID_zinema(id);
		z1.setID_zinema(id);
		z1.setIzena(izena);
		z1.setLokalitatea(lokalitatea);
		assertTrue(z1.equals(z2));
		assertFalse(z1.equals(null));
	}
	

}
