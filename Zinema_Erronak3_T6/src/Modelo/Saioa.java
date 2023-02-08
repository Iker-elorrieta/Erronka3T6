package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Saioa {
	private LocalTime ordua;
	private int ID_saioa;
	private Date data;
	private Film filma;
	
	public Saioa () {
		this.ID_saioa = 0;
		this.data = null;
		this.filma = null;
		this.ordua = null;
		
	}
	public Saioa (int id, Date data, LocalTime ordua, Film filma) {
		this.ID_saioa = id;
		this.data = data;
		this.filma = filma;
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
	public Film getFilma() {
		return filma;
	}
	public void setFilma(Film filma) {
		this.filma = filma;
	}
	
	public LocalTime getOrdua() {
		return ordua;
	}
	public void setOrdua(LocalTime ordua) {
		this.ordua = ordua;
	}
	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		return "Saioa [ID_saioa=" + ID_saioa + ", data=" + dt.format(data) + ", filma=" + filma + ", 'ordua=" + ordua +"]";
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
