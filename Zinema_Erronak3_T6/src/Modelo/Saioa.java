package Modelo;

import java.util.Date;
import java.util.Objects;

public class Saioa {
	private int ID_saioa;
	//private int ID_areto;
	//private int ID_film;
	private Date data;
	private Hora ordua;
	
	public Saioa () {
		this.ID_saioa = 0;
		this.data = null;
		this.ordua = null;
	}
	
	public int getID_saioa() {
		return ID_saioa;
	}
	public void setID_saioa(int iD_saioa) {
		ID_saioa = iD_saioa;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Hora getOrdua() {
		return ordua;
	}
	public void setOrdua(Hora ordua) {
		this.ordua = ordua;
	}
	@Override
	public String toString() {
		return "Saioa [ID_saioa=" + ID_saioa + ", data=" + data + ", ordua=" + ordua + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID_saioa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saioa other = (Saioa) obj;
		return ID_saioa == other.ID_saioa;
	}
	
	
}
