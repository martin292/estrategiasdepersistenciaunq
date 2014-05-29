package buscador;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;

public class PorAerolinea extends Criterio {
	
	public Aerolinea aerolinea;
	
	public PorAerolinea(Aerolinea a){
		super();
		this.aerolinea = a;
	}
	
	@Override
	public Criteria filtrar(Criteria vuelos){
		return vuelos.createAlias("aerolinea", "aero").add(Restrictions.eq("aero.id", this.aerolinea.getId()));
	}

}
