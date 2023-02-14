package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Controlador.metodoak;
import Modelo.Areto;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Zinema;

class filmErakutsiTest {
	
	Film f1 = new Film();
	Zinema z1 = new Zinema();
	Areto [] a1 = new Areto[2];
	Saioa [] s1 = new Saioa[2];
	String[] filmAukerak = new String[1];
	int ID_film = 1;
	String tituloa = "Handia";
	int iraupena = 110;
	String generoa = "Drama";
	double prezioa = 7.5;
	LocalTime ordua = null;
	LocalTime buk_ordua = null;
	int ID_saioa = 1;
	Date data = null;
	int ID_areto = 1;
	int zenbakia = 1;
	int ID_zinema = 1;
	String izena = "Golem";
	String lokalitatea = "Bilbao";
	
	

	@Test
	void FilmErakutsiTest() {
		f1.setGeneroa(generoa);
		f1.setID_film(ID_film);
		f1.setIraupena(iraupena);
		f1.setPrezioa(prezioa);
		f1.setTituloa(tituloa);
		
		s1[0] = new Saioa(); 
	    s1[0].setID_saioa(ID_saioa);
	    s1[0].setBuk_ordua(buk_ordua);
	    s1[0].setData(data);
	    s1[0].setFilma(f1);
	    s1[0].setOrdua(ordua);

	    s1[1] = new Saioa(); 
	    s1[1].setBuk_ordua(buk_ordua);
	    s1[1].setData(data);
	    s1[1].setFilma(f1);
	    s1[1].setID_saioa(ID_saioa+1);
	    s1[1].setOrdua(ordua);

	    a1[0] = new Areto();
	    a1[0].setID_areto(ID_areto);
	    a1[0].setZenbakia(zenbakia);
	    a1[0].setSaioak(s1);

	    a1[1] = new Areto();
	    a1[1].setID_areto(ID_areto+1);
	    a1[1].setZenbakia(zenbakia);
	    a1[1].setSaioak(s1);
	    
		z1.setAretoak(a1);
		z1.setID_zinema(ID_zinema);
		z1.setIzena(izena);
		z1.setLokalitatea(lokalitatea);
		
		filmAukerak = metodoak.filmErakutsi(z1);
	    String [] esperotakoa = new String [1];
	    esperotakoa [0] = "Handia";
	    assertArrayEquals(filmAukerak, esperotakoa);
		
	}

}
