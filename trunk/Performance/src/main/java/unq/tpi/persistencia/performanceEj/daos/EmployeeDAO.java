package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.util.SessionManager;

public class EmployeeDAO {

	public Employee getByName(final String name, final String lastName) {
		Session session = SessionManager.getSession();
		return (Employee) session
				.createQuery(
						"from Employee where firstName = :name and lastName = :lastName")
				.setParameter("name", name).setParameter("lastName", lastName)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Employee.class).list();
	}

	public Employee getByCode(int id) {
		Session session = SessionManager.getSession();
		return (Employee) session.load(Employee.class, id);
	}

	//
	
	public List<Employee> getMaxSalario(){
		Session session = SessionManager.getSession();
		
		Criteria emp = session.createCriteria(Employee.class);
		
		emp.createCriteria("salaries").addOrder(Order.asc("amount")).setMaxResults(10);
		
		return emp.list();
	}
	
}
