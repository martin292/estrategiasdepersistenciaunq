package tp2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import servicios.AsientoManager;
import tp1.Usuario;
import aerolinea.Asiento;
import static org.junit.Assert.*;

public class ReservarAsientosTest {

	@Test
	public void TestReservarAsientos(){
		Date fecha = new Date();
		Usuario user = new Usuario("Nombre", "Apellido", "UserName", "pass", "email", fecha);
		
		List<Asiento> asientos = new AsientoManager().reservarAsientos(user, this.ids());
		
		for(Asiento a: asientos){
			assertEquals(a.getUsuario(), user);
		}
	}

	
	private List<Integer> ids() {
		
		List<Integer> ret = new ArrayList<Integer>();
		
		ret.add(1);
		ret.add(2);
		ret.add(3);
		
		return ret;
	}
	
}
