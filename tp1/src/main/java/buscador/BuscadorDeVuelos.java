package buscador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import daos.SessionManager;
import aerolinea.Aerolinea;
import aerolinea.Categoria;
import aerolinea.Vuelo;

public class BuscadorDeVuelos {
	
	private List<Criterio> criterios = new ArrayList<Criterio>();
	private Criteria vuelos;
	
	
	public Criteria retVuelos(){
		return SessionManager.getSession().createCriteria(Vuelo.class);
	}
	
	public Criteria buscarPorAerolinea(Aerolinea aerolinea){
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		vuelos.createAlias("aerolinea", "aero").add(Restrictions.eq("aero.id", aerolinea.getId()));
		
		return vuelos;
	}
	
	public Criteria buscarPorCategoria(Categoria cat){
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		vuelos.createAlias("tramos", "ts").createAlias("ts.asientos", "as")
			.add(Restrictions.eq("as.categoria", cat));
		
		return vuelos;
	}
	
	public Criteria buscarPorFechaDeSalida(Date fecha){
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		vuelos.add(Restrictions.eq("salida", fecha));
		
		return vuelos;		
	}
	
	public Criteria buscarPorFechaDeLlegada(Date fecha){
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		vuelos.add(Restrictions.eq("llegada", fecha));
		
		return vuelos;
	}
	
	public Criteria buscarPorOrigenDestino(Aerolinea origen, Aerolinea destino){
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		vuelos.add(Restrictions.eq("origen", origen.getId()))
			.add(Restrictions.eq("destino", destino.getId()));
		
		return vuelos;
	}
	
	//
	
	public Criteria ordenarPorCosto(Criteria vuelos){
		//TODO		
		return null;
	}
	
	public Criteria ordenarPorCantidadDeEscalas(Criteria vuelos){
		//TODO
		return null;
	}
	
	public Criteria ordenarPorDuracion(Criteria vuelos){
		//TODO
		return null;
	}
	
	//

}
