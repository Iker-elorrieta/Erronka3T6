package Controlador;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class Lehioak {

	/**
	 * 
	 * @param erakutsi, erakutsiko den panela
	 * @param ongiEtorri, ongiEtorri panela
	 * @param zinemaAreto, zinemaAreto panela
	 * @param pelikulak, pelikulak panela
	 * @param pelikulakData, pelikulakData panela
	 * @param laburpena, laburpena panela
	 * @param login, login panela
	 * @param erregistratu, erregistratu panela
	 * @param tiket, tiket panela
	 * @param bukaera, bukaera panela
	 * @param e, error
	 */
	public static void btn3secDelay (JPanel erakutsi, JPanel ongiEtorri,JPanel zinemaAreto,JPanel pelikulak,JPanel pelikulakData,JPanel laburpena, JPanel login, JPanel erregistratu, JPanel tiket, JPanel bukaera, ActionEvent e) {
        try {
            Thread.sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        Lehioak.hurrengoaBtn(erakutsi, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
		
	}
	
	/**
	 * 
	 * @param erakutsi
	 * @param ongiEtorri
	 * @param zinemaAreto
	 * @param pelikulak
	 * @param pelikulakData
	 * @param laburpena
	 * @param login
	 * @param erregistratu
	 * @param tiket
	 * @param bukaera
	 */
	public static void hurrengoaBtn (JPanel erakutsi, JPanel ongiEtorri,JPanel zinemaAreto,JPanel pelikulak,JPanel pelikulakData,JPanel laburpena, JPanel login, JPanel erregistratu, JPanel tiket, JPanel bukaera) {
		
		ongiEtorri.setVisible(false);
		zinemaAreto.setVisible(false);
		pelikulak.setVisible(false);
		pelikulakData.setVisible(false);
		laburpena.setVisible(false);
		login.setVisible(false);
		erregistratu.setVisible(false);
		tiket.setVisible(false);
		bukaera.setVisible(false);
		erakutsi.setVisible(true);
		
	}
	
	
	/**
	 * 
	 * @param NAN, nan oso bat 
	 * @return
	 */
	public static boolean NAN(String NAN) {
	    if (NAN.length() != 9) {
	        return false;
	    }
	    int zbk = Integer.parseInt(NAN.substring(0, 8));
	    char letra = NAN.charAt(8);
	    return (letra == letraKalkulatu(zbk));
	}
	
	/**
	 * 
	 * @param NAN, nan bat pasatuko zaio letra gabe
	 * @return NAN-aren letra bueltatuko du
	 */
	public static char letraKalkulatu(int NAN) {
	    String letrak = "TRWAGMYFPDXBNJZSQVHLCKE";
	    return letrak.charAt(NAN % 23);
	}
	
}
