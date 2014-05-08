package aerolinea;

import java.util.ArrayList;
import java.util.List;

public class Aerolinea {

	private List<Vuelo> vuelos = new ArrayList<Vuelo>();
	private Integer id;
	
	
	
	
	
	
	
	
	/////////////////////////////////////
	//Getters and setters
	/////////////////////////////////////
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(List<Vuelo> vuelo) {
		this.vuelos = vuelo;
	}
	

}
