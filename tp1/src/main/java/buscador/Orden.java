package buscador;

import org.hibernate.Criteria;

public abstract class Orden {

	public abstract Criteria ordenar(Criteria c);
	
}
