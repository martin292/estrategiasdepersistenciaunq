package tp1;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestSistemaDB {
	
	public SistemaDB sis = new SistemaDB();
	
	@Test
	public void testRegistrarUsuario(){
		Usuario mockUsuario = mock(Usuario.class);
		
		when(mockUsuario.getNombreusuario()).thenReturn("user");
		when(mockUsuario.getPassword()).thenReturn("pass");
		when(mockUsuario.getNombre()).thenReturn("nombre");
		when(mockUsuario.getApellido()).thenReturn("apellido");
		when(mockUsuario.getEmail()).thenReturn("email");
		
		sis.registrarUsuario(mockUsuario);
		
		verify(mockUsuario).getNombreusuario();
		verify(mockUsuario).getPassword();
		verify(mockUsuario).getNombre();
		verify(mockUsuario).getApellido();
		verify(mockUsuario).getEmail();
	}

}
