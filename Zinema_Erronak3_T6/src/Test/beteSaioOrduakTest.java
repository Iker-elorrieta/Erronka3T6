package Test;

import java.time.LocalTime;
import java.util.Date;
import org.junit.Test;

import Controlador.metodoak;
import Modelo.Film;
import Modelo.Saioa;

import static org.junit.Assert.*;

public class beteSaioOrduakTest {

    @Test
    public void testBeteSaioOrduak() {
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
       
		int ID_saioa = 1;
		Date data = new Date();
		LocalTime ordua1 = LocalTime.of(10, 0);
		LocalTime ordua2 = LocalTime.of(12, 0);
		LocalTime ordua3 = LocalTime.of(16, 0);
		LocalTime buk_ordua = null;
        Saioa[] s1 = new Saioa[3];
        
        s1[0] = new Saioa();
        s1[0].setBuk_ordua(buk_ordua);
        s1[0].setData(data);
        s1[0].setFilma(f1);
        s1[0].setID_saioa(ID_saioa);
        s1[0].setOrdua(ordua1);

        s1[1] = new Saioa();
        s1[1].setBuk_ordua(buk_ordua);
        s1[1].setData(data);
        s1[1].setFilma(f1);
        s1[1].setID_saioa(ID_saioa);
        s1[1].setOrdua(ordua2);
        
        s1[2] = new Saioa();
        s1[2].setBuk_ordua(buk_ordua);
        s1[2].setData(data);
        s1[2].setFilma(f1);
        s1[2].setID_saioa(ID_saioa);
        s1[2].setOrdua(ordua3);
        // Metodoa Frogatu
        LocalTime[] o1 = metodoak.beteSaioOrduak(s1, data);
        
        //Konprobaketak
        assertEquals(3, o1.length);
        assertEquals(LocalTime.of(10, 0), o1[0]);
        assertEquals(LocalTime.of(12, 0), o1[1]);
        assertEquals(LocalTime.of(16, 0), o1[2]);
    }
}