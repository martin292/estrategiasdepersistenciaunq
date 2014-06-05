package buscador;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import aerolinea.Tramo;
import daos.SessionManager;

public class PorCantidadDeEscalas extends Orden{

	@Override
	public Criteria ordenar(Criteria c) {		
		return c.addOrder(Order.desc("escalas"));
	}

}
