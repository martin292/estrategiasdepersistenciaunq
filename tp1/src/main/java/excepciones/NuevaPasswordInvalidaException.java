package excepciones;

public class NuevaPasswordInvalidaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NuevaPasswordInvalidaException(){
		super("La nueva password es invalida");
	}

}
