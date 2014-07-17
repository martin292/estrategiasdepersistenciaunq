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
		sc.getHome().getMongoCollection().drop();
		
		Usuario usr = new Usuario(1, "x");		
		sc.agregarNuevoPerfil(usr);
		
		Usuario usr2 = new Usuario(2, "y");		
		sc.agregarNuevoPerfil(usr2);
		
		Destino d = new Destino("a", "b");
		d.setId(1);
		sc.agregarDestino(d, sc.retPerfil(1));
		sc.agregarDestino(d, sc.retPerfil(2));

	}
	
	@After
	public void cleanDB(){
		sc.getHome().getMongoCollection().drop();
	}
	
	@Test
	public void testAgregarDestino(){
		Destino d = new Destino("b", "c");
		d.setId(2);
			
		sc.agregarDestino(d, sc.retPerfil(1));
			
		assertEquals(sc.retPerfil(1).retDestino(2).getPais(),  "b");
	}
	
	@Test
	public void testAgregarComentario(){
		Comentario c = new Comentario();
		c.setIdUsuario(1);
		c.setTxt("Hola");
		
		sc.agregarComentario(c, sc.retPerfil(1), 1);
		
		assertEquals(sc.retPerfil(1).retDestino(1).getComentarios().get(0).getTxt(), "Hola");
	}
	
	@Test
	public void testMeGusta(){
		sc.meGusta(sc.retPerfil(1), 1);
		assertTrue(sc.retPerfil(1).retDestino(1).getMegusta() == 1);
	}
	
	@Test
	public void testNoMeGusta(){
		sc.noMeGusta(sc.retPerfil(1), 1);
		assertTrue(sc.retPerfil(1).retDestino(1).getNomegusta() == 1);
	}
	
	@Test
	public void testEstablecerVisibilidad(){
		sc.establecerVisibilidadAlDestino(sc.retPerfil(1), 1, Visibilidad.PUBLICO);
		assertEquals(Visibilidad.PUBLICO, sc.retPerfil(1).retDestino(1).getVisibilidad());
	}
	
	@Test
	public void testVerPerfil(){
		sc.establecerVisibilidadAlDestino(sc.retPerfil(2), 1, Visibilidad.PUBLICO);
		
		Perfil p = sc.verPerfil(2, 1);
		
		assertEquals(p.getDestinos().get(0).getPais(), "a");
	}
	
	//
	
	public ServicioComentariosTest()throws UnknownHostException{}


}