package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Categoria;

public class PorCategoria extends Criterio{

	private Categoria cat;
	
	@Override
	public void filtrar(Criteria vuelos) {
		vuelos.createAlias("tramos", "ts").createAlias("ts.asientos", "as")
		.add(Restrictions.eq("as.categoria", cat));		
	}

}
