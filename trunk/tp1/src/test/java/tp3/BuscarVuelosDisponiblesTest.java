package tp3;

import java.util.List;

import org.junit.Test;

import aerolinea.Vuelo;
import servicios.AsientoManager;
import tp2.AbstractHibernateTest;

public class BuscarVuelosDisponiblesTest extends AbstractHibernateTest{

	//Agregar una aerolinea, vuelos, tramos y asientos a la bdd
	
	@Test
	public void testApp(){
		
		Integer id = 1;
		List<Vuelo> vuelos = new AsientoManager().buscarVuelosDisponibles(id);
		assertTrue(!vuelos.isEmpty());
	}

}
//