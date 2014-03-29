package tp1;

import email.Mail;
import excepciones.EnviarMailException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidacionException;
import repos.RepositorioDeUsuarios;

public class Sistema implements Servicios{
	
	/**
	 * Registrar usuario
	 * @param usuario
	 * @throws UsuarioYaExisteException
	 */
	public void registrarUsuario(Usuario usuario) {
		String codigo = "codigo";
		Mail mail = new Mail(codigo,"Codigo de validacion" ,usuario.getEmail(), "Aterrizar.com");
		if (!RepositorioDeUsuarios.getInstance().existe(usuario.getNombreusuario(), usuario.getPassword())){
			this.enviarMail(mail);
			usuario.setCodigodevalidacion(codigo);
			RepositorioDeUsuarios.getInstance().agregarUsuario(usuario);
		}
		else{
			throw new UsuarioYaExisteException("Ya existe un usuario con ese nombre");
		}
		
	}

	private boolean enviarMail(Mail mail) {
		if (puedeEnviar(mail)){
			return true;
		}
		
		throw new EnviarMailException(mail);
	}

	private boolean puedeEnviar(Mail mail) {
		
		return mail.getTo() != null;
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
		if(this.elUsuarioExiste1(userName, password)){
			return this.retUsuario1(userName, password);
		}
		throw new UsuarioNoExisteException();
	}
	
	
	public Usuario retUsuario1(String userName, String password) {
		return RepositorioDeUsuarios.getInstance().retornarUsuario(userName, password);
	}

	public boolean elUsuarioExiste1(String userName, String password) {
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
	
	
	
	public Usuario retUsuario(String userName, String password) {
		return RepositorioDeUsuarios.getInstance().retornarUsuario(userName, password);
	}

	public boolean elUsuarioExiste(String userName, String password) {
		return RepositorioDeUsuarios.getInstance().existe(userName, password);
	}
	
	
}

