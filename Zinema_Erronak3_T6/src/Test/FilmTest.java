package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Modelo.Film;
import Modelo.Saioa;

class FilmTest {
	
	int id = 1;
	String tituloa = "";
	int iraupena = 120;
	String generoa = "drama";
	double prezioa = 0;
	Saioa [] s1 = new Saioa[1];

	@Test
	void testGetetaSet() {
		Film f1 = new Film();
		f1.setID_film(id);
		f1.setGeneroa(generoa);
		f1.setIraupena(iraupena);
		f1.setPrezioa(prezioa);
		f1.setTituloa(tituloa);
		f1.setSaioak(s1);
		assertEquals(f1.getID_film(), id);
		assertEquals(f1.getGeneroa(), generoa);
		assertEquals(f1.getIraupena(), iraupena);
		assertEquals(f1.getPrezioa(), prezioa);
		assertEquals(f1.getTituloa(), tituloa);
		assertEquals(f1.getSaioak(), s1);
		
	}
	@Test
	void testToString() {
		Film f1 = new Film(id, tituloa, iraupena, generoa, prezioa, s1);
		assertEquals(f1.toString(),"Film [ID_film=" + id + ", tituloa=" + tituloa + ", iraupena=" + iraupena + ", generoa=" + generoa + ", prezioa=" + prezioa + ", saioak=" + Arrays.toString(s1) + "]");
	}
	@Test
	void testEquals() {
		Film f1 = new Film();
		Film f2 = new Film();
		f2.setID_film(1);
		f1.setID_film(id);
		f1.setGeneroa(generoa);
		f1.setIraupena(iraupena);
		f1.setPrezioa(prezioa);
		f1.setTituloa(tituloa);
		assertTrue(f1.equals(f2));
	}
}
