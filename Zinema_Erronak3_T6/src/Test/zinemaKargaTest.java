package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Statement;

import Controlador.datuBase;
import Modelo.Areto;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Zinema;

class zinemaKargaTest {
	
	Zinema[] zinemak = new Zinema[0];
	Areto[] aretoak = new Areto[0];
	Saioa[] saioak;
	Film filma = new Film();
	Connection connection = null;

	@Test
	void testZinemakKarga() {
		Zinema[] zinemak = datuBase.ZinemakKarga();
		
		assertNotNull(zinemak);
		assertTrue(zinemak.length > 0);
		
		//Test Zinema
		Zinema zinema = zinemak[0];
		assertNotNull(zinema);
		assertNotNull(zinema.getAretoak());
		assertNotNull(zinema.getIzena());
		assertNotNull(zinema.getLokalitatea());
		assertTrue(zinema.getID_zinema() > 0);
		
		//Test Areto
		Areto areto = zinema.getAretoak()[0];
		assertNotNull(areto);
		assertNotNull(areto.getSaioak());
		assertTrue(areto.getID_areto() > 0);
		assertTrue(areto.getZenbakia() > 0);
		
		//Test Saioa
		Saioa saioa = areto.getSaioak()[0];
		assertNotNull(saioa);
		assertNotNull(saioa.getData());
		assertNotNull(saioa.getFilma());
		assertTrue(saioa.getID_saioa() > 0);
		assertNotNull(saioa.getOrdua());
		assertTrue(saioa.getOrdua().getHour() >= 0 && saioa.getOrdua().getHour() <= 23);
		assertTrue(saioa.getOrdua().getMinute() >= 0 && saioa.getOrdua().getMinute() <= 59);
		
		//Test Film
		Film film = saioa.getFilma();
		assertNotNull(film);
		assertTrue(film.getID_film() > 0);
		assertNotNull(film.getTituloa());
		assertNotNull(film.getGeneroa());
		assertTrue(film.getIraupena() > 0);
		
	}

}
