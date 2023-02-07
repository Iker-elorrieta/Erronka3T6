package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Eskaria {
	LocalDateTime locaDate;
	private int id_eskari;
	private double prezio_totala;
	private Date erosketa_data;
	private Bezero bezeroa;
	
	
	public Eskaria () {
		this.id_eskari = 0;
		this.erosketa_data = null;
		this.bezeroa = null;
		this.prezio_totala = 0;
		this.locaDate = null;
	}
	public Eskaria (int id, Date erosketa_data, double prezio_totala, Bezero bezeroa, LocalDateTime locaDate) {
		this.id_eskari = id;
		this.erosketa_data = erosketa_data;
		this.prezio_totala = prezio_totala;
		this.bezeroa = bezeroa;
		this.locaDate = locaDate;
	}
	public int getId_eskari() {
		return id_eskari;
	}
	public void setId_eskari(int id_eskari) {
		this.id_eskari = id_eskari;
	}
	public double getPrezio_totala() {
		return prezio_totala;
	}
	public void setPrezio_totala(double prezio_totala) {
		this.prezio_totala = prezio_totala;
	}
	public Date getErosketa_data() {
		return erosketa_data;
	}
	public void setErosketa_data(Date erosketa_data) {
		this.erosketa_data = erosketa_data;
	}
	public LocalDateTime getLocaDate() {
		return locaDate;
	}
	public void setLocaDate(LocalDateTime locaDate) {
		this.locaDate = locaDate;
	}
	public Bezero getBezeroa() {
		return bezeroa;
	}
	public void setBezeroa(Bezero bezeroa) {
		this.bezeroa = bezeroa;
	}
	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		return "Eskaria [locaDateH=" + locaDate.getHour() + "locaDateM=" + locaDate.getMinute() + ", id_eskari=" + id_eskari + ", prezio_totala=" + prezio_totala
				+ ", erosketa_data=" + dt.format(erosketa_data) + ", bezeroa=" + bezeroa + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Eskaria other = (Eskaria) obj;
		return Objects.equals(id_eskari, other.id_eskari);
	}
	
}
	

