package tp1;

public class Sistema {
	
	public void registrarUsuario(Usuario usuario){
		
	}

	public void validarCuenta(String codigoValidacion){
		
		
	
	}
	
	
	
	public Usuario ingresarUsuario(String userName, String password){
		if(this.elUsuarioExiste(userName, password)){
			return this.retUsuario(userName, password);
		}
		throw new UsuarioNoExiste();
	}
	
	
	private Usuario retUsuario(String userName, String password) {
		return RepositorioDeUsuarios.getInstance().retornarUsuario(userName, password);
	}

	private boolean elUsuarioExiste(String userName, String password) {
		return RepositorioDeUsuarios.getInstance().existe(userName, password);
	}
	
	
	

	/**
	 * Cabiar el password de un usuario
	 * @param userName
	 * @param password
	 * @param newPassword
	 */
	public void cambiarPassword(String userName, String password, String newPassword){
		RepositorioDeUsuarios.getInstance().retornarUsuario(userName, password).cambiarPassword(newPassword);
	}
	
}

