package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;

public class PorOrigenDestino extends Criterio{

	private String origen;
	private String destino;
	
	public PorOrigenDestino(String o, String d){
		super();
		this.destino = d;
		this.origen = o;
	}
	
	@Override
	public Criteria filtrar(Criteria vuelos) {
		return vuelos.add(Restrictions.eq("origen", this.origen))
		.add(Restrictions.eq("destino", this.destino));		
	}

}
