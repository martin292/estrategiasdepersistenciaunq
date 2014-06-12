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
	
	private String origen; //
	private String destino; //
	
	private int costo;
	private int escalas;
	private Date duracion;
	
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
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costoTotal) {
		this.costo = costoTotal;
	}
	public int getEscalas() {
		return escalas;
	}
	public void setEscalas(int escalas) {
		this.escalas = escalas;
	}
	public Date getDuracion() {
		return duracion;
	}
	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}
	
	
}
