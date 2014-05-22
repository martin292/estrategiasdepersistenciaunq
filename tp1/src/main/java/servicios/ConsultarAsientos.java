package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.AsientoDAO;
import daos.TramoDAO;
import aerolinea.Asiento;
import aerolinea.Tramo;

public class ConsultarAsientos implements Operation<List<Asiento>> {

	private Integer tramoId;
	
	public ConsultarAsientos(Integer tramoId){
		super();
		this.tramoId = tramoId;
	}
	
	public List<Asiento> execute() {
		List<Asiento> ret = new ArrayList<Asiento>();
		Tramo t = new TramoDAO().get(tramoId);
		for(Asiento a : t.getAsientos()){
			Asiento asiento;
//			if (a.isEstado()){
				asiento = new AsientoDAO().get(a.getId());
				ret.add(asiento);
//			}	
		}
		return ret;
	}

}
