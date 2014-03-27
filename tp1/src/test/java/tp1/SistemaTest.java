package tp1;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class SistemaTest {
	
	public Sistema s = new Sistema();
	
	@Test
	public void testIngresarUsuario(){
		
		Usuario mockUsuario = mock(Usuario.class);
		RepositorioDeUsuarios.getInstance().usuarios.add(mockUsuario);
		
		when(mockUsuario.getNombreusuario()).thenReturn("a");
		when(mockUsuario.getPassword()).thenReturn("b");
		
		s.ingresarUsuario("a", "b");
		
		verify(mockUsuario).getNombreusuario();
		verify(mockUsuario).getPassword();
		
	}

}
