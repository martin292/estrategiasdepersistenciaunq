package aerolinea;

import tp1.Usuario;

public class Asiento {

	private boolean estado; // reservado o no
	private Categoria categoria;
	private Usuario usuario;
	private Integer id;
	
	
	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Asiento() {
	}
	
	
	
	
	
	
	
	///////////////////////////////////////
	//Getters and setters
	///////////////////////////////////////
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
