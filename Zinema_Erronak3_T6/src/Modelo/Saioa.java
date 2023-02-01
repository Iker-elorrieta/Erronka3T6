package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Saioa {
	private int ID_saioa;
	private Date data;
	private Hora ordua;
	private Sarrera [] sarrerak;
	
	public Saioa () {
		this.ID_saioa = 0;
		this.data = null;
		this.ordua = null;
		this.sarrerak = null;
	}
	public Saioa (int id, Date data, Hora ordua, Sarrera [] sarrera) {
		this.ID_saioa = id;
		this.data = data;
		this.ordua = ordua;
		this.sarrerak = sarrera;
	}
	
	public Sarrera[] getSarrerak() {
		return sarrerak;
	}

	public void setSarrerak(Sarrera[] sarrerak) {
		this.sarrerak = sarrerak;
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
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		return "Saioa [ID_saioa=" + ID_saioa + ", data=" + dt.format(data) + ", ordua=" + ordua + ", sarrerak="
				+ Arrays.toString(sarrerak) + "]";
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
