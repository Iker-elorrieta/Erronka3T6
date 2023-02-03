package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Film;

import Modelo.Saioa;

class SaioaTest {
	
	int id = 1;
	Date fecha = null;
	int ordua = 0;
	int minutua = 0;
	Calendar cal = Calendar.getInstance();
	Film [] f1 = new Film [1];
	
	@Test
	void testGetetaSet() {
		
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Saioa s1 = new Saioa ();
		s1.setData(fecha);
		s1.setID_saioa(id);
		s1.setOrdua(ordua);
		s1.setFilma(f1);
		s1.setOrdua(ordua);
		s1.setMinutua(minutua);
		assertEquals(s1.getID_saioa(), id);
		assertEquals(s1.getData(), fecha);
		assertEquals(s1.getOrdua(), ordua);
		assertEquals(s1.getMinutua(), minutua);
		assertEquals(s1.getFilma(), f1);
	}
	@Test
	void testToString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Saioa s1 = new Saioa(id, fecha, ordua, minutua, f1);
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		assertEquals(s1.toString(), "Saioa [ID_saioa=" + id + ", data=" + dt.format(fecha) + ", ordua=" + ordua + ", minutua=" + minutua + ", filma=" + Arrays.toString(f1) + "]");
	}
	@Test
	void testEquals() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Saioa s1 = new Saioa ();
		Saioa s2 = new Saioa();
		s2.setID_saioa(id);
		s1.setID_saioa(id);
		s1.setData(fecha);
		s1.setID_saioa(id);
		s1.setOrdua(ordua);
		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(null));
	}

}
