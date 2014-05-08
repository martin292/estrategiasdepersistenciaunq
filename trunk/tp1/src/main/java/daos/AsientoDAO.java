package daos;

import aerolinea.Asiento;


public class AsientoDAO {
	
	public Asiento get(int id){
		return (Asiento)SessionManager.getSession().get(Asiento.class, id);
	}

	public void save(Asiento a) {
		SessionManager.getSession().saveOrUpdate(a);
	}
}
