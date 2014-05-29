package buscador;

import org.hibernate.Criteria;

public abstract class Criterio {
	public abstract Criteria filtrar(Criteria vuelos);
}
