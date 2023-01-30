package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Zinema;

class ZinemaTest {

	int id = 1;
	String izena = "Wario";
	String lokalitatea = "Reino Champiñon";
	
	@Test
	void testGetetaSet() {
		Zinema z1 = new Zinema ();
		z1.setID_zinema(id);
		z1.setIzena(izena);
		z1.setLokalitatea(lokalitatea);
		assertEquals(z1.getID_zinema(), id);
		assertEquals(z1.getIzena(), izena);
		assertEquals(z1.getLokalitatea(), lokalitatea);
	}
	@Test
	void testToString() {
		Zinema z1 = new Zinema ();
		z1.setID_zinema(id);
		z1.setIzena(izena);
		z1.setLokalitatea(lokalitatea);
		assertEquals(z1.toString(), "Zinema [ID_zinema=" + id + ", izena=" + izena + ", lokalitatea=" + lokalitatea + "]");
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
	}
	

}
