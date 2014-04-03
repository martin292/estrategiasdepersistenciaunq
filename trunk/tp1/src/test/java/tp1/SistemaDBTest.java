package tp1;

import java.util.Date;

import org.junit.Test;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SistemaDBTest {
	
	public SistemaDB sis = new SistemaDB();
	
	@Test
	public void testRegistrarUsuario(){
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito", "myPassword", "email", fecha);
		
		sis.registrarUsuario(usuario);
		
		assertEquals(usuario.getNombreusuario(), sis.ingresarUsuario("jorgito", "myPassword").getNombreusuario());	
	}
	
	@Test (expected = UsuarioYaExisteException.class)
	public void testRegistrarUsuarioFalla(){
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito", "myPassword", "email", fecha);
		
		sis.registrarUsuario(usuario);
		sis.registrarUsuario(usuario);		
	}
	
	@Test
	public void testValidarCuenta(){
		
		Usuario usuario = new Usuario();
		
		
		
		assertTrue(usuario.getCuentaValida());
	}
	
	@Test
	public void testIngresarUsuario(){
		//TODO
	}
	
	@Test
	public void testCambiarPassword(){
		//TODO
	}

	//
	
}
