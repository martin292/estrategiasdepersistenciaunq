package tp6;

import tp5.ServicioAmigos;

public enum Visibilidad {
	PUBLICO {
		@Override
		public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {
			return true;
		}
	}, 
	PRIVADO {
		@Override
		public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {
			return false;
		}
	}, 
	SOLO_AMIGOS {
		@Override
		public boolean ejecutar(Integer idUsuario, Integer idUsuario2) {
			return new ServicioAmigos().consultarAmigos(idUsuario).contains(idUsuario2);
		}
	};
	
	public  abstract boolean ejecutar(Integer idUsuario, Integer idUsuario2);

}
