package tp1;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SistemaTest {
	
	public Sistema s = new Sistema();
	
	@Test
	public void testIngresarUsuario(){		
				
		Usuario user = new Usuario();
		user.setNombreusuario("a");
		user.setPassword("b");
		
		RepositorioDeUsuarios.getInstance().usuarios.add(user);
		
		
		Usuario u = s.ingresarUsuario("a", "b");
		
		assertTrue(u == user);
		
	}
	
	@Test
	public void testRetUsuario(){
		Usuario user = new Usuario();
		user.setNombreusuario("a");
		user.setPassword("b");
		
		RepositorioDeUsuarios.getInstance().usuarios.add(user);
		
		Usuario u = s.retUsuario("a", "b");
		
		assertTrue(u != user);
	}
	
	@Test
	public void testElUsuarioExiste(){
		Usuario user = new Usuario();
		user.setNombreusuario("a");
		user.setPassword("b");
		
		RepositorioDeUsuarios.getInstance().usuarios.add(user);
		
		boolean resultado = s.elUsuarioExiste("a", "b");
		
		assertTrue(resultado);
	}

}
