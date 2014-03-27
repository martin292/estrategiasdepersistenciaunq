package tp1;

import java.util.ArrayList;

public class RepositorioDeUsuarios {
	
	// ******************************************************************
	// * Variables
	// ******************************************************************
	
	protected ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	protected static RepositorioDeUsuarios instance;
	
	public static synchronized RepositorioDeUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioDeUsuarios();
		}
		return instance;
	}
	
	// ******************************************************************
	// * Metodos
	// ******************************************************************
	
	public Usuario retornarUsuario(String username, String pass){
		
		for(Usuario u: this.usuarios){
			if(u.getNombreusuario() == username && u.getPassword() == pass){
				return u;
			}
		}
		throw new UsuarioNoExisteException();
	}
	
	public boolean existe(String userName, String password) {

		for(Usuario u: this.usuarios){
			if(u.getNombreusuario() == userName && u.getPassword() == password){
				return true;
			}
		}
		return false;
	}

	public void agregarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
