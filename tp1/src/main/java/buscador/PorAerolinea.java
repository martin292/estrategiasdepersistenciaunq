package buscador;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;

public class PorAerolinea extends Criterio {
	
	public Aerolinea aerolinea;
	
	public void filtrar(Criteria vuelos){
		vuelos.createAlias("aerolinea", "aero").add(Restrictions.eq("aero.id", aerolinea.getId()));
	}

}
