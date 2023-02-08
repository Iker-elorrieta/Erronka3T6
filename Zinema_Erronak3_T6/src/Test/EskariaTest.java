package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Bezero;
import Modelo.Eskaria;

class EskariaTest {
	LocalTime ordua = LocalTime.of(5, 10);
	int id = 1;
	double prezio_totala = 1;
	Date fecha = null;
	Calendar cal = Calendar.getInstance();
	Bezero b1 = new Bezero();

	@Test
	void testGetetaSet() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Eskaria e1 = new Eskaria();
		e1.setId_eskari(id);
		e1.setErosketa_data(fecha);
		e1.setPrezio_totala(prezio_totala);
		e1.setBezeroa(b1);
		e1.setOrdua(ordua);
		assertEquals(e1.getId_eskari(), id);
		assertEquals(e1.getErosketa_data(), fecha);
		assertEquals(e1.getPrezio_totala(), prezio_totala);
		assertEquals(e1.getBezeroa(), b1);
		assertEquals(e1.getOrdua().getHour(), 5);
		assertEquals(e1.getOrdua().getMinute(), 10);
	}
	@Test
	void testToString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Eskaria e1 = new Eskaria (id, fecha, prezio_totala, b1, ordua);
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		assertEquals(e1.toString(), "Eskaria [localDateH=" + ordua + ", id_eskari=" + id + ", prezio_totala=" + prezio_totala
				+ ", erosketa_data=" + dt.format(fecha) + ", bezeroa=" + b1 + "]");
	}
	@Test
	void testEquals() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha = cal.getTime();
		Eskaria e1 = new Eskaria ();
		Eskaria e2 = new Eskaria();
		e2.setId_eskari(id);
		e1.setId_eskari(id);
		e1.setErosketa_data(fecha);
		e1.setPrezio_totala(prezio_totala);
		assertTrue(e1.equals(e2));
		assertFalse(e1.equals(null));
	}

}
