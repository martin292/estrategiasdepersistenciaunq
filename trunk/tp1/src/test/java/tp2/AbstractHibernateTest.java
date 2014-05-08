package tp2;

import junit.framework.TestCase;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public abstract class AbstractHibernateTest extends TestCase{

	private SessionFactory sessionFactory;

	public AbstractHibernateTest() {
		super();
	}

	public AbstractHibernateTest(String name) {
		super(name);
	}	
}
