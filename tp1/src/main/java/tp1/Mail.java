package tp1;

public class Mail implements EnviadorDeMails {
	
	// ********************************************************
	// * Variables
	// ********************************************************
	
	protected String body;//Codigo de validacion
	protected String subject;
	protected String to;
	protected String from;

	
	
	/**
	 * Constructor
	 * @param body
	 * @param subject
	 * @param to
	 * @param from
	 */
	public Mail(String body, String subject, String to, String from) {
		super();
		this.body = body;
		this.subject = subject;
		this.to = to;
		this.from = from;
	}




	public String getBody() {
		return body;
	}




	public void setBody(String body) {
		this.body = body;
	}




	public String getSubject() {
		return subject;
	}




	public void setSubject(String subject) {
		this.subject = subject;
	}




	public String getTo() {
		return to;
	}




	public void setTo(String to) {
		this.to = to;
	}




	public String getFrom() {
		return from;
	}




	public void setFrom(String from) {
		this.from = from;
	}




	public void enviarMail(Mail mail) {
		// TODO Auto-generated method stub
		
	}

}
