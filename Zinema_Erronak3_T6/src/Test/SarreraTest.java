package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Film;
import Modelo.Sarrera;

class SarreraTest {
	LocalDateTime locaDate = LocalDateTime.now();
	int id = 1;
	Date fecha = null;
	int ordua  = locaDate.getHour();
	int minutua = locaDate.getMinute();
	Calendar cal = Calendar.getInstance();
	int salneurria = 2;
	Film [] f1 = new Film[1];
	

	@Test
	void testGetetaSet() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Sarrera s1 = new Sarrera();
		s1.setID_sarrera(id);
		s1.setErosketa_data(fecha);
		s1.setOrdua(ordua);
		s1.setMinutua(minutua);
		s1.setSalneurria(salneurria);
		s1.setFilma(f1);
		assertEquals(s1.getID_sarrera(), id);
		assertEquals(s1.getErosketa_data(), fecha);
		assertEquals(s1.getOrdua(), ordua);
		assertEquals(s1.getMinutua(), minutua);
		assertEquals(s1.getSalneurria(), salneurria);
		assertEquals(s1.getFilma(), f1);
		
		
	}
	@Test
	void testToString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Sarrera s1 = new Sarrera(id, fecha, 2, f1);
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		assertEquals(s1.toString(), "Sarrera [ID_sarrera=" + id + ", erosketa_data=" + dt.format(fecha) + ", ordua=" + ordua
				+ ", minutua=" + minutua + ", salneurria=" + salneurria + ", filma=" + Arrays.toString(f1) + "]");
	}
	@Test
	void testEquals() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Sarrera s1 = new Sarrera();
		Sarrera s2 = new Sarrera();
		s2.setID_sarrera(id);
		s1.setID_sarrera(id);
		s1.setErosketa_data(fecha);
		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(null));
	}

}
