package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import Modelo.Eskaria;
import Modelo.Saioa;
import Modelo.Sarrera;

class SarreraTest {
	LocalDateTime locaDate = LocalDateTime.now();
	int id = 1;
	Saioa [] sa1 = new Saioa[1];
	Eskaria [] e1 = new Eskaria[1];
	

	@Test
	void testGetetaSet() {
		Sarrera s1 = new Sarrera();
		s1.setID_sarrera(id);
		s1.setSaioa(sa1);
		s1.setEskariak(e1);
		assertEquals(s1.getID_sarrera(), id);
		assertEquals(s1.getSaioa(), sa1);
		assertEquals(s1.getEskariak(), e1);
		
	}
	@Test
	void testToString() {
		Sarrera s1 = new Sarrera(id, sa1, e1);
		assertEquals(s1.toString(), "Sarrera [ID_sarrera=" + id + ", Saioa=" + Arrays.toString(sa1) + ", Eskariak="
				+ Arrays.toString(e1) + "]");
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
