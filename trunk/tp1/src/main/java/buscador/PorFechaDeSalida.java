package buscador;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PorFechaDeSalida extends Criterio{

	public Date fecha;
	
	@Override
	public void filtrar(Criteria vuelos) {
		vuelos.add(Restrictions.eq("salida", fecha));		
	}

	
	
}
