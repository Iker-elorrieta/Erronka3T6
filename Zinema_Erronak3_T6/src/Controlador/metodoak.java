package Controlador;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Modelo.Film;
import Modelo.Saioa;
import Modelo.Zinema;

public class metodoak {

	/**
	 * Segun eta zenbat pelikula aukeratu ditugun beherapen portzentailak aldatuko dira.
	 * // 1 pelikula %0 // 2 pelikula %20 // >=3 pelikula %30
	 * @param pelikula_kopurua, zenbat pelikula aukeratu dituen (int)
	 * @return Lortuko dugun beherapena
	 */
	public static String zenbatBeherapen (int pelikula_kopurua) {
		double beherapena =0;
		if(pelikula_kopurua<=1) {
			beherapena=0;
		}else if(pelikula_kopurua==2) {
			beherapena=20;
		}else {
			beherapena=30;
		}
		return "%" + beherapena;
	}
	
	/**
	 * NAN oso bat pasatuko diogu metodoari, metodo honek deituko dio letraKalkulatu metodoari eta konprobatuko du ea
	 * berdinak diren guk pasatuko NAN-a eta metodoarekin kalkulatutako NAN-a.
	 * @param NAN_osoa (String)
	 * @return True bueltatuko digu NAN-a ondo badago sartuta eta false ez badago zuzen sartuta.
	 */
	public static boolean NANegiaztatu(String NAN_osoa) {
	    int NAN = Integer.parseInt(NAN_osoa.substring(0, 8));
	    String dniKalkulatuta = letraKalkulatu(NAN);
	    return dniKalkulatuta.equals(NAN_osoa);
	}

	/**
	 * Nan bat pasatuko dio metodoari, eta metodoa NANaren letra lortuko du.
	 * @param NAN, nan bat pasatuko zaio letra gabe (int)
	 * @return NAN osoa bueltatuko digu, hau da, zenbakiak eta letra
	 */
	public static String letraKalkulatu(int NAN) {
	    String letrak = "TRWAGMYFPDXBNJZSQVHLCKE";
	    char letra =letrak.charAt(NAN % 23);
	    String nan_osoa = String.valueOf(NAN) + letra;
	    return nan_osoa;
	}

	/**
	 * Strint bat pasatuko diogu metodoari, pasahitza izango dela. Metodoa egingo duena izango da 
	 * konprobatu eta betetzen baditu baldintza batzuk gure pasahitza segurua izateko.
	 * @param pasahitza (String)
	 * @return True bueltatuko digu, pasahitza zuzena bada. Pasahitza ez bada zuzen false bueltatuko digu.
	 */
	public static boolean pasahitzaKonprobatu(String pasahitza) {
	    int minLuzera = 8;
	    int maxLuzera = 20;
	    boolean mayuskulaDauka = false;
	    boolean minuskulaDauka = false;
	    boolean zenbakiakDauka = false;
	    
	    if (pasahitza.length() >= minLuzera && pasahitza.length() <= maxLuzera) {
	        for (char c : pasahitza.toCharArray()) {
	            if (Character.isLowerCase(c)) {
	            	minuskulaDauka = true;
	            } else if (Character.isUpperCase(c)) {
	            	mayuskulaDauka = true;
	            } else if (Character.isDigit(c)) {
	            	zenbakiakDauka = true;
	            }
	        }
	    }
	    return minuskulaDauka && mayuskulaDauka && zenbakiakDauka;
	}
	
	/**
	 * 
	 * @param aukeratutakoZinema
	 * @return Zinema horretan dauden saioetako filmak bueltatuko ditu errepikatu gabe.
	 */
	public static String[] filmErakutsi (Zinema aukeratutakoZinema) {

		String[] filmGordeta = new String[0];
		int filmGordetaI = 0;
		for (int i = 0; i < aukeratutakoZinema.getAretoak().length; i++) {
			for (int j = 0; j < aukeratutakoZinema.getAretoak()[i].getSaioak().length; j++) {
				String titulo = aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getTituloa();
				boolean bilatuta = false;
				for (int k = 0; k < filmGordetaI; k++) {
					if (filmGordeta[k].equals(titulo)) {
						bilatuta = true;
						//break;
					}
				}
				if (!bilatuta) {
					//filmGordeta array-a berridazten du
					if (filmGordetaI == filmGordeta.length) {
						String[] filmGordetaBerria = new String[filmGordeta.length+1];
						System.arraycopy(filmGordeta, 0, filmGordetaBerria, 0, filmGordeta.length);
						filmGordeta = filmGordetaBerria;
					}
					filmGordeta[filmGordetaI++] = titulo;
				}
			}
		}
		return filmGordeta;
	}
	public static Saioa[] saioakBete (Zinema aukeratutakoZinema, Film aukeratutakoFilm) {
		Saioa[] beharSaioa = new Saioa [0];
		int beharSaioaI = 0;
		for (int i = 0; i < aukeratutakoZinema.getAretoak().length; i++) {
			for (int j = 0; j < aukeratutakoZinema.getAretoak()[i].getSaioak().length; j++) {
				if (aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getTituloa().equals(aukeratutakoFilm.getTituloa())) {
		        	
					//aukeratutakoZinema.getAretoak()[i].getSaioak()[j]
		        	//Gehitu saio bat gure saioko array-an
					
					if (beharSaioaI == beharSaioa.length) {
						Saioa[] beharSaioaBerria = new Saioa[beharSaioa.length+1];
						System.arraycopy(beharSaioa, 0, beharSaioaBerria, 0, beharSaioa.length);
						beharSaioa = beharSaioaBerria;
					}
					beharSaioa[beharSaioaI++] = aukeratutakoZinema.getAretoak()[i].getSaioak()[j];
					}
				}
			}
		
		return beharSaioa;
	}
	
	public static Saioa[] saioakBete (Zinema aukeratutakoZinema, String aukeratutakoFilm) {
		Saioa[] beharSaioa = new Saioa [0];
		int beharSaioaI = 0;
		for (int i = 0; i < aukeratutakoZinema.getAretoak().length; i++) {
			for (int j = 0; j < aukeratutakoZinema.getAretoak()[i].getSaioak().length; j++) {
				if (aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getTituloa().equals(aukeratutakoFilm)) {
		        	
					//aukeratutakoZinema.getAretoak()[i].getSaioak()[j]
		        	//Gehitu saio bat gure saioko array-an
					
					if (beharSaioaI == beharSaioa.length) {
						Saioa[] beharSaioaBerria = new Saioa[beharSaioa.length+1];
						System.arraycopy(beharSaioa, 0, beharSaioaBerria, 0, beharSaioa.length);
						beharSaioa = beharSaioaBerria;
					}
					beharSaioa[beharSaioaI++] = aukeratutakoZinema.getAretoak()[i].getSaioak()[j];
					}
				}
			}
		
		return beharSaioa;
	}

}
