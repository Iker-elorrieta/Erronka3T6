package Controlador;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class WindowBuilderMetodoak {

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
	public static void btn3secDelay (JPanel erakutsi,int segundu, JPanel ongiEtorri,JPanel zinemaAreto,JPanel pelikulak,JPanel pelikulakData,JPanel laburpena, JPanel login, JPanel erregistratu, JPanel tiket, JPanel bukaera, ActionEvent e) {
        try {
            Thread.sleep(segundu * 1000);
            } catch (InterruptedException ex) {
                System.out.println(e);
            }
		
        WindowBuilderMetodoak.hurrengoaBtn(erakutsi, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
		
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
	 * Pasatzen ditugun botoia eta comboBox-a erakutsi eta aktibatu pantailan
	 * @param boton, aktibatuko eta erakutsi den botoia (JButton)
	 * @param comboBox, aktibatuko eta erakutsi den comboBoxa (JComboBox)
	 */
	public static void erakutsi (JButton boton, JComboBox comboBox) {
		boton.setEnabled(true);    
		comboBox.setEnabled(true);    
		comboBox.setVisible(true);    
	}
	
	/**
	 * Pasatzen ditugun botoia eta comboBox-a ezkutatu eta desaktibatu pantailan
	 * @param boton, desaktibatu eta ezkutatu den botoia (JButton)
	 * @param comboBox, desaktibatu eta ezkutatu den comboBoxa (JComboBox)
	 */
	public static void ezkutatu (JButton boton, JComboBox comboBox) {
		boton.setEnabled(false);    
		comboBox.setEnabled(false);    
		comboBox.setVisible(false);	
		}
	
	
}
