package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controlador.metodoak;

public class prezioTotalaTest {
    
    @Test
    public void testKalkulatuPrezioTotalaDeskontuGabe() {
        double prezioGuztira = 10.0;
        int pelikula_kont = 1;
        String expected = "10.0";
        String result = metodoak.kalkulatuPrezioTotala(prezioGuztira, pelikula_kont);
        assertEquals(expected, result);
    }
    
    @Test
    public void testKalkulatuPrezioTotalaEhuneko20() {
        double prezioGuztira = 10.0;
        int pelikula_kont = 2;
        String expected = "8.0";
        String result = metodoak.kalkulatuPrezioTotala(prezioGuztira, pelikula_kont);
        assertEquals(expected, result);
    }
    
    @Test
    public void testKalkulatuPrezioTotalaEhuneko30() {
        double prezioGuztira = 10.0;
        int pelikula_kont = 3;
        String expected = "7.0";
        String result = metodoak.kalkulatuPrezioTotala(prezioGuztira, pelikula_kont);
        assertEquals(expected, result);
    }
}
