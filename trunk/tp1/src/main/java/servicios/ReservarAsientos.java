package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.AsientoDAO;
import tp1.Usuario;
import aerolinea.Asiento;



public class ReservarAsientos implements Operation<List<Integer>> {
	
	private List<Integer> asientos = new ArrayList<Integer>();
	private Usuario user;
	
	public ReservarAsientos(Usuario u, List<Integer> ids){
		super();
		this.user = u;
		this.asientos = ids;
	}
	
	public List<Integer> execute() {
		
		List<Integer> ret = new ArrayList<Integer>();
		
		for(Integer id: this.asientos){
			Asiento a = new AsientoDAO().get(id);
			a.setUsuario(this.user);
		}
		
		return ret;
	}
	
}
