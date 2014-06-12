package aerolinea;

import java.util.ArrayList;
import java.util.List;

public abstract class Categoria {

	private Integer id;
	private int precio;
	private List<Asiento> asientos = new ArrayList<Asiento>();
	
	
	
	public List<Asiento> getAsientos() {
		return asientos;
	}
	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}
	public int calcularPrecio(int precioTramo){
		return precioTramo + this.getPrecio();
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
		
}
