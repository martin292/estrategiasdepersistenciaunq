package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.AsientoDAO;
import tp1.Usuario;
import aerolinea.Asiento;



public class ReservarAsientos implements Operation<List<Asiento>> {
	
	private List<Integer> asientos = new ArrayList<Integer>();
	private Usuario user;
	
	public ReservarAsientos(Usuario u, List<Integer> ids){
		super();
		this.user = u;
		this.asientos = ids;
	}
	
	public List<Asiento> execute() {
		
		List<Asiento> ret = new ArrayList<Asiento>();
		
		
		for(Asiento asiento: new AsientoDAO().asientosDisponibles(this.asientos)){
			asiento.reservar(this.user);
			ret.add(asiento);
		}
		
		return ret;
	}
	
}
