package aerolinea;

public abstract class Categoria {

	protected Integer id;
	protected int precio;
	
	public int calcularPrecio(int precioTramo){
		return precioTramo + this.getPrecio();
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
