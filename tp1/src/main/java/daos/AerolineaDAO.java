package daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import aerolinea.Aerolinea;
import aerolinea.Asiento;
import aerolinea.Vuelo;


public class AerolineaDAO {

	public Aerolinea get(int id){
		return (Aerolinea)SessionManager.getSession().get(Aerolinea.class, id);
	}

	public void save(Aerolinea a) {
		SessionManager.getSession().saveOrUpdate(a);
	}
	
	
	
}
