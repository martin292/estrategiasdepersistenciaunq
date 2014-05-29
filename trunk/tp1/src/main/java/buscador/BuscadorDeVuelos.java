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
		
	
	public List<Vuelo> buscar(){
		this.setVuelos(SessionManager.getSession().createCriteria(Vuelo.class));
		
		if(!this.criterios.isEmpty()){
			for(Criterio c: this.getCriterios()){
				c.filtrar(this.getVuelos());
			}
		}
		
		return this.getVuelos().list();
	}
		
	public void agregarCriterio(Criterio c){
		this.criterios.add(c);
	}
	
	
	
	
	
	//---------------------------------------------------------------

	public List<Criterio> getCriterios() {
		return criterios;
	}
	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}
	public Criteria getVuelos() {
		return vuelos;
	}
	public void setVuelos(Criteria vuelos) {
		this.vuelos = vuelos;
	}
	
	//

}
