package tp1;

import database.DBConnector;
import excepciones.NuevaPasswordInvalidaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidacionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;

public class SistemaDB implements Servicios{
	
	/*
	IMPLEMENTAR ESTOS METODOS CON ACCESO A BASE DE DATOS 
	 */

	/**
	 * Registra, si no existe, un usuario en la bdd
	 */
	public void registrarUsuario(Usuario usuario){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = new DBConnector().getConnection();
			ps = conn.prepareStatement("SELECT nombreusuario FROM Usuario");
			ResultSet resultSet = ps.executeQuery();
			
			if(!this.usuarioExiste(usuario, resultSet)){
				//enviarMail
				this.insertUsuario(usuario, ps, conn);
			}else{
				throw new UsuarioYaExisteException("Ya existe un usuario con ese nombre");
			}
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inserta un usuario en la bdd
	 * @param usuario
	 * @param ps
	 * @param conn
	 */
	public void insertUsuario(Usuario usuario, PreparedStatement ps, Connection conn) {
		try {
			ps = conn.prepareStatement("INSERT INTO Usuario (nombreusuario, PASSWORD, NOMBRE, APELLIDO, EMAIL, cuentaValida, codigodevalidacion) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, usuario.getNombreusuario());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getNombre());
			ps.setString(4, usuario.getApellido());
			ps.setString(5, usuario.getEmail());
			ps.setBoolean(6, usuario.getCuentaValida());
			ps.setString(7, usuario.getCodigodevalidacion());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Retorna true si el usuario existe en la bdd
	 * @param usuario
	 * @param rs
	 * @return
	 */
	public boolean usuarioExiste(Usuario usuario, ResultSet rs) {
		try {
			while(rs.next()){
				String username = rs.getString("nombreusuario");
				if(usuario.getNombreusuario() == username)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public void validarCuenta(String codigoValidacion, Usuario usuario) {
		if(usuario.getCodigodevalidacion() == codigoValidacion){
			
			usuario.setCuentaValida(true);
			this.validar(usuario);
			
		}else{
			throw new ValidacionException();
		}
	
	}

	public void validar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = new DBConnector().getConnection();
			ps = conn.prepareStatement("UPDATE Usuario SET CUENTAVALIDA = ? WHERE nombreusuario = ? ");
			
			ps.setBoolean(1, true);
			ps.setString(2, usuario.getNombreusuario());
			
			ps.executeQuery();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Usuario ingresarUsuario(String userName, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = new DBConnector().getConnection();
			ps = conn.prepareStatement("SELECT * FROM Usuario WHERE nombreusuario = ?");
			ps.setString(1, userName);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			
			String pass = resultSet.getString("PASSWORD");
			boolean esCuentaValida = resultSet.getBoolean("CUENTAVALIDA");
			
			Usuario userRet = new Usuario();
			
			if(esCuentaValida && password == pass){
				userRet.setNombre(resultSet.getString("nombre"));
				userRet.setApellido(resultSet.getString("apellido"));
				userRet.setNombreusuario(resultSet.getString("nombreusuario"));
				userRet.setPassword(resultSet.getString("password"));
				userRet.setEmail(resultSet.getString("email"));
				userRet.setFechanacimiento(resultSet.getDate("fechanacimiento"));
			}						
			
			ps.close();
			conn.close();
			
			if(userRet.getNombreusuario() == userName){
				return userRet;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		throw new UsuarioNoExisteException();
	}

	/**
	 * Busca al usuario lo instancia y lo retorna.
	 * @param user
	 * @param pass
	 * @param rs
	 * @return
	 */
	public Usuario retUsuario(String user, String pass, ResultSet rs) {
		
		try{
			while(rs.next()){
				String username = rs.getString("nombreusuario");
				String password = rs.getString("PASSWORD");
				boolean esCuentaValida = rs.getBoolean("CUENTAVALIDA");
				
				if(esCuentaValida && user == username && pass == password){
					Usuario ret = new Usuario(rs.getString("NOMBRE"), rs.getString("APELLIDO"), 
												username, password, rs.getString("EMAIL"), 
												rs.getDate("FECHA"));
					return ret;
				}
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Cambia la contraseña de un usuario.
	 * Se supone que el usuario existe
	 */
	public void cambiarPassword(String userName, String password, String newPassword) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			if(password != newPassword){
				conn = new DBConnector().getConnection();
				ps = conn.prepareStatement("UPDATE usuarios SET PASSWORD = ? WHERE USERNAME = ? ");
			
				ps.setString(1, newPassword);
				ps.setString(2, userName);
			
				ps.executeQuery();
			
				ps.close();
				conn.close();
			}else{
				throw new NuevaPasswordInvalidaException();
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		Date fecha = new Date();
		Usuario usuario = new Usuario("jorge", "rodriguez", "jorgito", "mypPassword", "email", fecha);
		usuario.validarCuenta();
		SistemaDB sistemaDB = new SistemaDB();
		//sistemaDB.registrarUsuario(usuario);
		System.out.println(sistemaDB.ingresarUsuario("jorgito", "myPassword").getNombreusuario());
	}
	

	/*
	 * sudo apt-get install mysql-server
	 * mysql -uroot -proot
	 */
}
