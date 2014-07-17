package tp6;

import java.net.UnknownHostException;


import net.vz.mongodb.jackson.JacksonDBCollection;
import tp1.Usuario;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ServicioComentarios {
	
	private static ServicioComentarios INSTANCE;

	private MongoClient mongoClient = new MongoClient();
	private DB db = mongoClient.getDB("aterrizar");
	
	public ServicioComentarios()throws UnknownHostException{}
	
	private Collection<Perfil> home = this.collection(Perfil.class);

	
	synchronized public static ServicioComentarios instance() throws UnknownHostException {
		if (INSTANCE == null) {
			INSTANCE = new ServicioComentarios();
		}
		return INSTANCE;
	}
	

	//-----------------------------------------
	
	public Collection<Perfil> getHome() {
		return home;
	}

	public void agregarNuevoPerfil(Usuario usr){		
		Perfil p = new Perfil();		
		p.setIdUsuario(usr.getId());
		p.setUsrName(usr.getNombreusuario());
		this.home.insert(p);
	}
	
	public Perfil retPerfil(Integer id){
		return this.home.ret(id);
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
		return this.retPerfil(this.retPerfil(usrID), this.retPerfil(id));
	}
	
	public Perfil retPerfil(Perfil yo, Perfil el){
		return el.mostrarPerfil(yo);
	}
	
		
	//-----------------------------------------
	
	
	public <T extends MongoEntity> Collection<T > collection(Class<T> entityType){
		DBCollection dbCollection = db.getCollection(entityType.getSimpleName());
		return new Collection<T>(JacksonDBCollection.wrap(dbCollection, entityType, Integer.class));
	}
	
	//

}
