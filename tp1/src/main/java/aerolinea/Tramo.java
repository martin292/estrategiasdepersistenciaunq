package aerolinea;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tramo {
	
	private Aerolinea origen;
	private Aerolinea destino;
	private Date llegada;
	private Date salida;
	private List<Asiento> asientos = new ArrayList<Asiento>();
	private Integer id;
	private Vuelo vuelo;
	
	
	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	public Tramo() {
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
	public List<Asiento> getAsientos() {
		return asientos;
	}
	public void setAsientos(List<Asiento> acientos) {
		this.asientos = acientos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	//
}
