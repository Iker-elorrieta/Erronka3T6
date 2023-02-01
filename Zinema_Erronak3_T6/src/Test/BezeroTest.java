package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Bezero;

class BezeroTest {
	
	String DNI = "12345678A";
	String izena = "Mario";
	String abizen_1 = "Super";
	String abizen_2 = "Bros";
	boolean sexua = true;
	String pasahitza = "Luigi";

	@Test
	void testGetetaSet() {
		Bezero b1 = new Bezero();
		b1.setAbizen_1(abizen_1);
		b1.setAbizen_2(abizen_2);
		b1.setDNI(DNI);
		b1.setIzena(izena);
		b1.setPasahitza(pasahitza);
		b1.setSexua(sexua);
		assertEquals(b1.getAbizen_1(), abizen_1);
		assertEquals(b1.getAbizen_2(), abizen_2);
		assertEquals(b1.getDNI(), DNI);
		assertEquals(b1.getIzena(), izena);
		assertEquals(b1.getPasahitza(), pasahitza);
		assertEquals(b1.isSexua(), sexua);
	}
	@Test
	void testToString() {
		Bezero b1 = new Bezero(DNI, izena, abizen_1, abizen_2, sexua, pasahitza);
		assertEquals(b1.toString(), "Bezero [DNI=" + DNI + ", izena=" + izena + ", abizen_1=" + abizen_1 + ", abizen_2=" + abizen_2
				+ ", sexua=" + sexua + ", pasahitza=" + pasahitza + "]");
	}
	@Test
	void testEquals() {
		Bezero b1 = new Bezero();
		Bezero b2 = new Bezero();
		b2.setDNI(DNI);
		b2.setAbizen_1("Manolo");
		b1.setAbizen_1(abizen_1);
		b1.setAbizen_2(abizen_2);
		b1.setDNI(DNI);
		b1.setIzena(izena);
		b1.setPasahitza(pasahitza);
		b1.setSexua(sexua);
		assertTrue(b1.equals(b2));
		assertFalse(b1.equals(null));
	}
		

}
