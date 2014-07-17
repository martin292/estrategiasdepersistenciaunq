package tp6;

import java.net.UnknownHostException;

import net.vz.mongodb.jackson.JacksonDBCollection;
import tp1.Usuario;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ServicioComentarios {
	
	private MongoClient mongoClient = new MongoClient();
	private DB db = mongoClient.getDB("aterrizar");
	
	public ServicioComentarios()throws UnknownHostException{}
	
	private Collection<Perfil> home = this.collection(Perfil.class);
	

	//-----------------------------------------
	
	public void agregarNuevoPerfil(Usuario usr){		
		Perfil p = new Perfil();		
		p.setIdUsuario(usr.getId());		
		this.home.insert(p);
	}
	
	public void agregarDestino(Destino destino, Perfil p){
		p.agregarDestino(destino);
		this.home.update(p);		
	}
		
	public void agregarComentario(Comentario comentario, Perfil p, Integer destinoID){		
		p.retDestino(destinoID).agregarComentario(comentario);		
		this.home.update(p);
	}
	
	public void meGusta(Perfil p, Integer destinoID){		
		p.retDestino(destinoID).meGusta();		
		this.home.update(p);
	}
	
	public void noMeGusta(Perfil p, Integer destinoID){		
		p.retDestino(destinoID).noMeGusta();		
		this.home.update(p);
	}	

	public void establecerVisibilidadAlDestino(Perfil p, Integer destinoID, Visibilidad nivel){		
		p.retDestino(destinoID).setVisibilidad(nivel);		
		this.home.update(p);
	}
	
	public void establecerVisibilidadAlComentario(Perfil p, Comentario c, Visibilidad nivel){
		c.setVisibilidad(nivel);
		this.home.update(p);
	}
	
	public Perfil verPerfil(Integer usrID, Integer id){		
		return null;
	}
	
		
	//-----------------------------------------
	
	
	public <T> Collection<T> collection(Class<T> entityType){
		DBCollection dbCollection = db.getCollection(entityType.getSimpleName());
		return new Collection<T>(JacksonDBCollection.wrap(dbCollection, entityType, String.class));
	}
	
	//

}
