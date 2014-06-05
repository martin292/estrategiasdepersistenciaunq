package tp3;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Before;
import org.junit.Test;

import daos.AerolineaDAO;
import daos.SessionManager;
import aerolinea.Aerolinea;
import aerolinea.Turista;
import aerolinea.Vuelo;
import buscador.PorAerolinea;
import buscador.PorCategoria;
import buscador.PorFechaDeLlegada;
import buscador.PorFechaDeSalida;
import buscador.PorOrigenDestino;
import servicios.Operation;
import tp2.AbstractHibernateTest;

public class CriterioTest extends AbstractHibernateTest{
	
	
	@Before
	public void setUp() {
		
		SessionManager.runInSession(new Operation<Void>() {

			public Void execute() {	
				
				Aerolinea aerolinea = new Aerolinea();
				aerolinea.setNombre("Lan");
				Vuelo vuelo = new Vuelo();
				vuelo.setId(1);
				vuelo.setAerolinea(aerolinea);
				vuelo.setCosto(1000);
				vuelo.setOrigen("Argeentina");
				vuelo.setDestino("Argentina");
				vuelo.setSalida(new Date(2014, 6, 9));
				vuelo.setLlegada(new Date(2014, 6, 10));
				
				aerolinea.getVuelos().add(vuelo);
				
				new AerolineaDAO().save(aerolinea);
				return null;
			}
		});
		
	}
	
	
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
		PorCategoria filtro = new PorCategoria(new Turista());
		
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		List<Vuelo> resultado = filtro.filtrar(vuelos).list();
		
		assertFalse(resultado.isEmpty());
		SessionManager.runInSession(new Operation<Void>(){

			public Void execute() {
				// TODO 
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
