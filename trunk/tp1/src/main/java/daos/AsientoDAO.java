package daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Asiento;


public class AsientoDAO {
	
	public Asiento get(int id){
		return (Asiento)SessionManager.getSession().get(Asiento.class, id);
	}

	public void save(Asiento a) {
		SessionManager.getSession().saveOrUpdate(a);
	}
	
	public List<Asiento> asientosDisponiles(int tramo){
		Criteria criteria = SessionManager.getSession().createCriteria(Asiento.class);
		criteria.add(Restrictions.eq("estado", false));
		criteria.createAlias("tramo", "t").add(Restrictions.eq("t.id", tramo));
		return criteria.list();
			
	}
	
	public List<Asiento> asientosDisponibles(List<Integer> ids){
		Criteria criteria = SessionManager.getSession().createCriteria(Asiento.class);
		criteria.add(Restrictions.eq("estado", false));
		criteria.add(Restrictions.in("id", ids));		
		return criteria.list();
	}
}
