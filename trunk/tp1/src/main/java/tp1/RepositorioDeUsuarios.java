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
	 * Registrar usuario
	 * @param usuario
	 * @throws UsuarioYaExisteException
	 */
	public void registrarUsuario(Usuario usuario) throws UsuarioYaExisteException {
		Mail mail = new Mail();
		if (noExisteUsuario(usuario)){
			usuario.enviarMail(mail);
			usuarios.add(usuario);
		}
		else{
			throw new UsuarioYaExisteException("Ya existe un usuario con ese nombre");
		}
		
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
			return (u.nombreusuario == userName && u.password == password);
		}
	}


}
