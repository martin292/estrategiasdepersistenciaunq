package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;

public class PorOrigenDestino extends Criterio{

	private Aerolinea origen;
	private Aerolinea destino;
	
	@Override
	public void filtrar(Criteria vuelos) {
		vuelos.add(Restrictions.eq("origen", origen.getId()))
		.add(Restrictions.eq("destino", destino.getId()));		
	}

}
