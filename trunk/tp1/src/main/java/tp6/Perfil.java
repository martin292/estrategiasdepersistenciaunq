package tp6;

import java.util.ArrayList;
import java.util.List;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

import tp1.Usuario;

public class Perfil {
	
	@ObjectId
	@JsonProperty("_id")
	protected Integer idUsuario;
	
	protected String usrName;
	
	//
	protected List<Destino> destinos = new ArrayList<Destino>();
		

	public Perfil mostrarPerfil(Perfil yo) {	
		return new Perfil().agregarDestinos(yo);
	}
	
	private Perfil agregarDestinos(Perfil yo) {
		for(Destino d: yo.getDestinos()){
			if(d.sePuedeAgregar(this, yo)){
				this.agregarDestino(d);
			}
		}
		
		return this;
	}

	public void agregarDestino(Destino destino) {
		this.destinos.add(destino);		
	}
	
	public Destino retDestino(Integer destinoID) {
		for(Destino d: this.destinos){
			if(d.getId() == destinoID){
				return d;
			}
		}
		
		return null;
	}
	
	
	//-------------------------------------------


	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public List<Destino> getDestinos() {
		return destinos;
	}
	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	
	//

}
