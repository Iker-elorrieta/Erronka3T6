package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Modelo.Areto;
import Modelo.Saioa;

class AretoTest {
	
	int id = 1;
	int zenbakia = 2;
	Saioa [] s1 = new Saioa[1];
	
	
	

	@Test
	void testGetyEtaSet() {
		Areto ar = new Areto();
		ar.setID_areto(id);
		ar.setZenbakia(zenbakia);
		ar.setSaioak(s1);
		
		assertEquals(ar.getID_areto(), id);
		assertEquals(ar.getZenbakia(), zenbakia);
		assertEquals(ar.getSaioak(), s1);
	}
	@Test
	void testToString() {
		Areto ar = new Areto(id, zenbakia, s1);
		assertEquals(ar.toString(), "Areto [ID_areto=" + id + ", zenbakia=" + zenbakia + ", saioak=" + Arrays.toString(s1) + "]");
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
		assertFalse(ar.equals(null));
	}

}
