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
		
		Destino d = new Destino("a", "b");
		d.setId(1);
		sc.agregarDestino(d, sc.retPerfil(1));
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
		
		sc.agregarComentario(c, sc.retPerfil(1), 1);
		
		//assertTrue(sc.retPerfil(1).retDestino(1).getComentarios().get(0).getTxt() == "Hola");
	}
	
	@Test
	public void testMeGusta(){
		sc.meGusta(sc.retPerfil(1), 1);
		//assertTrue(sc.retPerfil(1).retDestino(1).getMegusta() == 1);
	}
	
	@Test
	public void testNoMeGusta(){
		//TODO
	}
	
	@Test
	public void testEstablecerVisibilidadAlDestino(){
		Publico nivel = new Publico();
		sc.establecerVisibilidadAlDestino(sc.retPerfil(1), 1, nivel);
		//assertTrue(sc.retPerfil(1).retDestino(1).getVisibilidad().toString() == "Publico");
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
