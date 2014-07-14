package tp6;

import tp5.ServicioAmigos;

public class SoloAmigos extends Visibilidad {

	@Override
	public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {		
		return new ServicioAmigos().consultarAmigos(idUsuario).contains(idUsuario2);
	}

}
