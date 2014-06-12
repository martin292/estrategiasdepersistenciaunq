package tp3;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Test;

import daos.SessionManager;
import aerolinea.Vuelo;
import buscador.PorAerolinea;
import buscador.PorCategoria;
import buscador.PorFechaDeLlegada;
import buscador.PorFechaDeSalida;
import buscador.PorOrigenDestino;
import servicios.Operation;
import tp2.AbstractHibernateTest;

public class CriterioTest extends AbstractHibernateTest{
	
	@Test
	public void testFiltrarPorAerolinea()throws Exception{
		//Agregar al la bdd la aerolinea Lan
		//Agregar al la bdd un vuelo para la aerolinea Lan
		
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {
				PorAerolinea filtro = new PorAerolinea("Lan");
				
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
				
				List<Vuelo> resultado = filtro.filtrar(vuelos).list();
				
				assertFalse(resultado.isEmpty());		
				
				return null;
			}
		});
		
	}
	
	@Test
	public void testFiltrarPorCategoria() throws Exception{
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				
				PorCategoria filtro = new PorCategoria("Turista");
				
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
				
				List<Vuelo> resultado = filtro.filtrar(vuelos).list();
								
				assertFalse(resultado.isEmpty());
				
				return null;
			}
			
		});
		
	}
	
	@Test
	public void testFiltrarPorFechaDeLlegada()throws Exception{
		//Agregar al la bdd un vuelo con fecha de llegada == '2014, 6, 6, 00, 00, 00'
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				Date llegada = new Date(2014, 6, 6, 00, 00, 00);
				
				PorFechaDeLlegada filtro = new PorFechaDeLlegada(llegada);
				
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);

				List<Vuelo> resultado = filtro.filtrar(vuelos).list();
				
				assertFalse(resultado.isEmpty());
				
				return null;
			}
			
		});		
	}
	
	@Test
	public void testFiltrarPorFechaDeSalida()throws Exception{
		//Agregar al la bdd un vuelo con fecha de salida == '2014, 6, 5, 00, 00, 00'
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				Date salida = new Date(2014, 6, 5, 00, 00, 00);
				
				PorFechaDeSalida filtro = new PorFechaDeSalida(salida);
				
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);

				List<Vuelo> resultado = filtro.filtrar(vuelos).list();
				
				assertFalse(resultado.isEmpty());
				
				return null;
			}
			
		});		
	}
	
	@Test
	public void testFiltrarPorOrigenDestino()throws Exception{
		//Agregar a la bdd un vuelo con origen == 'Argentina' y destino == 'Argentina'
		
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				
				PorOrigenDestino filtro = new PorOrigenDestino("Argentina", "Argentina");
				
				Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);

				List<Vuelo> resultado = filtro.filtrar(vuelos).list();
				
				assertFalse(resultado.isEmpty());
				
				return null;
			}
			
		});
	}

}
