package tp2;

import org.junit.Test;

public class ConsultarAsientoTest extends AbstractHibernateTest{

	@Test
	public void testApp()throws Exception{
		//TODO
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