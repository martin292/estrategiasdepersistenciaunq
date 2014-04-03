package tp1;

import java.util.Date;

import org.junit.Test;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidacionException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SistemaDBTest {
	
	public SistemaDB sis = new SistemaDB();
	
	@Test
	public void testRegistrarUsuario(){
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito4", "myPassword", "email", fecha);
		
		sis.registrarUsuario(usuario);
		
		assertEquals(usuario.getNombreusuario(), sis.ingresarUsuario("jorgito4", "myPassword").getNombreusuario());	
	}
	
	@Test
	public void testRegistrarUsuarioFalla(){
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito3", "myPassword", "email", fecha);
		Usuario usuario2 = new Usuario("a", "a", "jorgito", "a", "a", fecha);
		try{
			sis.registrarUsuario(usuario);
			sis.registrarUsuario(usuario2);
			
		}catch(Exception e){
			assertTrue(1==1);
		}
	}
	
	@Test
	public void testValidarCuenta(){
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito1", "myPassword", "email", fecha);
		usuario.setCodigodevalidacion("codigo");
		sis.registrarUsuario(usuario);
		
		//System.out
		assertFalse(sis.ingresarUsuario("jorgito1", "myPassword").getCuentaValida());
		
		sis.validarCuenta("codigo", usuario);
		
		assertTrue(sis.ingresarUsuario("jorgito1", "myPassword").getCuentaValida());
	}
	
	@Test (expected = ValidacionException.class)
	public void testValidarCuentaException(){
		
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito2", "myPassword", "email", fecha);
		usuario.setCodigodevalidacion("codigo");
		sis.registrarUsuario(usuario);
		
		sis.validarCuenta("otroCodigo", usuario);
		
	}
	
	
	@Test
	public void testIngresarUsuario(){
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito", "myPassword", "email", fecha);
		
		sis.registrarUsuario(usuario);
		
		Usuario user = sis.ingresarUsuario("jorgito", "myPassword");
		
		assertEquals(user.getNombreusuario(), "jorgito");
	}
	
	@Test
	public void testCambiarPassword(){
		Date date = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito", "myPassword", "email", date);
		usuario.setCodigodevalidacion("codigo");
		sis.registrarUsuario(usuario);
		
		sis.validarCuenta("codigo", usuario);
		sis.cambiarPassword("jorgito", "myPassword", "newPassword");
		
		assertTrue("newPassword" == usuario.getPassword());
	
	}

	
	
}
