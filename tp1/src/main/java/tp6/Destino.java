package tp6;

public class Destino {
	
	private Integer id;
		
	private String pais;
	private String ciudad;
	private String comentario;

	
	public Destino(String pais, String ciudad) {
		super();
		this.pais = pais;
		this.ciudad = ciudad;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
