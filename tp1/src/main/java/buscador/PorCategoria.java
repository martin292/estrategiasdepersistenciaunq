package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Categoria;

public class PorCategoria extends Criterio{

	private String cat;
	
	public PorCategoria(String c){
		super();
		this.cat = c;
	}
	
	@Override
	public Criteria filtrar(Criteria vuelos) {
		return vuelos.createCriteria("tramos").createCriteria("asientos")
		.add(Restrictions.eq("categoria.cat", this.cat));		
	}

}
