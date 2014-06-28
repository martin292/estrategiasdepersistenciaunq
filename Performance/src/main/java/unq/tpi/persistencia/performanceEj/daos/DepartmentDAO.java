package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import unq.tpi.persistencia.performanceEj.model.DatosEmpleados;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentDAO {

	public Department getByName(final String name) {
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("from Department where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	public Department getByCode(String num) {
		Session session = SessionManager.getSession();
		return (Department) session.get(Department.class, num);
	}
	
	
	public List<DatosEmpleados> getEmployeesByDepartmentCode(String num){
		Session session = SessionManager.getSession();		
		
		return (List<DatosEmpleados>)session
                .createQuery("select  new unq.tpi.persistencia.performanceEj.model.DatosEmpleados(emp.firstName , emp.lastName, tit, sal.amount) "
                		   + "from Department as dep inner join  dep.employees as emp inner join emp.salaries as sal inner join emp.titles tit "
                		   + "where dep.number = :num and sal.to = '9999-01-01' ")
                .setParameter("num", num).list();
						
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}

}
