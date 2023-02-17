package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Controlador.metodoak;
import Modelo.Areto;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Zinema;

public class beteSaioaTest {

	@Test
	void testSaioakBete() {
		// Aldagaiak sortu
		Film f1 = new Film();
		int ID_film = 1;
		String tituloa = "Handia";
		int iraupena = 110;
		String generoa = "Drama";
		double prezioa = 7.5;
		f1.setID_film(ID_film);
		f1.setTituloa(tituloa);
		f1.setIraupena(iraupena);
		f1.setGeneroa(generoa);
		f1.setPrezioa(prezioa);

		Saioa[] s1 = new Saioa[2];
		int ID_saioa = 1;
		Date data = null;
		LocalTime ordua = null;
		LocalTime buk_ordua = null;

		s1[0] = new Saioa();
		s1[0].setID_saioa(ID_saioa);
		s1[0].setData(data);
		s1[0].setOrdua(ordua);
		s1[0].setBuk_ordua(buk_ordua);
		s1[0].setFilma(f1);

		s1[1] = new Saioa();
		s1[1].setID_saioa(ID_saioa+1);
		s1[1].setData(data);
		s1[1].setOrdua(ordua);
		s1[1].setBuk_ordua(buk_ordua);
		s1[1].setFilma(f1);

		Areto[] a1 = new Areto[2];
		int ID_areto = 1;
		int zenbakia = 1;

		a1[0] = new Areto();
		a1[0].setID_areto(ID_areto);
		a1[0].setZenbakia(zenbakia);
		a1[0].setSaioak(s1);

		a1[1] = new Areto();
		a1[1].setID_areto(ID_areto+1);
		a1[1].setZenbakia(zenbakia);
		a1[1].setSaioak(s1);

		Zinema z1 = new Zinema();
		int ID_zinema = 1;
		String izena = "Golem";
		String lokalitatea = "Bilbao";

		z1.setID_zinema(ID_zinema);
		z1.setIzena(izena);
		z1.setLokalitatea(lokalitatea);
		z1.setAretoak(a1);
		
		// Metodoari deiketa
		Saioa[] beharSaioa = metodoak.saioakBete(z1, tituloa);
		Saioa[] esperotakoa = new Saioa[4];
		esperotakoa[0] = s1[0];
		esperotakoa[1] = s1[1];
		esperotakoa[2] = s1[0];
		esperotakoa[3] = s1[1];
		
		// Konprobaketak
		assertArrayEquals(beharSaioa, esperotakoa);
	}

	@Test
	public void testSaioakBeteondo() {
		// Aldagaiak sortu
		Film f1 = new Film();
		Zinema z1 = new Zinema();
		Areto[] a1 = new Areto[2];
		Saioa[] s1 = new Saioa[2];
		Saioa[] s2 = new Saioa[1];
		
		f1.setID_film(1);
		f1.setTituloa("Handia");
		
		a1[0] = new Areto();
		a1[0].setID_areto(1);
		a1[0].setZenbakia(1);
		
		s1[0] = new Saioa();
		s1[0].setID_saioa(1);
		s1[0].setData(new Date());
		s1[0].setOrdua(LocalTime.of(10, 0));
		s1[0].setBuk_ordua(LocalTime.of(12, 0));
		s1[0].setFilma(f1);
		s1[1] = new Saioa();
		s1[1].setID_saioa(2);
		s1[1].setData(new Date());
		s1[1].setOrdua(LocalTime.of(14, 0));
		s1[1].setBuk_ordua(LocalTime.of(16, 0));
		s1[1].setFilma(f1);
		
		a1[0].setSaioak(s1);
		a1[1] = new Areto();
		a1[1].setID_areto(2);
		a1[1].setZenbakia(2);
		
		s2[0] = new Saioa();
		s2[0].setID_saioa(3);
		s2[0].setData(new Date());
		s2[0].setOrdua(LocalTime.of(18, 0));
		s2[0].setBuk_ordua(LocalTime.of(20, 0));
		s2[0].setFilma(f1);
		
		a1[1].setSaioak(s2);
		
		z1.setAretoak(a1);

		// Metodoari deiketa
		Saioa[] saioak = metodoak.saioakBete(z1, f1);

		// Konprobaketak
		assertEquals(3, saioak.length);
		assertArrayEquals(s1, new Saioa[] {saioak[0], saioak[1]});
		assertEquals(s2[0], saioak[2]);
	}		
}
