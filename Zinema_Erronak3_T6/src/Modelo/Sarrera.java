package Modelo;

import java.util.Arrays;
import java.util.Objects;

public class Sarrera {
	private int ID_sarrera;
	private Saioa [] Saioa;
	private Eskaria [] Eskariak;
	
	public Sarrera () {
		this.ID_sarrera = 0;
		this.Saioa = null;
		this.Eskariak = null;
	}
	public Sarrera (int id, Saioa[] saioa, Eskaria [] eskaria) {
		this.ID_sarrera = id;
		this.Saioa = saioa;
		this.Eskariak = eskaria;
	}
	public Saioa[] getSaioa() {
		return Saioa;
	}
	public void setSaioa(Saioa[] saioa) {
		Saioa = saioa;
	}
	public int getID_sarrera() {
		return ID_sarrera;
	}
	public void setID_sarrera(int iD_sarrera) {
		ID_sarrera = iD_sarrera;
	}
	public Eskaria[] getEskariak() {
		return Eskariak;
	}
	public void setEskariak(Eskaria[] eskariak) {
		Eskariak = eskariak;
	}
	@Override
	public String toString() {
		return "Sarrera [ID_sarrera=" + ID_sarrera + ", Saioa=" + Arrays.toString(Saioa) + ", Eskariak="
				+ Arrays.toString(Eskariak) + "]";
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(ID_sarrera);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Sarrera other = (Sarrera) obj;
		return Objects.equals(ID_sarrera, other.ID_sarrera);
	}
	
}
