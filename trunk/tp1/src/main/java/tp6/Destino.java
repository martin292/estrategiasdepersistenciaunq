package tp6;

import java.util.ArrayList;
import java.util.List;

public class Destino {
	
	private Integer id;
	
	private String pais;
	private String ciudad;
	private Visibilidad visibilidad;
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	private Integer megusta;
	private Integer nomegusta;
	


	public Destino(String pais, String ciudad) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	public void agregarComentario(Comentario comentario) {
		this.comentarios.add(comentario);		
	}
	
	public void meGusta(){
		this.megusta += 1;
	}
	public void noMeGusta(){
		this.nomegusta += 1;
	}
	
	public boolean sePuedeAgregar(Perfil perfil, Perfil yo) {
		return this.visibilidad.ejecutar(perfil.getIdUsuario(), yo.getIdUsuario());
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
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMegusta() {
		return megusta;
	}
	public void setMegusta(Integer like) {
		this.megusta = like;
	}

	//
	
}
