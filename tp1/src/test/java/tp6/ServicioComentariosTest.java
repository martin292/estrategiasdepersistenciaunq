package tp6;

import java.net.UnknownHostException;

import org.junit.Test;

import tp1.Usuario;
import junit.framework.TestCase;

public class ServicioComentariosTest extends TestCase{
	
	
	
	@Test
	public void testAgregarDestino(){
		try{			
			ServicioComentarios sc = new ServicioComentarios();
			
			//Usuario usr = new Usuario(1, "hola");
			
			//sc.agregarNuevoPerfil(usr);
			
			Perfil p = new Perfil(1);
			
			Destino d = new Destino("a", "b");
			
			sc.agregarDestino(d, p);						
			
		}catch (UnknownHostException e) {e.printStackTrace();}
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

}
