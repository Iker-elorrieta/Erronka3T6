package Modelo;

import java.util.Arrays;
import java.util.Objects;

public class Areto {
	private int ID_areto;
	private int zenbakia;
	
	public Areto (){ 
		this.ID_areto = 0;
		this.zenbakia = 0;
	
	}
	public Areto (int ID_areto, int zenbakia) {
		this.ID_areto= ID_areto;
		this.zenbakia = zenbakia;
	}

	public int getID_areto() {
		return ID_areto;
	}
	public void setID_areto(int iD_areto) {
		ID_areto = iD_areto;
	}
	public int getZenbakia() {
		return zenbakia;
	}
	public void setZenbakia(int zenbakia) {
		this.zenbakia = zenbakia;
	}
	@Override
	public String toString() {
		return "Areto [ID_areto=" + ID_areto + ", zenbakia=" + zenbakia + "]";
	}
	/*@Override
	public int hashCode() {
		return Objects.hash(ID_areto, zenbakia);
	}*/
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Areto other = (Areto) obj;
		return Objects.equals(ID_areto, other.ID_areto);
	}
	
	
}
