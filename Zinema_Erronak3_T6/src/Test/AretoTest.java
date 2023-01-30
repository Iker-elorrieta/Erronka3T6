package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Areto;

class AretoTest {
	
	int id = 1;
	int zenbakia = 2;
	

	@Test
	void testGetyEtaSet() {
		Areto ar = new Areto();
		ar.setID_areto(id);
		ar.setZenbakia(zenbakia);
		assertEquals(ar.getID_areto(), id);
		assertEquals(ar.getZenbakia(), zenbakia);
	}
	@Test
	void testToString() {
		Areto ar = new Areto();
		ar.setID_areto(id);
		ar.setZenbakia(zenbakia);
		assertEquals(ar.toString(), "Areto [ID_areto=" + id + ", zenbakia=" + zenbakia + "]");
	}
	@Test
	void testEquals() {
		Areto ar = new Areto();
		Areto ar2 = new Areto ();
		ar2.setID_areto(id);
		ar2.setZenbakia(4);
		ar.setID_areto(id);
		ar.setZenbakia(zenbakia);
		assertTrue(ar.equals(ar2));
	}

}
