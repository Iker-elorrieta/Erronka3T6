package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Hora;
import Modelo.Sarrera;

class SarreraTest {
	
	int id = 1;
	Date fecha = null;
	Hora ordua = new Hora();
	Calendar cal = Calendar.getInstance();
	

	@Test
	void testGetetaSet() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		ordua.setHoras(11);
		ordua.setMinutos(56);
		Sarrera s1 = new Sarrera();
		s1.setID_sarrera(id);
		s1.setErosketa_data(fecha);
		assertEquals(s1.getID_sarrera(), id);
		assertEquals(s1.getErosketa_data(), fecha);
	}
	@Test
	void testToString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		ordua.setHoras(11);
		ordua.setMinutos(56);
		Sarrera s1 = new Sarrera(id, fecha);
		assertEquals(s1.toString(), "Sarrera [ID_sarrera=" + id + ", erosketa_data=" + fecha + "]");
	}
	@Test
	void testEquals() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		ordua.setHoras(11);
		ordua.setMinutos(56);
		Sarrera s1 = new Sarrera();
		Sarrera s2 = new Sarrera();
		s2.setID_sarrera(id);
		s1.setID_sarrera(id);
		s1.setErosketa_data(fecha);
		assertTrue(s1.equals(s2));
	}

}
