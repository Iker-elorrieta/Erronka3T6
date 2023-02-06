package Controlador;

public class Num {
	/**
	 * Zenbaki bat bikoitia ala bikoitia den
	 * @param zenbaki1 zein zenbaki begiratuko den
	 * @return bikoitia bada true, bestela false
	 * @author Hodei
	 */
	public static boolean bikoitiaDa (int z1) {
		int hondarra = z1%2;
		boolean bikoiti = false;
		if (hondarra == 0)
			bikoiti = true;
		else
			bikoiti = false;
		return bikoiti;
	}
	/**
	 * Bi zenbaki konparatuko ditu eta handiena zein den begiratuko du
	 * @param zenbaki1 zenbaki bat
	 * @param zenbaki2 konparatuko den zenbakia
	 * @return zenbaki1 handiago bada <strong>1</strong>, zenbaki2 handiago bada <strong>2</strong>, berdinak badira <strong>0</strong>
	 * @author Hodei
	 */
	public static int handiagoDa (int zenbaki1, int zenbaki2) {
		int handiago = 0;
		if (zenbaki1 > zenbaki2) {
			handiago = 1;
		}else if (zenbaki1 < zenbaki2) {
			handiago = 2;
		}else {
			handiago = 0;
		}	
		return handiago;
	}
	/**
	 * Zenbaki bat hartuko du eta lehena den ala ez konprobatuko du
	 * @param zenbaki zein zenbaki konprobatu nahi dugun
	 * @return lehena bada true, ez bada false
	 * @author Hodei
	 */
	public static boolean lehena (int zenbaki) {
		int zatitzaile=0;
		boolean lehena = false;
		for(int i=1;i<=zenbaki;i++){
			if(zenbaki%i==0){
				zatitzaile++;
			}
		}
		if(zatitzaile==2){
			lehena = true;
		}
		return lehena;
	}
	
}
