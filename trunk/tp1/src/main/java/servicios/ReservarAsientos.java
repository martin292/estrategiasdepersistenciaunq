package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.AsientoDAO;
import tp1.Usuario;
import aerolinea.Asiento;



public class ReservarAsientos implements Operation<List<Asiento>> {
	
	private List<Integer> asientos = new ArrayList<Integer>();
	private Usuario user;
	
	public ReservarAsientos(Usuario u, List<Integer> ids){
		super();
		this.user = u;
		this.asientos = ids;
	}
	
	public List<Asiento> execute() {
		
		List<Asiento> ret = new ArrayList<Asiento>();
		
		if(this.asientosLibres()){
			for(Integer id: this.asientos){
				Asiento a = new AsientoDAO().get(id);
				a.setUsuario(this.user);
				a.setEstado(true);
				a.setIdUsuario(this.user.getId());
				ret.add(a);
			}
		}
		
		return ret;
	}

	private boolean asientosLibres() {
		
		boolean ret = false;
		
		for(Integer id: this.asientos){
			Asiento a = new AsientoDAO().get(id);
			ret = ret && a.isEstado();
		}
		
		return !ret;
	}
	
}
