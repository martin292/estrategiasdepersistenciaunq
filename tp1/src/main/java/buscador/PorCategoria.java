package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Categoria;

public class PorCategoria extends Criterio{

	private Categoria cat;
	
	public PorCategoria(Categoria c){
		super();
		this.cat = c;
	}
	
	@Override
	public Criteria filtrar(Criteria vuelos) {
		return vuelos.createAlias("tramos", "ts").createAlias("ts.asientos", "as")
		.add(Restrictions.eq("as.categoria", this.cat));		
	}

}
