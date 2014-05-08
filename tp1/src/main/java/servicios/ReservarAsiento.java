package servicios;

import daos.AsientoDAO;
import tp1.Usuario;
import aerolinea.Asiento;


public class ReservarAsiento implements Operation<Asiento> {

	private Integer id;
	private Usuario user;
	
	public ReservarAsiento(Integer id, Usuario u){
		super();
		this.id = id;
		this.user = u;
	}
	
	
	public Asiento execute() {
		Asiento a = new AsientoDAO().get(id);
		a.setUsuario(this.user);		
		return a;
	}
	

}
