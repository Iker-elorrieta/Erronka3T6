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
	private int ordua;
	private int minutua;
	private int salneurria;
	private Film[] filma;
	
	public Sarrera () {
		this.ID_sarrera = 0;
		this.erosketa_data = null;
		this.ordua = locaDate.getHour();
		this.minutua = locaDate.getMinute();
		this.filma = null;
	}
	public Sarrera (int id, Date data, int salneurria, Film[] filma) {
		this.ID_sarrera = id;
		this.erosketa_data = data;
		this.ordua = locaDate.getHour();
		this.minutua = locaDate.getMinute();
		this.salneurria = salneurria;
		this.filma = filma;
	}
	
	public int getOrdua() {
		return ordua;
	}
	public void setOrdua(int ordua) {
		this.ordua = ordua;
	}
	public int getMinutua() {
		return minutua;
	}
	public void setMinutua(int minutua) {
		this.minutua = minutua;
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
	public Film[] getFilma() {
		return filma;
	}
	public void setFilma(Film[] filma) {
		this.filma = filma;
	}
	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		return "Sarrera [ID_sarrera=" + ID_sarrera + ", erosketa_data=" + dt.format(erosketa_data) + ", ordua=" + ordua
				+ ", minutua=" + minutua + ", salneurria=" + salneurria + ", filma=" + Arrays.toString(filma) + "]";
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
