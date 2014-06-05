package buscador;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;

public class PorAerolinea extends Criterio {
	
	public String aerolinea;
	
	public PorAerolinea(String aerolinea){
		super();
		this.aerolinea = aerolinea;
	}
	
	@Override
	public Criteria filtrar(Criteria vuelos){
		return vuelos.createCriteria("aerolinea").add(Restrictions.eq("nombre", this.aerolinea));
	}

}
