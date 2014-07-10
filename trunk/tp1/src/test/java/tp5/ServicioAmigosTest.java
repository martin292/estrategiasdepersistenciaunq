package tp5;

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
			
			tx.success();			
		}catch(Exception e){}
	}

}
