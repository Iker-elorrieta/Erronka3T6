package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saioa {
	private int ID_saioa;
	//private int ID_areto;
	//private int ID_film;
	private Date data;
	private Hora ordua;
	
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
	
	
}
