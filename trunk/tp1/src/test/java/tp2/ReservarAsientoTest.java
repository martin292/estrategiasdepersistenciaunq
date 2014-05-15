package tp2;

import java.util.Date;

import org.junit.Test;

import servicios.AsientoManager;
import tp1.Usuario;
import aerolinea.Asiento;
import static org.junit.Assert.*;

//<mapping resource="Tramo.hbm.xml"/>

public class ReservarAsientoTest extends AbstractHibernateTest{

	//Agregar un usuario y un asiento a la bdd
	
	@Test
	public void testApp()throws Exception{
		Date fecha = new Date();
		Usuario user = new Usuario("Nombre", "Apellido", "UserName", "pass", "email", fecha);
		user.setId(1);
		
		Asiento a = new AsientoManager().reservarAsiento(1, user);
		
		assertTrue(a.getUsuario().getNombreusuario() == user.getNombreusuario());
		assertTrue(a.getIdUsuario() == 1);
	}
	
}
