package aerolinea;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {

	private List<Tramo> tramos = new ArrayList<Tramo>();
	private Integer id;
	
	
	
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
	
	
	
}
