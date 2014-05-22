package servicios;

import java.util.List;

import daos.SessionManager;
import aerolinea.Asiento;
import aerolinea.Vuelo;
import tp1.Usuario;

public class AsientoManager {

	public Asiento reservarAsiento(Integer id, Usuario u){
		return SessionManager.runInSession(new ReservarAsiento(id, u));
	}
	
	public List<Asiento> reservarAsientos(Usuario u, List<Integer> ids){
		return SessionManager.runInSession(new ReservarAsientos(u, ids));
	}
	
	public List<Asiento> consultarAsientos(Integer id){
		return SessionManager.runInSession(new ConsultarAsientos(id));
	}
	
	public List<Vuelo> buscarVuelosDisponibles(Integer id){
		return SessionManager.runInSession(new BuscarVuelosDisponibles(id));
	}
	
}
