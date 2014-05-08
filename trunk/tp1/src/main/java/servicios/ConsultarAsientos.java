package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.AsientoDAO;
import aerolinea.Asiento;

public class ConsultarAsientos implements Operation<List<Asiento>> {

	List<Asiento> asientos = new ArrayList<Asiento>();
	
	public ConsultarAsientos(List<Asiento> asientos){
		super();
		this.asientos = asientos;
	}
	
	public List<Asiento> execute() {
		List<Asiento> ret = new ArrayList<Asiento>();
		for(Asiento a : this.asientos){
			Asiento asiento;
			if (estaDisponible){
				asiento = new AsientoDAO().get(a.getId());
				ret.add(asiento);
			}	
		}
		return ret;
	}

}
