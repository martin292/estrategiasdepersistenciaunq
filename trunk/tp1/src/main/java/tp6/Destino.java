package tp6;

import java.util.ArrayList;
import java.util.List;

public class Destino {
	
	private Integer id;
		
	private String pais;
	private String ciudad;
	private Visibilidad visibilidad;
	private List<String> comentarios = new ArrayList<String>();
	
	private boolean like;


	public Destino(String pais, String ciudad) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	public void agregarComentario(String comentario) {
		this.comentarios.add(comentario);		
	}
	
	
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}
	public void setVisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}
	public List<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	
	
	
}
