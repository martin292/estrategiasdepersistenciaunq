package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.AerolineaDAO;
import aerolinea.Aerolinea;
import aerolinea.Asiento;
import aerolinea.Tramo;
import aerolinea.Vuelo;

public class BuscarVuelosDisponibles implements Operation<List<Vuelo>>{

	private Integer aerolineaId;
	
	public BuscarVuelosDisponibles(Integer id){
		super();
		this.aerolineaId = id;
	}
	
	public List<Vuelo> execute() {
		List<Vuelo> ret = new ArrayList<Vuelo>();
		Aerolinea aero = new AerolineaDAO().get(this.aerolineaId);
		
		for(Vuelo v: aero.getVuelos()){
			
			if(this.estaDisponible(v)){
				//Un vuelo esta disponible cuando tiene al menos 1 asiento libre en cada uno de sus tramos
				ret.add(v);
			}
			
		}
		
		return ret;
	}

	private boolean estaDisponible(Vuelo v) {
		
		boolean ret = true;
		
		for(Tramo t: v.getTramos()){
			ret = ret && this.tieneUnAsientoLibre(t);
		}
		
		return ret;
	}

	private boolean tieneUnAsientoLibre(Tramo t) {
		
		for(Asiento a: t.getAsientos()){
			if(!a.isEstado()){
				return true;
			}
		}
		
		return false;
	}

}
