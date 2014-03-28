package excepciones;

import tp1.Mail;

public class EnviarMailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnviarMailException(Mail mail) {
		super("No se puede enviar email");
	}

}
