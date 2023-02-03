package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Saioa {
	private LocalDateTime locaDate;
	private int ID_saioa;
	private Date data;
	Film [] filma = new Film [1];
	
	
	public Saioa () {
		this.ID_saioa = 0;
		this.data = null;
		this.filma = null;
		this.locaDate = null;
		
	}
	public Saioa (int id, Date data, LocalDateTime locaDate, Film[] filma) {
		this.ID_saioa = id;
		this.data = data;
		this.filma = filma;
		this.locaDate = locaDate;
	}
	
	public LocalDateTime getLocaDate() {
		return locaDate;
	}
	public void setLocaDate(LocalDateTime locaDate) {
		this.locaDate = locaDate;
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
		return "Saioa [ID_saioa=" + ID_saioa + ", data=" + dt.format(data) + ", filma=" + Arrays.toString(filma) + "]";
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
