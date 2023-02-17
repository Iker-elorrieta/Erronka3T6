package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Eskaria;
import Modelo.Saioa;
import Modelo.Sarrera;

class SarreraTest {
	LocalDateTime locaDate = LocalDateTime.now();
	int id = 1;
	LocalTime ordua = LocalTime.of(5, 10);
	Date data = null;
	Calendar cal = Calendar.getInstance();	
	Saioa [] sa1 = new Saioa[1];
	Eskaria [] e1 = new Eskaria[1];
	

	@Test
	void testGetetaSet() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		data = cal.getTime();
		Sarrera s1 = new Sarrera();
		s1.setID_sarrera(id);
		s1.setOrdua(ordua);
		s1.setData(data);
		s1.setSaioa(sa1);
		s1.setEskariak(e1);
		assertEquals(s1.getID_sarrera(), id);
		assertEquals(s1.getData(), data);
		assertEquals(s1.getOrdua(), ordua);
		assertEquals(s1.getSaioa(), sa1);
		assertEquals(s1.getEskariak(), e1);
		
	}
	@Test
	void testToString() {
		Sarrera s1 = new Sarrera(id, data, ordua, sa1, e1);
		assertEquals(s1.toString(), "Sarrera [ID_sarrera=" + id + ", ordua=" + ordua + ", data=" + data + ", Saioa="
				+ Arrays.toString(sa1) + ", Eskariak=" + Arrays.toString(e1) + "]");
	}
	@Test
	void testEquals() {
		Sarrera s1 = new Sarrera();
		Sarrera s2 = new Sarrera();
		s2.setID_sarrera(id);
		s1.setID_sarrera(id);
		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(null));
	}

}
