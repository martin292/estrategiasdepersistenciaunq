package aerolinea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vuelo {

	private List<Tramo> tramos = new ArrayList<Tramo>();
	private Integer id;
	private Aerolinea aerolinea;
	
	private Date salida;
	private Date llegada;
	
	private Aerolinea origen; //
	private Aerolinea destino; //
	
	private int costoTotal;
	
	//
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
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	public Date getLlegada() {
		return llegada;
	}
	public void setLlegada(Date llegada) {
		this.llegada = llegada;
	}
	public Aerolinea getOrigen() {
		return origen;
	}
	public void setOrigen(Aerolinea origen) {
		this.origen = origen;
	}
	public Aerolinea getDestino() {
		return destino;
	}
	public void setDestino(Aerolinea destino) {
		this.destino = destino;
	}



	public int getCostoTotal() {
		return costoTotal;
	}



	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
	
}
