package Controlador;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

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
	
	public static LocalTime[] orduakLortu (Saioa [] beharSaioa, Date selectedDate) {
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	
	String formattedDate = dt.format(selectedDate);
	LocalTime [] saioOrduak = new LocalTime [0];
	int saioOrduaI= 0;
	
	for (int i = 0; i < beharSaioa.length; i++) {
	 try {
				if (beharSaioa[i].getData().equals(dt.parse(formattedDate))) {
					if(saioOrduaI == saioOrduak.length) {
						LocalTime [] saioOrduaBerria = new LocalTime[saioOrduak.length+1];
						System.arraycopy(saioOrduak, 0, saioOrduaBerria, 0, saioOrduak.length);
						saioOrduak = saioOrduaBerria;
					}
					saioOrduak[saioOrduaI++] = beharSaioa[i].getOrdua();
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	}
	return saioOrduak;
	}
	public static double prezioaLortu (Zinema aukeratutakoZinema, Film aukeratutakoFilm, LocalTime aukeratutakoOrdua, Date aukeratutakoData) {
		Saioa aukeratutakoSaioa = new Saioa();
		for (int i = 0; i < aukeratutakoZinema.getAretoak().length; i++) {
			for (int j = 0; j< aukeratutakoZinema.getAretoak()[i].getSaioak().length; j++) {
				if (aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getTituloa().equals(aukeratutakoFilm.getTituloa())) {
					aukeratutakoSaioa = aukeratutakoZinema.getAretoak()[i].getSaioak()[j];
					if (aukeratutakoSaioa.getOrdua().equals(aukeratutakoOrdua) && aukeratutakoSaioa.getData().equals(aukeratutakoData)) {
						//aretoZbk = aukeratutakoZinema.getAretoak()[i].getZenbakia();
						aukeratutakoFilm.setPrezioa(aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getPrezioa());
					}
					
				}
			}
				
		}
		return aukeratutakoFilm.getPrezioa();
	}
	public static int aretoaLortu (Zinema aukeratutakoZinema, Film aukeratutakoFilm, LocalTime aukeratutakoOrdua, Date aukeratutakoData) {
		Saioa aukeratutakoSaioa = new Saioa();
		int aretoZbk = 0;
		for (int i = 0; i < aukeratutakoZinema.getAretoak().length; i++) {
			for (int j = 0; j< aukeratutakoZinema.getAretoak()[i].getSaioak().length; j++) {
				if (aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getTituloa().equals(aukeratutakoFilm.getTituloa())) {
					aukeratutakoSaioa = aukeratutakoZinema.getAretoak()[i].getSaioak()[j];
					if (aukeratutakoSaioa.getOrdua().equals(aukeratutakoOrdua) && aukeratutakoSaioa.getData().equals(aukeratutakoData)) {
						aretoZbk = aukeratutakoZinema.getAretoak()[i].getZenbakia();
						//aukeratutakoFilm.setPrezioa(aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getPrezioa());
					}
					
				}
			}
				
		}
		return aretoZbk;
	}
	public static LocalTime[] beteSaioOrduak (Saioa[] beharSaioa, Date aukeratutakoData) {
		LocalTime [] saioOrduak = new LocalTime [0];
	int saioOrduaI= 0;
	
	for (int i = 0; i < beharSaioa.length; i++) {
			if (beharSaioa[i].getData().equals(aukeratutakoData)) {
				if(saioOrduaI == saioOrduak.length) {
					LocalTime [] saioOrduaBerria = new LocalTime[saioOrduak.length+1];
					System.arraycopy(saioOrduak, 0, saioOrduaBerria, 0, saioOrduak.length);
					saioOrduak = saioOrduaBerria;
				}
				saioOrduak[saioOrduaI++] = beharSaioa[i].getOrdua();
			}
	}	
	return saioOrduak;
	}

	public static String kalkulatuPrezioTotala (double prezioGuztira, int pelikula_kont) {
		double prezioaD = prezioGuztira;
		String prezioa = "";
		if (pelikula_kont == 1) {
			//Deskontua ez egiteko
			prezioaD = prezioGuztira;
		}
		else if (pelikula_kont == 2) {
			//20% deskontua
			prezioaD = prezioaD * 0.8;
		} else {
			//30% deskontua
			prezioaD = prezioaD * 0.7;
		}
		prezioa = String.valueOf(prezioaD);
		return prezioa;
	}
}
