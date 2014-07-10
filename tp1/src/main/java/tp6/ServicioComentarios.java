package tp6;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ServicioComentarios {
	
	private MongoClient mongoClient = new MongoClient();
	private DB db = mongoClient.getDB("mydb");
	
	public ServicioComentarios()throws UnknownHostException{
		super();
	}

	public static void main(String[] args) {

	}

}
