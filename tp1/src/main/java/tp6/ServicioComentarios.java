package tp6;

import java.net.UnknownHostException;

import tp1.Usuario;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ServicioComentarios {
	
	private MongoClient mongoClient = new MongoClient();
	private DB db = mongoClient.getDB("aterrizar");
	
	public ServicioComentarios()throws UnknownHostException{
		super();
	}

	//-----------------------------------------
	
	public void agregarDestino(String destino){
		
	}
	
	public void agregarUsuario(Usuario usr){
		
	}
	
	
	
	
	public static void main(String[] args) throws UnknownHostException{
		ServicioComentarios sc = new ServicioComentarios();
		
		sc.mongoClient.close();
	}

}
