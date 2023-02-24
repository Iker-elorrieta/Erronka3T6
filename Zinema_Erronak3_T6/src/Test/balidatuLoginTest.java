package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controlador.metodoak;
import Modelo.Bezero;

class balidatuLoginTest {
	
		@Test
		public void testBalidatuLogin() {
			
			//Creamos un array de objetos Bezero para probar el método balidatuLogin
			Bezero[] b1 = new Bezero[2];
			b1[0] = new Bezero();
			b1[1] = new Bezero();
			
			b1[0].setDNI("12345678A");
			b1[0].setPasahitza("1234");
			
			b1[1].setDNI("87654321B");
			b1[1].setPasahitza("5678");
			
			//Prueba 1: credenciales correctas
			assertTrue(metodoak.balidatuLogin("12345678A", "1234", b1));
			
			//Prueba 2: usuario incorrecto
			assertFalse(metodoak.balidatuLogin("11111111A", "1234", b1));
			
			//Prueba 3: contraseña incorrecta
			assertFalse(metodoak.balidatuLogin("12345678A", "4321", b1));
			
			//Prueba 4: usuario y contraseña incorrectos
			assertFalse(metodoak.balidatuLogin("11111111A", "4321", b1));
		}
	}



