package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Hora;
import Modelo.Saioa;
import Modelo.Sarrera;

class SaioaTest {
	
	int id = 1;
	Date fecha = null;
	Hora ordua = new Hora();
	Calendar cal = Calendar.getInstance();
	Sarrera [] sar1 = new Sarrera [1];
	
	
	
	@Test
	void testGetetaSet() {
		
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		ordua.setHoras(11);
		ordua.setMinutos(56);
		Saioa s1 = new Saioa ();
		s1.setData(fecha);
		s1.setID_saioa(id);
		s1.setOrdua(ordua);
		s1.setSarrerak(sar1);
		
		assertEquals(s1.getID_saioa(), id);
		assertEquals(s1.getData(), fecha);
		assertEquals(s1.getOrdua().getHoras(), 11);
		assertEquals(s1.getOrdua().getMinutos(), 56);
		assertEquals(s1.getSarrerak(), sar1);
	}
	@Test
	void testToString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		ordua.setHoras(11);
		ordua.setMinutos(56);
		Saioa s1 = new Saioa(id, fecha, ordua, sar1);
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		assertEquals(s1.toString(), "Saioa [ID_saioa=" + id + ", data=" + dt.format(fecha) + ", ordua=" + ordua + ", sarrerak=" + Arrays.toString(sar1) + "]");
	}
	@Test
	void testEquals() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		ordua.setHoras(11);
		ordua.setMinutos(56);
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
