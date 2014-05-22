package aerolinea;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {

	private List<Tramo> tramos = new ArrayList<Tramo>();
	private Integer id;
	private Aerolinea aerolinea;
	
	
	
	public Vuelo(){
		
	}
	
	
	
	////////////////////////////////////////
	//Getters and setters
	////////////////////////////////////////
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Tramo> getTramos() {
		return tramos;
	}
	public void setTramos(List<Tramo> tramos) {
		this.tramos = tramos;
	}
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
	
}
