package tp6;

public class Privada extends Visibilidad {

	@Override
	public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {
		return idUsuario == idUsuario2;
	}

}
