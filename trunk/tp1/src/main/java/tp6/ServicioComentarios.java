package tp6;

import java.net.UnknownHostException;

import tp1.Usuario;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ServicioComentarios {
	
	private MongoClient mongoClient = new MongoClient();
	private DB db = mongoClient.getDB("aterrizar");
	
	public ServicioComentarios()throws UnknownHostException{
		super();
	}

	//-----------------------------------------
	
	public void agregarDestino(Destino destino, Usuario usr){
		DBCollection coll = db.getCollection("coleccionUsuarios");
		
		BasicDBObject query = new BasicDBObject("UserName", usr.getNombreusuario());
		
		Cursor cursor = coll.find(query);
		
	}
	
	public void agregarUsuario(Usuario usr){
		DBCollection coll = db.getCollection("coleccionUsuarios");
		BasicDBObject doc = new BasicDBObject("Nombre", usr.getNombre());
        doc.append("Apellido", usr.getApellido());
        doc.append("UserName", usr.getNombreusuario());
        doc.append("Password", usr.getPassword());
        doc.append("Email", usr.getEmail());
        doc.append("Fecha", usr.getFechanacimiento());
        //
        
        coll.insert(doc);        
        
        DBObject myDoc = coll.findOne();
		System.out.println(myDoc);
	}
	
	
	
	
	public static void main(String[] args) throws UnknownHostException{
		ServicioComentarios sc = new ServicioComentarios();
		sc.mongoClient.dropDatabase("aterrizar");
		
		Usuario usr = new Usuario(1, "hola");
		usr.setNombre("aaaaaa");
		usr.setApellido("aaaa");
		usr.setEmail("unEmail");
		usr.setPassword("aaaaaaaaa");
		
		sc.agregarUsuario(usr);
		
		sc.mongoClient.close();
	}

}
