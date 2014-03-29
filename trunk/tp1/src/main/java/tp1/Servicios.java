package tp1;

public interface Servicios {
	public void registrarUsuario(Usuario usuario);
	public void validarCuenta(String codigoValidacion, Usuario usuario);
	public Usuario ingresarUsuario(String userName, String password);
	public void cambiarPassword(String userName, String password, String newPassword);
}
