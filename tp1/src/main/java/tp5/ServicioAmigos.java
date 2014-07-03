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

import tp1.Usuario;

public class ServicioAmigos {

	
	protected Node usuario;
	
	protected GraphDatabaseService graphDb;
	private static final String DB_PATH = "target/neo4j-hello-db";
	
			
	//---------------------------------------------------------------
	
	public void agregarAmigo(Node amigo){
		try{
			Transaction tx = graphDb.beginTx();
			
			Relationship relacion = this.usuario.createRelationshipTo(amigo, TipoRelacion.KNOWS);
			relacion.setProperty("mensaje", "Conoce");
			
			tx.success();
			
		}catch(Exception e){
			
		}
	}
	
	public Iterable<Relationship> consultarAmigos(){		
		return this.usuario.getRelationships();
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
	
	private static void deleteFileOrDirectory( File file )
	    {
	        if ( file.exists() )
	        {
	            if ( file.isDirectory() )
	            {
	                for ( File child : file.listFiles() )
	                {
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
		
		Node usr1 = sa.graphDb.createNode();
		usr1.setProperty("id", 1);
		
		Node usr2 = sa.graphDb.createNode();
		usr2.setProperty("id", 2);
		
		sa.usuario = usr1;
		
		sa.agregarAmigo(usr2);
		
		sa.removeData();
		sa.shutDown();
	}

}
