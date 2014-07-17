package tp6;

public class Publico extends Visibilidad {

	public Publico(){}
	
	@Override
	public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {
		return true;
	}
	
	public String toString(){
		return "Publico";
	}
	
	
}
