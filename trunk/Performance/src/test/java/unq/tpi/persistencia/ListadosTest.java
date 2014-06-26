package unq.tpi.persistencia;

import unq.tpi.persistencia.performanceEj.servicios.ListadoDeptos;
import unq.tpi.persistencia.performanceEj.servicios.ListadoDetalleEmpleado;
import unq.tpi.persistencia.performanceEj.servicios.ListadoMaximosSalarios;
import unq.tpi.persistencia.performanceEj.servicios.ListadoPagosPorDepto;
import junit.framework.TestCase;

public class ListadosTest extends TestCase {
	
	
	public void testListadoPagosPorDepto() throws Exception {
		//TODO
		new ListadoPagosPorDepto("d007").listado();
	}
	
	
	/*	
	public void testListadoDeptos() throws Exception {
		//TODO
		new ListadoDeptos().listado();
	}
	*/
		
	/*
	//HECHO
	public void testListadoMaximosSalarios() throws Exception{
		new ListadoMaximosSalarios().listado();
	}
		
	//HECHO
	public void testDetalleEmpleado() throws Exception{
		new ListadoDetalleEmpleado(10010).listado();
		new ListadoDetalleEmpleado(10019).listado();
	}
	*/
	
}
