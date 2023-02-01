package Modelo;

import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(horas, minutos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hora other = (Hora) obj;
		return horas == other.horas && minutos == other.minutos;
	}

}
