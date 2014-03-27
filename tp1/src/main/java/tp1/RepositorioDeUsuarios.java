package tp1;

import java.util.ArrayList;

public class RepositorioDeUsuarios {
	
	protected ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	protected static RepositorioDeUsuarios instance;
	
	public static synchronized RepositorioDeUsuarios getInstance() {
		if (instance == null) {
			instance = new RepositorioDeUsuarios();
		}
		return instance;
	}
	
	
	
	/**
	 * Existe usuario
	 * @param usuario
	 * @return
	 */
	private boolean noExisteUsuario(Usuario usuario) {
		return usuarios.contains(usuario);
	}
	
	public Usuario retornarUsuario(String username, String pass){
		
		for(Usuario u: this.usuarios){
			if(u.nombreusuario == username && u.password == pass){
				return u;
			}
		}
		throw new UsuarioNoExiste();
	}
	
	public boolean existe(String userName, String password) {

		for(Usuario u: this.usuarios){
			if(u.nombreusuario == userName && u.password == password){
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
