package daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import aerolinea.Vuelo;

public class VueloDAO {
	
	public Vuelo get(int id){
		return (Vuelo)SessionManager.getSession().get(Vuelo.class, id);
	}

	public void save(Vuelo v) {
		SessionManager.getSession().saveOrUpdate(v);
	}
		
}
