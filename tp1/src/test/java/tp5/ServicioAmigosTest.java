package tp5;

import junit.framework.TestCase;

import org.junit.Test;
import org.neo4j.graphdb.Transaction;

public class ServicioAmigosTest extends TestCase{
	
	@Test
	public void testAgregarAmigo(){
		ServicioAmigos sa = new ServicioAmigos();
		
		sa.crearDB();
		try{
			Transaction tx = sa.graphDb.beginTx();
			
			sa.guardar(1);
			sa.guardar(2);
			sa.agregarAmigo(1, 2);
			
			assertTrue(sa.buscar(1).hasRelationship());
			
			tx.success();			
		}catch(Exception e){}
		sa.shutDown();
	}
	
	@Test
	public void testConsultarAmigos(){
		ServicioAmigos sa = new ServicioAmigos();
		
		sa.crearDB();
		try{
			Transaction tx = sa.graphDb.beginTx();
			
			sa.guardar(1);
			sa.guardar(2);
			sa.guardar(3);
			sa.guardar(4);
			
			sa.agregarAmigo(1, 2);
			sa.agregarAmigo(1, 4);
			sa.agregarAmigo(1, 3);
			
			System.out.println(sa.verContactos(1));
			
			assertTrue(sa.verContactos(1).contains(2));
			assertTrue(sa.verContactos(1).contains(3));
			assertTrue(sa.verContactos(1).contains(4));
			
			
			tx.success();			
		}catch(Exception e){}
		sa.shutDown();
	}
	
	@Test
	public void testEnviarMensaje(){
		ServicioAmigos sa = new ServicioAmigos();
		
		sa.crearDB();
		try{
			Transaction tx = sa.graphDb.beginTx();
			
			sa.guardar(1);
			sa.guardar(2);
			
			sa.enviarMensaje(1, "Hola", 2);
			
			assertTrue(sa.buscar(1).hasRelationship());
			
			tx.success();			
		}catch(Exception e){}
		sa.shutDown();
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
		sa.shutDown();
	}

}
