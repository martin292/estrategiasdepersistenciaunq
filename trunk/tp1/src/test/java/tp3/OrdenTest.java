package tp3;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Test;

import buscador.PorCantidadDeEscalas;
import buscador.PorCosto;
import buscador.PorDuracion;
import aerolinea.Vuelo;
import daos.SessionManager;
import servicios.Operation;
import tp2.AbstractHibernateTest;

public class OrdenTest extends AbstractHibernateTest{
	
	@Test
	public void testOrdenarPorCosto()throws Exception{
		//Agregar a la bdd un vuelo con costo == 1000
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
				
				PorCosto orden = new PorCosto();
				
				List<Vuelo> resultado = orden.ordenar(vuelos).list();
				
				assertTrue(resultado.get(0).getCosto() == 1000);
				
				return null;
			}
			
		});
	}
	
	@Test
	public void testOrdenarPorCantidadDeEscalas(){
		//Agregar a la bdd un vuelo con escalas == 2
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
				
				PorCantidadDeEscalas orden = new PorCantidadDeEscalas();
				
				List<Vuelo> resultado = orden.ordenar(vuelos).list();
				
				assertTrue(resultado.get(0).getEscalas() == 2);
				
				return null;
			}
			
		});
	}
	
	@Test
	public void testOrdenarPorDuracion(){
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
				
				PorDuracion orden = new PorDuracion();
				
				List<Vuelo> resultado = orden.ordenar(vuelos).list();
				

				assertTrue(resultado.get(0).getId() == 12);
				
				return null;
			}
			
		});
		
	}
	
	//

}
