package tp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Test;

import database.DBConnector;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidacionException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SistemaDBTest {
	
	public SistemaDB sis = new SistemaDB();
	Date date = new Date();
	Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito", "myPassword", "email", date);
	
	
	
	
	@After
	public void tearDown(){
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = new DBConnector().getConnection();
			ps = conn.prepareStatement("DELETE FROM Usuario");
			ps.execute();
			
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();			
		}
	}
	
	@Test
	public void testRegistrarUsuario(){
		
		sis.registrarUsuario(usuario);
		
		assertEquals(usuario.getNombreusuario(), sis.ingresarUsuario("jorgito", "myPassword").getNombreusuario());	
	}
	
	@Test
	public void testRegistrarUsuarioFalla(){
		Usuario usuario2 = new Usuario("a", "a", "jorgito", "a", "a", date);
		try{
			sis.registrarUsuario(usuario);
			sis.registrarUsuario(usuario2);
			
		}catch(Exception e){
			assertTrue(1==1);
		}
	}
	
	@Test
	public void testValidarCuenta(){
		usuario.setCodigodevalidacion("codigo");
		sis.registrarUsuario(usuario);
		
		assertFalse(sis.ingresarUsuario("jorgito", "myPassword").getCuentaValida());
		
		sis.validarCuenta("codigo", usuario);
		
		assertTrue(sis.ingresarUsuario("jorgito", "myPassword").getCuentaValida());
	}
	
	@Test (expected = ValidacionException.class)
	public void testValidarCuentaException(){
		
		usuario.setCodigodevalidacion("codigo");
		sis.registrarUsuario(usuario);
		
		sis.validarCuenta("otroCodigo", usuario);
		
	}
	
	
	@Test
	public void testIngresarUsuario(){
		
		sis.registrarUsuario(usuario);
		
		Usuario user = sis.ingresarUsuario("jorgito", "myPassword");
		
		assertEquals(user.getNombreusuario(), "jorgito");
	}
	
	@Test
	public void testCambiarPassword(){
		usuario.setCodigodevalidacion("codigo");
		sis.registrarUsuario(usuario);
		
		sis.validarCuenta("codigo", usuario);
		sis.cambiarPassword("jorgito", "myPassword", "newPassword");
		
		assertTrue("newPassword" == sis.ingresarUsuario("jorgito", "newPassword").getPassword());
	
	}

	
	
}
