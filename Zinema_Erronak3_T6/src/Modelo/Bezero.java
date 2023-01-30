package Modelo;

public class Bezero {
	private String DNI;
	private String izena;
	private String abizen_1;
	private String abizen_2;
	private boolean sexua;
	private String pasahitza;
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizen_1() {
		return abizen_1;
	}
	public void setAbizen_1(String abizen_1) {
		this.abizen_1 = abizen_1;
	}
	public String getAbizen_2() {
		return abizen_2;
	}
	public void setAbizen_2(String abizen_2) {
		this.abizen_2 = abizen_2;
	}
	public boolean isSexua() {
		return sexua;
	}
	public void setSexua(boolean sexua) {
		this.sexua = sexua;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

}
