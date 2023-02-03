package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Saioa {
	private int ID_saioa;
	private Date data;
	private int ordua;
	private int minutua;
	Film [] filma = new Film [1];
	
	public Saioa () {
		this.ID_saioa = 0;
		this.data = null;
		this.ordua = 0;
		this.minutua = 0;
		this.filma = null;
	}
	public Saioa (int id, Date data, int ordua, int minutua, Film[] filma) {
		this.ID_saioa = id;
		this.data = data;
		this.ordua = ordua;
		this.minutua = minutua;
		this.filma = filma;
	}

	public int getMinutua() {
		return minutua;
	}
	public void setMinutua(int minutua) {
		this.minutua = minutua;
	}
	
	public int getOrdua() {
		return ordua;
	}
	public void setOrdua(int ordua) {
		this.ordua = ordua;
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
	public Film[] getFilma() {
		return filma;
	}
	public void setFilma(Film[] filma) {
		this.filma = filma;
	}
	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		return "Saioa [ID_saioa=" + ID_saioa + ", data=" + dt.format(data) + ", ordua=" + ordua + ", minutua=" + minutua
				+ ", filma=" + Arrays.toString(filma) + "]";
	}
	/*@Override
	public int hashCode() {
		return Objects.hash(ID_saioa);
	}*/
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Saioa other = (Saioa) obj;
		return Objects.equals(ID_saioa, other.ID_saioa);
	}
	
	
}
