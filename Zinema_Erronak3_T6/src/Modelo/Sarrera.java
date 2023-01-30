package Modelo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sarrera {
	private int ID_sarrera;
	//private int ID_saioa;
	private Date erosketa_data;
	
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
	
}
