package tp6;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tp1.Usuario;

public class ServicioComentariosTest {
	
	public ServicioComentarios sc = ServicioComentarios.instance();
	
	@Before
	public void fillDB(){
		Usuario usr = new Usuario(1, "x");		
		sc.agregarNuevoPerfil(usr);	
	}
	
	@After
	public void cleanDB(){
		sc.getHome().getMongoCollection().drop();
	}
	
	@Test
	public void testAgregarDestino(){
			
		Destino d = new Destino("a", "b");
		d.setId(1);
			
		sc.agregarDestino(d, sc.retPerfil(1));
			
		//assertTrue(sc.retPerfil(1).retDestino(1).getPais() == "a");
			
		
	}
	
	@Test
	public void testAgregarComentario(){
		Comentario c = new Comentario();
		c.setIdUsuario(1);
		c.setTxt("Hola");
		
		Destino d = new Destino("a", "b");
		d.setId(1);
		sc.agregarDestino(d, sc.retPerfil(1));
		
		sc.agregarComentario(c, sc.retPerfil(1), 1);
		
		//assertTrue(sc.retPerfil(1).retDestino(1).getComentarios().get(0).getTxt() == "Hola");
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
