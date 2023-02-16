package Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import org.junit.Test;
import Controlador.metodoak;
import Modelo.Film;
import Modelo.Saioa;
public class orduakLortuTest {
	@Test
	public void testOrduakLortu() throws ParseException {
		int id = 1;
		Film f1 = new Film();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = dateFormat.parse("2023-02-16");
		Date fecha2 = dateFormat.parse("2023-02-17");
		LocalTime ordua1 = LocalTime.of(10, 0);
		LocalTime ordua2 = LocalTime.of(12, 0);
		LocalTime ordua3 = LocalTime.of(11, 0);
		LocalTime buk_ordua = LocalTime.of(10, 25);
		Saioa s1 = new Saioa();
		Saioa s2 = new Saioa();
		Saioa s3 = new Saioa();
		s1.setBuk_ordua(buk_ordua);
		s1.setData(fecha);
		s1.setFilma(f1);
		s1.setID_saioa(id);
		s1.setOrdua(ordua1);
		s2.setBuk_ordua(buk_ordua);
		s2.setData(fecha);
		s2.setFilma(f1);
		s2.setID_saioa(id);
		s2.setOrdua(ordua2);
		s3.setBuk_ordua(buk_ordua);
		s3.setData(fecha2);
		s3.setFilma(f1);
		s3.setID_saioa(id);
		s3.setOrdua(ordua3);
		Saioa[] saioak = {s1, s2, s3};
		
		
		Date selectedDate = dateFormat.parse("2023-02-16");
		
		LocalTime[] saioOrduak = metodoak.orduakLortu(saioak, selectedDate);
		
		assertEquals(2, saioOrduak.length);
		assertEquals(LocalTime.of(10, 0), saioOrduak[0]);
		assertEquals(LocalTime.of(12, 0), saioOrduak[1]);
	}
}
