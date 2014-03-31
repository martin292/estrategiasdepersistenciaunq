package tp1;

import database.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.MessageFormat;

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
			ps = conn.prepareStatement("SELECT USERNAME FROM usuarios");
			ResultSet resultSet = ps.executeQuery();
			
			if(!this.usuarioExiste(usuario, resultSet)){
				this.insertUsuario(usuario, ps, conn);
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
	private void insertUsuario(Usuario usuario, PreparedStatement ps, Connection conn) {
		try {
			ps = conn.prepareStatement("INSERT INTO usuarios (USERNAME, PASSWORD, NOMBRE, APELLIDO, EMAIL) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, usuario.getNombreusuario());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getNombre());
			ps.setString(4, usuario.getApellido());
			ps.setString(5, usuario.getEmail());
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
	private boolean usuarioExiste(Usuario usuario, ResultSet rs) {
		try {
			while(rs.next()){
				String username = rs.getString("USERNAME");
				if(usuario.getNombreusuario() == username)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public void validarCuenta(String codigoValidacion, Usuario usuario) {
		// TODO Auto-generated method stub
	
	}

	public Usuario ingresarUsuario(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cambiarPassword(String userName, String password,
			String newPassword) {
		// TODO Auto-generated method stub
	
	}
}
