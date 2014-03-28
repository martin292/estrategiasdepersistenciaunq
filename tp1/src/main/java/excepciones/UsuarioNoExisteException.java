package excepciones;

public class UsuarioNoExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioNoExisteException(){
		super("El usuario no existe");
	}

}
