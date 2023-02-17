package Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.Date;

import org.junit.Test;

import Controlador.metodoak;
import Modelo.Areto;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Zinema;

public class prezioaLortuTest {

    @Test
    public void testPrezioaLortu() {
        // Creamos un zinema con algunas salas y sesiones
        Zinema z1 = new Zinema();
        Areto a1 = new Areto();
        Saioa s1 = new Saioa();
        Film f1 = new Film();
        Saioa s2 = new Saioa();
        
        f1.setID_film(1);
        f1.setTituloa("Handia");
        f1.setPrezioa(7.5);
        
        a1.setID_areto(1);
        a1.setZenbakia(1);
        
        s1.setID_saioa(1);
        s1.setData(new Date());
        s1.setOrdua(LocalTime.of(16, 0));
        s1.setFilma(f1);
       
        s2.setID_saioa(2);
        s2.setData(new Date());
        s2.setOrdua(LocalTime.of(18, 0));
        s2.setFilma(f1);
        a1.setSaioak(new Saioa[] {s1, s2});
        z1.setAretoak(new Areto[] {a1});

        // konprobaketa
        double prezioa = metodoak.prezioaLortu(z1, f1, LocalTime.of(16, 0), new Date());
        assertEquals(7.5, prezioa, 0.01);

    }
}
