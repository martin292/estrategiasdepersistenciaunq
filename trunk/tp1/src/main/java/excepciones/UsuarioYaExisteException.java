package excepciones;

public class UsuarioYaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioYaExisteException(String string) {
		super("El usuario ya existe");
	}

}
