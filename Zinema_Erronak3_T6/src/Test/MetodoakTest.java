package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Controlador.metodoak;
import Modelo.Sarrera;

class MetodoakTest {
	
	@Test
	void beherapena0pelikula () {
		int film_kont=0;
		String esperotakoa= "%"+0.00;
		assertEquals(esperotakoa, metodoak.zenbatBeherapen(film_kont));
		}

	@Test
	void beherapena1pelikula () {
		int film_kont=1;
		String esperotakoa= "%"+0.00;
		assertEquals(esperotakoa, metodoak.zenbatBeherapen(film_kont));
		}
	
	@Test
	void beherapena2pelikula () {
		int film_kont=2;
		String esperotakoa= "%"+20.00;
		assertEquals(esperotakoa, metodoak.zenbatBeherapen(film_kont));
	}
	
	@Test
	void beherapena3pelikula () {
		int film_kont=3;
		String esperotakoa= "%"+30.00;
		assertEquals(esperotakoa, metodoak.zenbatBeherapen(film_kont));
	}
	
	@Test
	void beherapena5pelikula () {
		int film_kont=5;
		String esperotakoa= "%"+30.00;
		assertEquals(esperotakoa, metodoak.zenbatBeherapen(film_kont));
	}
	
	@Test
	void NANzuzena () {
		String nan="37485949C";
		int zenbakiak = 37485949;
		assertEquals(nan, metodoak.letraKalkulatu(zenbakiak));
	}
	
	@Test
	void NANzuzena2 () {
		String nan="12345678Z";
		int zenbakiak = 12345678;
		assertEquals(nan, metodoak.letraKalkulatu(zenbakiak));
	}
	
	@Test
	void NANtxarra () {
		String nan="37485949Z";
		int zenbakiak = 37485949;
		assertNotEquals(nan, metodoak.letraKalkulatu(zenbakiak));
	}
	
	@Test
	void NANda () {
		String nan="12345678Z";
		assertEquals(true, metodoak.NANegiaztatu(nan));
	}
	
	@Test
	void NANda2 () {
		String nan="37485949C";
		assertEquals(true, metodoak.NANegiaztatu(nan));
	}
	
	
	@Test
	void NANezDa () {
		String nan="37285949AA";
		assertEquals(false, metodoak.NANegiaztatu(nan));
	}
	
	@Test
	void pasahitzaZuzena () {
		String pasahitza="Kaka1234";
		assertEquals(true, metodoak.pasahitzaKonprobatu(pasahitza));
	}
	
	@Test
	void pasahitzaLuzeeraTxikia () {
		String pasahitza="Kaka123";
		assertEquals(false, metodoak.pasahitzaKonprobatu(pasahitza));
	}
	@Test
	void pasahitzaLuzeeraHandiegia () {
		String pasahitza="Kaka123Kaka123Kaka123";
		assertEquals(false, metodoak.pasahitzaKonprobatu(pasahitza));
	}
	
	@Test
	void pasahitzaZenbakiGabe () {
		String pasahitza="Kakakaiel";
		assertEquals(false, metodoak.pasahitzaKonprobatu(pasahitza));
	}
	
	@Test
	void pasahitzaMayuskulaGabe () {
		String pasahitza="ajaajaksjka12";
		assertEquals(false, metodoak.pasahitzaKonprobatu(pasahitza));
	}
	
	@Test
	void pasahitzaMinuskukaGabe () {
		String pasahitza="AJHDDHJSE12";
		assertEquals(false, metodoak.pasahitzaKonprobatu(pasahitza));
	}
	
}
