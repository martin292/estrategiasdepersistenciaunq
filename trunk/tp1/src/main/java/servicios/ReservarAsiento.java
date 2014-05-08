package servicios;

import tp1.Usuario;
import aerolinea.Asiento;
import aerolinea.Tramo;

public class ReservarAsiento implements Operation<Asiento> {

	private Asiento asiento;
	private Usuario user;
	
	public ReservarAsiento(Asiento a, Usuario u){
		super();
		this.asiento = a;
		this.user = u;
	}
	
	
	public Asiento execute() {
		Asiento a = new AsientoDAO().getId();
		a.setUsuario(this.user);		
		return a;
	}
	

}
