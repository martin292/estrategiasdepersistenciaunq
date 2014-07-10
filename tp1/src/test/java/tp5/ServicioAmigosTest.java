package tp5;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.neo4j.graphdb.Transaction;

public class ServicioAmigosTest {
	
	@Test
	public void testAgregarAmigo(){
		//TODO
	}
	
	@Test
	public void testConsultarAmigos(){
		//TODO
	}
	
	@Test
	public void testEnviarMensaje(){
		//TODO
	}
	
	@Test
	public void testVerContactos(){
		ServicioAmigos sa = new ServicioAmigos();
		
		sa.crearDB();
		try{
			Transaction tx = sa.graphDb.beginTx();
			
			sa.guardar(1);
			sa.guardar(2);
			sa.guardar(3);
			
			sa.agregarAmigo(1, 2);
			sa.agregarAmigo(2, 3);
			
			assertTrue(sa.verContactos(1).contains(2));
			assertTrue(sa.verContactos(1).contains(3));
			
			tx.success();			
		}catch(Exception e){}
	}

}
