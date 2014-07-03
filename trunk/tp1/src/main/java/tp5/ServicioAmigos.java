package tp5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import daos.UsuarioDAO;
import tp1.Usuario;

public class ServicioAmigos {

	//--------------------------------------------------------------
	
	protected Node usuario;
	
	protected GraphDatabaseService graphDb;
	private static final String DB_PATH = "target/neo4j-hello-db";
	
			
	//---------------------------------------------------------------
	
	public void agregarAmigo(Node amigo){
		try{
			Transaction tx = graphDb.beginTx();
			
			Relationship relacion = this.usuario.createRelationshipTo(amigo, TipoRelacion.KNOWS);
			relacion.setProperty("relacion", "Conoce");
			
			tx.success();
			
		}catch(Exception e){
			
		}
	}
	
	public List<Node> consultarAmigos(){
		List<Node> amigos = new ArrayList<Node>();
		
		for(Relationship rel: this.usuario.getRelationships()){
			amigos.add(rel.getEndNode());
		}
		
		return amigos;
	}
	
	public void enviarMensaje(String msg){
		//TODO
	}
	
	//------------------------------------------------------------
	
	public Node getUsuario() {
		return usuario;
	}
	public void setUsuario(Node usuario) {
		this.usuario = usuario;
	}
	
	//------------------------------------------------------------	
	
	private static enum TipoRelacion implements RelationshipType { KNOWS }
	
	public void crearDB(){
		deleteFileOrDirectory( new File( DB_PATH ) );
		
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
		registerShutdownHook( graphDb );			
	}
	
	public void shutDown(){
        System.out.println();
        System.out.println( "Shutting down database ..." );
        graphDb.shutdown();
    }
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb ) {
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                graphDb.shutdown();
            }
        } );
    }
	
	void removeData()
    {
        try{
        	Transaction tx = graphDb.beginTx();
            
        	this.usuario.delete();

            tx.success();
        }catch(Exception e){
			
		}
    }
	
	private static void deleteFileOrDirectory( File file ){
		if ( file.exists() ){
			if ( file.isDirectory() ){
				for ( File child : file.listFiles() ){
					deleteFileOrDirectory( child );
	            }
	        }
			file.delete();
	    }
	}	
	
	//-----------------------------------------------------
	
	
	public static void main(String[] args) {
		
		ServicioAmigos sa = new ServicioAmigos();
		
		sa.crearDB();
		
		try{
			Transaction tx = sa.graphDb.beginTx();
			
			Node usr1 = sa.graphDb.createNode();
			usr1.setProperty("id", 1);
			System.out.println(usr1.getProperty("id"));
			
			Node usr2 = sa.graphDb.createNode();
			usr2.setProperty("id", 2);
			System.out.println(usr2.getProperty("id"));
			
			sa.setUsuario(usr1);
			
			sa.agregarAmigo(usr2);
			System.out.println(sa.getUsuario().getProperty("id"));
			System.out.println(sa.getUsuario().hasRelationship());
			
			System.out.println(sa.consultarAmigos().get(0).getProperty("id"));
			
			Usuario usr = new UsuarioDAO().get((Integer) sa.consultarAmigos().get(0).getProperty("id"));
			System.out.println(usr.getId());
			System.out.println(usr.getNombreusuario());
			
			tx.success();
			
		}catch(Exception e){}
		
		sa.removeData();
		sa.shutDown();
		
	}

	//
	
}
