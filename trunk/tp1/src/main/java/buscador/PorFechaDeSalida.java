package buscador;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PorFechaDeSalida extends Criterio{

	public Date fecha;
	
	public PorFechaDeSalida(Date f){
		super();
		this.fecha = f;
	}
	
	@Override
	public Criteria filtrar(Criteria vuelos) {
		return vuelos.add(Restrictions.eq("salida", fecha));		
	}

	
	
}
