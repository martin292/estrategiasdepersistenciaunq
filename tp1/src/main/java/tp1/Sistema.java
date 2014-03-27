package tp1;

public class Sistema {
	
	/**
	 * Registrar usuario
	 * @param usuario
	 * @throws UsuarioYaExisteException
	 */
	public void registrarUsuario(Usuario usuario) throws UsuarioYaExisteException {
		Mail mail = new Mail();
		if (RepositorioDeUsuarios.getInstance().existe(usuario.getNombreusuario(), usuario.getPassword())){
			usuario.enviarMail(mail);
			RepositorioDeUsuarios.getInstance().agregarUsuario(usuario);
		}
		else{
			throw new UsuarioYaExisteException("Ya existe un usuario con ese nombre");
		}
		
	}

	/**
	 * Validar cuenta.
	 * @param codigoValidacion
	 */
	public void validarCuenta(String codigoValidacion, Usuario usuario){
		
		if(usuario.codigoDeValidacionCorrecto(codigoValidacion)){
			usuario.validarCuenta();
		}
		else{
			throw new ValidacionException();
		}
	
	}
	
	
	/**
	 * Ingresar Usuario
	 * @param userName
	 * @param password
	 * @return
	 */
	public Usuario ingresarUsuario(String userName, String password){
		if(this.elUsuarioExiste(userName, password)){
			return this.retUsuario(userName, password);
		}
		throw new UsuarioNoExiste();
	}
	
	
	public Usuario retUsuario(String userName, String password) {
		return RepositorioDeUsuarios.getInstance().retornarUsuario(userName, password);
	}

	public boolean elUsuarioExiste(String userName, String password) {
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

