package tp1;

import static org.mockito.Mockito.*;

import org.junit.Test;

import junit.framework.TestCase;

public class UsuarioTest extends TestCase {
	
	
	Usuario usuario = new Usuario();
	
	
	@Test
	public void testCodigoDeValidacionCorrecto(){
		
		usuario.setCodigodevalidacion("codigo");
		
		assertTrue(usuario.codigoDeValidacionCorrecto("codigo"));
		
	}
	
	@Test
	public void testCambiarPassword(){
	}

	@Test
	public void testValidarCuenta(){
	}
}
