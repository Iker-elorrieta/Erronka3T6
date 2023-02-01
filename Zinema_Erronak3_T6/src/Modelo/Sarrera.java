package Modelo;

import java.util.Date;
import java.util.Objects;

public class Sarrera {
	private int ID_sarrera;
	private Date erosketa_data;
	
	public Sarrera () {
		this.ID_sarrera = 0;
		this.erosketa_data = null;
	}
	public Sarrera (int id, Date data) {
		this.ID_sarrera = id;
		this.erosketa_data = data;
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
	
	@Override
	public String toString() {
		return "Sarrera [ID_sarrera=" + ID_sarrera + ", erosketa_data=" + erosketa_data + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID_sarrera);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sarrera other = (Sarrera) obj;
		return ID_sarrera == other.ID_sarrera;
	}
	
}
