package tp2;

import java.util.Date;

import org.junit.Test;

import servicios.AsientoManager;
import tp1.Usuario;
import aerolinea.Asiento;
import static org.junit.Assert.*;

public class ReservarAsientoTest {

	@Test
	public void TestReservarAsiento(){
		Integer id = 1;
		Date fecha = new Date();
		Usuario user = new Usuario("Nombre", "Apellido", "UserName", "pass", "email", fecha);
		
		Asiento a = new AsientoManager().reservarAsiento(id, user);
		
		//Assert
	}
	
}
