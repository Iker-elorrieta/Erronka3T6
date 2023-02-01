package Modelo;

import java.util.Arrays;
import java.util.Objects;

public class Film {
	private int ID_film;
	private String tituloa;
	private int iraupena;
	private String generoa;
	private double prezioa;
	private Saioa [] saioak;
	
	public Film () {
		this.ID_film = 0;
		this.tituloa = "";
		this.iraupena = 0;
		this.generoa = "";
		this.prezioa = 0;
	}
	public Film (int ID_film, String tituloa, int iraupena, String generoa, double prezioa, Saioa[] saioak) {
		this.ID_film= ID_film;
		this.tituloa = tituloa;
		this.iraupena = iraupena;
		this.generoa = generoa;
		this.prezioa = prezioa;
		this.saioak = saioak;
	}

	public Saioa[] getSaioak() {
		return saioak;
	}

	public void setSaioak(Saioa[] saioak) {
		this.saioak = saioak;
	}

	public int getID_film() {
		return ID_film;
	}
	public void setID_film(int iD_film) {
		ID_film = iD_film;
	}
	public String getTituloa() {
		return tituloa;
	}
	public void setTituloa(String tituloa) {
		this.tituloa = tituloa;
	}
	public int getIraupena() {
		return iraupena;
	}
	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}
	public String getGeneroa() {
		return generoa;
	}
	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}
	public double getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	
	@Override
	public String toString() {
		return "Film [ID_film=" + ID_film + ", tituloa=" + tituloa + ", iraupena=" + iraupena + ", generoa=" + generoa
				+ ", prezioa=" + prezioa + ", saioak=" + Arrays.toString(saioak) + "]";
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(ID_film);
	}
*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return ID_film == other.ID_film;
	}
	
	
	
}
