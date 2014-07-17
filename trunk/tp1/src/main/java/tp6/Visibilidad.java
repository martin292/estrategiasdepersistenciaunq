package tp6;

public abstract class Visibilidad {
	
	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Visibilidad(){}
	
	public abstract boolean ejecutar(Integer idUsuario, Integer idUsuario2);

}
