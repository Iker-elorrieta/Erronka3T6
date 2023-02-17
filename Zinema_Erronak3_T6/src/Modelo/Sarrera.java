package Modelo;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Sarrera {
	private int ID_sarrera;
	private LocalTime ordua;
	private Date data;
	private Saioa [] Saioa;
	private Eskaria [] Eskariak;
	
	public LocalTime getOrdua() {
		return ordua;
	}
	public void setOrdua(LocalTime ordua) {
		this.ordua = ordua;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Sarrera () {
		this.ID_sarrera = 0;
		this.Saioa = null;
		this.Eskariak = null;
	}
	public Sarrera (int id, Date data, LocalTime ordua, Saioa[] saioa, Eskaria [] eskaria) {
		this.ID_sarrera = id;
		this.data = data;
		this.ordua = ordua;
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
		return "Sarrera [ID_sarrera=" + ID_sarrera + ", ordua=" + ordua + ", data=" + data + ", Saioa="
				+ Arrays.toString(Saioa) + ", Eskariak=" + Arrays.toString(Eskariak) + "]";
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
