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

public class aretoaLortuTest {

    @Test
    public void testAretoaLortu() {
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
       
        // Llamamos al método que queremos probar
        int aretoZbk = metodoak.aretoaLortu(z1, f1, s1.getOrdua(), s1.getData());
        
        // Comprobamos que el resultado es el esperado
        assertEquals(1, aretoZbk);
    }
}
