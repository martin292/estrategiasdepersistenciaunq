package unq.tpi.persistencia.performanceEj.servicios;

import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.DatosEmpleados;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;

public class ListadoPagosPorDepto extends AbstractListado {

	private String num;
	private Department depto = null;

	public ListadoPagosPorDepto(String num) {
		this.num = num;
	}

				
	@Override
	protected void doListado() throws Exception {
		List<DatosEmpleados> empleados = new DepartmentDAO().getEmployeesByDepartmentCode(num);
				
		this.addColumn("Nombre");
		this.addColumn("Titulo");
		this.addColumn("Monto");
		this.newLine();

		Double tot = 0D;
		
		for (DatosEmpleados e : empleados) {
			tot += e.getSalaryAmount();			
			this.addColumn(e.getNombreCompleto());
			this.addColumn(e.getTitle());
			this.addColumn(e.getSalaryAmount());
			this.newLine();
		}
		
		this.newLine();
		this.addColumn("Total").addColumn(tot).newLine();
		this.newLine();		
	}

	@Override
	public String getFilename() {
		return "./target/PagosPorDepto.csv";
	}
	
		
}
