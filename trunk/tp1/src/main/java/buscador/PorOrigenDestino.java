package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;

public class PorOrigenDestino extends Criterio{

	private Aerolinea origen;
	private Aerolinea destino;
	
	public PorOrigenDestino(Aerolinea o, Aerolinea d){
		super();
		this.destino = d;
		this.origen = o;
	}
	
	@Override
	public void filtrar(Criteria vuelos) {
		vuelos.add(Restrictions.eq("origen", origen.getId()))
		.add(Restrictions.eq("destino", destino.getId()));		
	}

}
