package tp6;

import java.util.ArrayList;
import java.util.List;

public class Comentario {
	
	private Integer idUsuario;
	private String txt;	
	private Visibilidad visibilidad;
	//private List<Integer> likes = new ArrayList<Integer>();
	private int megusta;
	private int nomegusta;
	
	public Comentario(){}
	
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}
	public void setVisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}
		
	//

}