package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controlador.datuBase;
import Modelo.Bezero;

class bezeroKargaTest {

	@Test
	void test() {
		Bezero[] bezeroak = datuBase.bezeroKarga();
		assertNotNull(bezeroak);
		assertTrue(bezeroak.length > 0);
		
		Bezero bezeroa = bezeroak [0];
		assertNotNull(bezeroa);
		assertNotNull(bezeroa.getDNI());
		assertNotNull(bezeroa.getPasahitza());
	}

}
