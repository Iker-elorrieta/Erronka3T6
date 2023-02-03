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
	private Film[] filma;
	
	public Sarrera () {
		this.ID_sarrera = 0;
		this.erosketa_data = null;
		this.filma = null;
	}
	public Sarrera (int id, Date data, int salneurria, Film[] filma) {
		this.ID_sarrera = id;
		this.erosketa_data = data;
		this.salneurria = salneurria;
		this.filma = filma;
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
		return "Sarrera [locaDateH=" + locaDate.getHour() + "locaDateM="+ locaDate.getMinute() + ", ID_sarrera=" + ID_sarrera + ", erosketa_data=" + dt.format(erosketa_data) + ", salneurria=" + salneurria + ", filma=" + Arrays.toString(filma) + "]";
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
