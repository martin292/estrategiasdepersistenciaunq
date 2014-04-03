package tp1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import junit.framework.TestCase;

public class UsuarioTest extends TestCase {
	
	
	Usuario mockUsuario = mock(Usuario.class);
	
	
	@Test
	public void testCodigoDeValidacionCorrecto(){
		
		when(mockUsuario.getCodigodevalidacion()).thenReturn("codigo");
		
		assertTrue(mockUsuario.codigoDeValidacionCorrecto("codigo"));
		
	}
	
	@Test
	public void testCambiarPassword(){
	                                  
		//Usuario mockUsuario = mock(Usuario.class);
		mockUsuario.cambiarPassword("newPassword");
		verify(mockUsuario).setPassword("newPassword");
	}

	@Test
	public void testValidarCuenta(){
		mockUsuario.validarCuenta();
		verify(mockUsuario).setCuentaValida(true);
	}
}
