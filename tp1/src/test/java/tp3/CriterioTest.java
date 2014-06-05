package tp3;

import java.util.List;

import org.hibernate.Criteria;
import org.junit.Test;

import daos.SessionManager;
import aerolinea.Vuelo;
import buscador.PorAerolinea;
import tp2.AbstractHibernateTest;

public class CriterioTest extends AbstractHibernateTest{
	
	@Test
	public void testFiltrarPorAerolinea()throws Exception{
		PorAerolinea filtro = new PorAerolinea("Lan");
		
		Criteria vuelos = SessionManager.getSession().createCriteria(Vuelo.class);
		
		List<Vuelo> resultado = filtro.filtrar(vuelos).list();
		
		assertFalse(resultado.isEmpty());
	}
	
	@Test
	public void testFiltrarPorCategoria(){
		//TODO
	}
	
	@Test
	public void testFiltrarPorFechaDeLlegada(){
		//TODO
	}
	
	@Test
	public void testFiltrarPorFechaDeSalida(){
		//TODO
	}
	
	@Test
	public void testFiltrarPorOrigenDestino(){
		//TODO
	}

}
