package Modelo;

import java.util.Arrays;
import java.util.Objects;

public class Zinema {
	private int ID_zinema;
	private String izena;
	private String lokalitatea;
	private Areto [] aretoak;
	
	public Zinema () {
		this.ID_zinema = 0;
		this.izena = "";
		this.lokalitatea = "";
	}
	public Zinema (int ID_zinema, String izena, String lokalitatea, Areto[] aretoak) {
		this.ID_zinema = ID_zinema;
		this.izena = izena;
		this.lokalitatea = lokalitatea;
		this.aretoak = aretoak;
	}
	
	public Areto[] getAretoak() {
		return aretoak;
	}

	public void setAretoak(Areto[] aretoak) {
		this.aretoak = aretoak;
	}

	public int getID_zinema() {
		return ID_zinema;
	}
	public void setID_zinema(int iD_zinema) {
		ID_zinema = iD_zinema;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getLokalitatea() {
		return lokalitatea;
	}
	public void setLokalitatea(String lokalitatea) {
		this.lokalitatea = lokalitatea;
	}
	
	@Override
	public String toString() {
		return "Zinema [ID_zinema=" + ID_zinema + ", izena=" + izena + ", lokalitatea=" + lokalitatea + ", aretoak="
				+ Arrays.toString(aretoak) + "]";
	}
	
	/*@Override
	public int hashCode() {
		return Objects.hash(ID_zinema);
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zinema other = (Zinema) obj;
		return ID_zinema == other.ID_zinema;
	}
}
