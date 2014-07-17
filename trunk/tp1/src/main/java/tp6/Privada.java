package tp6;

public class Privada extends Visibilidad {

	public Privada(){}
	
	
	public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {
		return idUsuario == idUsuario2;
	}
	
	public String toString(){
		return "Privada";
	}

}
