package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Sarrera {
	LocalDateTime locaDate = LocalDateTime.now();
	private int ID_sarrera;
	private Date erosketa_data;
	private int salneurria;
	private Saioa [] Saioa;
	private Bezero Bezero;
	
	public Sarrera () {
		this.ID_sarrera = 0;
		this.erosketa_data = null;
		this.salneurria = 0;
		this.Saioa = null;
		this.Bezero = null;
	}
	public Sarrera (int id, Date data, int salneurria, Saioa[] saioa, Bezero bezero) {
		this.ID_sarrera = id;
		this.erosketa_data = data;
		this.salneurria = salneurria;
		this.Saioa = saioa;
		this.Bezero = bezero;
	}
	public Bezero getBezero() {
		return Bezero;
	}
	public void setBezero(Bezero bezero) {
		Bezero = bezero;
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
	public Date getErosketa_data() {
		return erosketa_data;
	}
	public void setErosketa_data(Date erosketa_data) {
		this.erosketa_data = erosketa_data;
	}
	
	public int getSalneurria() {
		return salneurria;
	}
	public void setSalneurria(int salneurria) {
		this.salneurria = salneurria;
	}
	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		return "Sarrera [locaDateH=" + locaDate.getHour() + "locaDateM=" + locaDate.getMinute() + ", ID_sarrera=" + ID_sarrera + ", erosketa_data=" + dt.format(erosketa_data)
				+ ", salneurria=" + salneurria + ", Saioa="
				+ Arrays.toString(Saioa) + ", Bezero=" + Bezero+"]";
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
