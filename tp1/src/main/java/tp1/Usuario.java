package tp1;

import java.util.Date;

public class Usuario {
	
	protected String nombre;
	protected String apellido;
	protected String nombreusuario;
	protected String password;
	protected String email;  
	protected int codigodevalidacion;
	protected Date fechanacimiento;
	
	
	
	
	
	
	
	
	
	
	
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
	public int getCodigodevalidacion() {
		return codigodevalidacion;
	}
	public void setCodigodevalidacion(int codigodevalidacion) {
		this.codigodevalidacion = codigodevalidacion;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
	

}
