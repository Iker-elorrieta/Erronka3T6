package Modelo;

public class Hora {
	
	private int horas;
	private int minutos;
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	@Override
	public String toString() {
		return  horas + ":" + minutos ;
	}
	

}
