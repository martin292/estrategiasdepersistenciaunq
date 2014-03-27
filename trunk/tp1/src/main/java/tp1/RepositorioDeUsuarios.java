package tp1;

import java.util.ArrayList;

public class RepositorioDeUsuarios {
	
	protected ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	protected static RepositorioDeUsuarios instance;
	

	public void registrarUsuario(Usuario usuario) throws UsuarioYaExisteException {
		Mail mail = new Mail();
		if (noExisteUsuario(usuario)){
			usuario.enviarMail(mail);
			usuarios.add(usuario);
		}
		else{
			throw UsuarioYaExisteExeption();
		}
		
	}

	private boolean noExisteUsuario(Usuario usuario) {
		return usuarios.contains(usuario);
	}

}
