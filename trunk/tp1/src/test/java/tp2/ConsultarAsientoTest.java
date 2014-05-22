package tp2;

import java.util.List;

import org.junit.Test;

import aerolinea.Asiento;
import servicios.AsientoManager;

public class ConsultarAsientoTest extends AbstractHibernateTest{

	//Agregar un tramo y asientos a la bdd
	
	@Test
	public void testApp()throws Exception{
		Integer idTramo = 1;
		List<Asiento> asientos = new AsientoManager().consultarAsientos(idTramo);
		assertTrue(!asientos.isEmpty());
	}
	
}
//http://cursohibernate.es/doku.php?id=unidades:03_relaciones:04_uno_a_muchos_ordenada

/*
<property name="origen" type="aerolinea.Aerolinea">
<column name="idAerolineaOrigen" length="20" not-null="true" unique="false" />
</property>
<property name="destino" type="aerolinea.Aerolinea">
<column name="idAerolineaDestino" length="20" not-null="true" unique="false" />
</property>
*/