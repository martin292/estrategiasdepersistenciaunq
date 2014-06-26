package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
	
	
	public List<Employee> getEmployeesByDepartmentCode(String num){
		Session session = SessionManager.getSession();
		
		Criteria ret = session.createCriteria(Employee.class).createCriteria("departments").add(Restrictions.eq("number", num));
		
		return ret.list();
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}

}
