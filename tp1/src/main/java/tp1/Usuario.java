package tp1;

import java.util.Date;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


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
	
	//TP 5--------------------------------------
	protected Node nodoUsuario;
	protected List<Relationship> relaciones;
	protected GraphDatabaseService graphDb;
	private static final String DB_PATH = "target/neo4j-hello-db";
	//------------------------------------------
	
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

	
	// ******************************************************************
	// * Metodos
	// ******************************************************************
	
	public void agregarAmigo(Node amigo){
		try{
			Transaction tx = graphDb.beginTx();
			
			Relationship relacion = this.nodoUsuario.createRelationshipTo(amigo, TipoRelacion.KNOWS);
			this.relaciones.add(relacion);
			
			tx.success();
			
		}catch(Exception e){
			
		}
	}
	
	private static enum TipoRelacion implements RelationshipType { KNOWS }
	
	public void crearDB(){
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
		//registerShutdownHook( graphDb );
	}
	
	public void shutDown(){
        System.out.println();
        System.out.println( "Shutting down database ..." );
        graphDb.shutdown();
    }
	
	
	
	
	
	
	
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
