package tp1;

import java.util.Date;

public class Usuario implements EnviadorDeMails {
	
	protected String nombre;
	protected String apellido;
	protected String nombreusuario;
	protected String password;
	protected String email;  
	protected String codigodevalidacion;
	protected boolean cuentaValida = false;
	protected Date fechanacimiento;
	
		
	
	public Usuario(String nombre, String apellido, String nombreusuario,
			String password, String email, Date fechanacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreusuario = nombreusuario;
		this.password = password;
		this.email = email;
		this.fechanacimiento = fechanacimiento;
	}



	/**
	 * Registrarse
	 * @throws UsuarioYaExisteException
	 */
	public void registrarse() throws UsuarioYaExisteException{
		RepositorioDeUsuarios.getInstance().registrarUsuario(this);		
	}
	
	/**
	 * CambiarPassword
	 * @param userName
	 * @param password
	 * @param nuevaPassword
	 * @throws NuevaPasswordInvalidaException
	 */
	public void cambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInvalidaException {
		if (this.getNombreusuario() == userName && this.getPassword() == password){
			this.setPassword(nuevaPassword);
		}
		else{
			throw new NuevaPasswordInvalidaException();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Getters and setters
	 * @return
	 */
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigodevalidacion() {
		return codigodevalidacion;
	}
	public void setCodigodevalidacion(String codigodevalidacion) {
		this.codigodevalidacion = codigodevalidacion;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public boolean getCuentaValida() {
		return cuentaValida;
	}

	public void setCuentaValida(boolean cuentaValida) {
		this.cuentaValida = cuentaValida;
	}




	public void enviarMail(Mail mail) {
		// TODO Auto-generated method stub
		
	}







		
	}
