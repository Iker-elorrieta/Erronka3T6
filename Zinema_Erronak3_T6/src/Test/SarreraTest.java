package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Bezero;
import Modelo.Saioa;
import Modelo.Sarrera;

class SarreraTest {
	LocalDateTime locaDate = LocalDateTime.now();
	int id = 1;
	Date fecha = null;
	int ordua  = locaDate.getHour();
	int minutua = locaDate.getMinute();
	Calendar cal = Calendar.getInstance();
	int salneurria = 2;

	Saioa [] sa1 = new Saioa[1];
	Bezero b1 = new Bezero();
	

	@Test
	void testGetetaSet() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Sarrera s1 = new Sarrera();
		s1.setID_sarrera(id);
		s1.setErosketa_data(fecha);
		s1.setSalneurria(salneurria);
		s1.setSaioa(sa1);
		s1.setBezero(b1);
		assertEquals(s1.getID_sarrera(), id);
		assertEquals(s1.getErosketa_data(), fecha);
		assertEquals(s1.getSalneurria(), salneurria);
		assertEquals(s1.getSaioa(), sa1);
		assertEquals(s1.getBezero(), b1);
		
	}
	@Test
	void testToString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Sarrera s1 = new Sarrera(id, fecha, 2, sa1, b1);
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		assertEquals(s1.toString(), "Sarrera [locaDateH=" + locaDate.getHour() + "locaDateM=" + locaDate.getMinute() + ", ID_sarrera=" + id + ", erosketa_data=" + dt.format(fecha)
		+ ", salneurria=" + salneurria + ", Saioa="
		+ Arrays.toString(sa1) + ", Bezero=" + b1+"]");
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
