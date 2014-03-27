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
	
	@Test(expected = UsuarioNoExisteException.class)
	public void testExcepcionDeIngresarUsuario(){
		
		RepositorioDeUsuarios.getInstance().usuarios.clear();
		
		s.ingresarUsuario("a", "b");
	}
	
	@Test
	public void testRetUsuario(){
		Usuario user = new Usuario();
		user.setNombreusuario("a");
		user.setPassword("b");
		
		RepositorioDeUsuarios.getInstance().usuarios.clear();
		RepositorioDeUsuarios.getInstance().usuarios.add(user);
		
		Usuario u = s.retUsuario("a", "b");		
		
		assertEquals(u, user);
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
	
	

	@Test
	public void testCambiarPassword(){
		Usuario user = new Usuario();
		user.setNombreusuario("a");
		user.setPassword("b");
		
		RepositorioDeUsuarios.getInstance().usuarios.clear();
		RepositorioDeUsuarios.getInstance().usuarios.add(user);
		
		s.cambiarPassword("a", "b", "c");
		
		assertTrue(user.getPassword() == "c");
		
	}
	
	@Test
	public void testValidarCuenta(){
		
		Usuario mockUsuario = mock(Usuario.class);
		
		when(mockUsuario.codigoDeValidacionCorrecto("abc")).thenReturn(true);
		
		s.validarCuenta("abc", mockUsuario);
		
		verify(mockUsuario).validarCuenta();
		
	}
	@Test(expected = ValidacionException .class)
	public void testValidarCuentaException(){
		Usuario mockUsuario = mock(Usuario.class);
		when(mockUsuario.codigoDeValidacionCorrecto("abc")).thenReturn(false);
		s.validarCuenta("abc", mockUsuario);
	}
	
	@Test
	public void testRegistrarUsuario(){
		Usuario mockUsuario = mock(Usuario.class);
		
		RepositorioDeUsuarios.getInstance().usuarios.clear();
		RepositorioDeUsuarios.getInstance().usuarios.add(mockUsuario);
		
		when(mockUsuario.getNombreusuario()).thenReturn("a");
		when(mockUsuario.getPassword()).thenReturn("b");
		when(mockUsuario.getEmail()).thenReturn("c");
		
		s.registrarUsuario(mockUsuario);
		
		verify(mockUsuario).getEmail();
		verify(mockUsuario).setCodigodevalidacion("codigo");
		verify(mockUsuario, times(2)).getNombreusuario();
		verify(mockUsuario, times(2)).getPassword();
		
	}
	
	@Test (expected = UsuarioYaExisteException.class)
	public void testExcepcionDeRegistrarUsuario(){
		Usuario mockUsuario = mock(Usuario.class);
		
		RepositorioDeUsuarios.getInstance().usuarios.clear();
		
		when(mockUsuario.getNombreusuario()).thenReturn("a");
		when(mockUsuario.getPassword()).thenReturn("b");
		when(mockUsuario.getEmail()).thenReturn("c");
		
		
		
	}
}
