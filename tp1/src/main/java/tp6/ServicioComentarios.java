package tp6;

import java.net.UnknownHostException;

import net.vz.mongodb.jackson.JacksonDBCollection;
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
		Collection<Usuario> home = this.collection(Usuario.class);
		usr.agregarDestino(destino);
		home.insert(usr);		
	}
	
	public void agregarUsuario(Usuario usr){
		Collection<Usuario> home = this.collection(Usuario.class);
		home.insert(usr);
	}
	
	//-----------------------------------------
	
	
	public <T> Collection<T> collection(Class<T> entityType){
		DBCollection dbCollection = db.getCollection(entityType.getSimpleName());
		return new Collection<T>(JacksonDBCollection.wrap(dbCollection, entityType, String.class));
	}
	
	
	public static void main(String[] args) throws UnknownHostException{
		ServicioComentarios sc = new ServicioComentarios();
		
		//
		
		sc.mongoClient.close();
	}

}
