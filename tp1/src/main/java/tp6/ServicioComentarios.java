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
	
	public void agregarNuevoPerfil(Usuario usr){
		Collection<Perfil> home = this.collection(Perfil.class);
		
		Perfil p = new Perfil();
		
		p.setIdUsuario(usr.getId());
		
		home.insert(p);
	}
	
	public void agregarDestino(Destino destino, Perfil p){
		Collection<Perfil> home = this.collection(Perfil.class);
		p.agregarDestino(destino);
		home.update(p);		
	}
		
	public void agregarComentario(Comentario comentario, Perfil p, Integer destinoID){
		Collection<Perfil> home = this.collection(Perfil.class);
		
		p.retDestino(destinoID).agregarComentario(comentario);
		
		home.update(p);
	}
	
	public void meGusta(Perfil p, Integer destinoID){
		Collection<Perfil> home = this.collection(Perfil.class);
		
		p.retDestino(destinoID).meGusta();
		
		home.update(p);
	}
	
	public void noMeGusta(Perfil p, Integer destinoID){
		Collection<Perfil> home = this.collection(Perfil.class);
		
		p.retDestino(destinoID).noMeGusta();
		
		home.update(p);
	}	

	public void establecerVisibilidadAlDestino(Perfil p, Integer destinoID, Visibilidad nivel){
		Collection<Perfil> home = this.collection(Perfil.class);
		
		p.retDestino(destinoID).setVisibilidad(nivel);
		
		home.update(p);
	}
	
	public void establecerVisibilidadAlComentario(Perfil p, Comentario c, Visibilidad nivel){
		Collection<Perfil> home = this.collection(Perfil.class);
		c.setVisibilidad(nivel);
		home.update(p);
	}
	
	public Perfil verPerfil(Perfil yo, Perfil el){
		return el.mostrarPerfil(yo);
	}
	
	//-----------------------------------------
	
	
	public <T> Collection<T> collection(Class<T> entityType){
		DBCollection dbCollection = db.getCollection(entityType.getSimpleName());
		return new Collection<T>(JacksonDBCollection.wrap(dbCollection, entityType, String.class));
	}
	
	//-----------------------------------------
	
	public static void main(String[] args) throws UnknownHostException{
		ServicioComentarios sc = new ServicioComentarios();
		
		//
		
		sc.mongoClient.close();
	}

}
