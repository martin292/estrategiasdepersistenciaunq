package tp1;

import java.util.Date;


public class Usuario{
	
	// ******************************************************************
	// * Variables
	// ******************************************************************
	
	protected String nombre;
	protected String apellido;
	protected String nombreusuario;
	protected String password;
	protected String email;  
	protected String codigodevalidacion;
	protected boolean cuentaValida;
	protected Date fechanacimiento;
	
	private Integer id;
	
	// ******************************************************************
	// * Constructores
	// ******************************************************************

	/**
	 * Es exclusivo para Hibernate no usar 
	 **/
	protected Usuario() {
	}
	
	/**
	 * Constructor
	 * @param nombre
	 * @param apellido
	 * @param nombreusuario
	 * @param password
	 * @param email
	 * @param fechanacimiento
	 */
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

	/*
	public Usuario() {
		super();
	}*/

	// ******************************************************************
	// * Metodos
	// ******************************************************************

	
	/**
	 * Validar cuenta
	 */
	public void validarCuenta(){
		this.setCuentaValida(true);
	}
	
	public void cambiarPassword(String newPassword) {
		this.setPassword(newPassword);
	}

	public boolean codigoDeValidacionCorrecto(String codigoValidacion) {
		return this.getCodigodevalidacion() == codigoValidacion;
		
	}
	
	// ******************************************************************
	// * Getters and setters
	// ******************************************************************
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

		
}
