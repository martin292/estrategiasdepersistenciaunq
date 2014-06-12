package aerolinea;

public abstract class Categoria {

	private Integer id;
	private int precio;
	private String cat;
	private Asiento asiento;
	
	
	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Categoria() {
	}
	
	
	public Asiento getAsiento() {
		return asiento;
	}
	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}
	public int calcularPrecio(int precioTramo){
		return precioTramo + this.getPrecio();
	}	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
		
}
