package aerolinea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tramo {
	
	private Aerolinea origen;
	private Aerolinea destino;
	private Date llegada;
	private Date salida;
	private List<Asiento> acientos = new ArrayList<Asiento>();
	private Integer id;
	
	
	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Tramo() {
	}
	
	
	
	
	
	
	
	
	//////////////////////////////////////////
	//getters and setters
	//////////////////////////////////////////
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
	public Date getLlegada() {
		return llegada;
	}
	public void setLlegada(Date llegada) {
		this.llegada = llegada;
	}
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	public List<Asiento> getAcientos() {
		return acientos;
	}
	public void setAcientos(List<Asiento> acientos) {
		this.acientos = acientos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//
}
