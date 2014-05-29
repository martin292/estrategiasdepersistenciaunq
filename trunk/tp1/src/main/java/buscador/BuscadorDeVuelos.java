package buscador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import daos.SessionManager;
import aerolinea.Aerolinea;
import aerolinea.Asiento;
import aerolinea.Categoria;
import aerolinea.Vuelo;

public class BuscadorDeVuelos {
	
	private List<Criterio> criterios = new ArrayList<Criterio>();
	private Criteria vuelos;
	
	private Orden orden;
		
	
	public List<Vuelo> buscar(){
		this.vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		if(this.criterios.isEmpty()){return this.vuelos.list();}
		
		for(Criterio c: this.criterios){
			this.vuelos = c.filtrar(this.vuelos);
		}
				
		return this.vuelos.list();
	}
		
	public void agregarCriterio(Criterio c){
		this.criterios.add(c);
	}
				
	//
		
	public List<Vuelo> ordenar(){		
		return this.orden.ordenar(this.vuelos).list();
	}
	
	public void agregarOrden(Orden o){
		this.orden = o;
	}
	
}
