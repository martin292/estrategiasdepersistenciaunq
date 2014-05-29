package buscador;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PorFechaDeLlegada extends Criterio{

	public Date fecha;
	
	public PorFechaDeLlegada(Date f){
		super();
		this.fecha = f;
	}
	
	@Override
	public void filtrar(Criteria vuelos) {
		vuelos.add(Restrictions.eq("llegada", this.fecha));		
	}

}
