package tp6;

import java.util.ArrayList;
import java.util.List;

import tp1.Usuario;

public class Perfil {
	
	protected Integer idUsuario;
	//
	protected List<Destino> destinos = new ArrayList<Destino>();
	protected List<Integer> amigos = new ArrayList<Integer>();
	
	
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
	public List<Integer> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<Integer> amigos) {
		this.amigos = amigos;
	}
	
	//

}
