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
	
	public List<Vuelo> retVuelosOrdPorCosto(int idAero){
		Criteria criteria = SessionManager.getSession().createCriteria(Vuelo.class);
		criteria.add(Restrictions.eq("idAerolinea", idAero));
		criteria.addOrder(Order.asc("costo"));		
		return criteria.list();
	}
	
}
