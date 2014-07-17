package tp6;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import tp1.Usuario;

public class ServicioComentariosTest {
	
	public ServicioComentarios sc = ServicioComentarios.instance();
	
	@Before
	public void fillDB(){
		sc.getHome().getMongoCollection().drop();
	}
	
	@Test
	public void testAgregarDestino(){
		
		
		Usuario usr = new Usuario(2, "hola");
			
		sc.agregarNuevoPerfil(usr);
			
		Destino d = new Destino("a", "b");
			
		sc.agregarDestino(d, sc.retPerfil(2));
			
		//assertTrue(sc.retPerfil(2).getDestinos().get(0).getPais() == "a");
			
		
	}
	
	@Test
	public void testAgregarComentario(){
		//TODO
	}
	
	@Test
	public void testMeGusta(){
		//TODO
	}
	
	@Test
	public void testNoMeGusta(){
		//TODO
	}
	
	@Test
	public void testEstablecerVisibilidadAlDestino(){
		//TODO
	}
	
	@Test
	public void testEstablecerVisibilidadAlComentario(){
		//TODO
	}
	
	@Test
	public void testVerPerfil(){
		//TODO
	}
	
	//
	
	public ServicioComentariosTest()throws UnknownHostException{}


}
