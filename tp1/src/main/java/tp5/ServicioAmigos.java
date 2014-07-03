package tp5;

import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import tp1.Usuario;

public class ServicioAmigos {

	protected Node nodoUsuario;
	protected List<Relationship> relaciones;
	protected GraphDatabaseService graphDb;
	private static final String DB_PATH = "target/neo4j-hello-db";
	
	
	public void agregarAmigo(Node amigo){
		try{
			Transaction tx = graphDb.beginTx();
			
			Relationship relacion = this.nodoUsuario.createRelationshipTo(amigo, TipoRelacion.KNOWS);
			this.relaciones.add(relacion);
			
			tx.success();
			
		}catch(Exception e){
			
		}
	}
	
	public List<Usuario> consultarAmigos(){
		try{
			Transaction tx = graphDb.beginTx();
			
			List<Usuario> amigos;
			
			for(Relationship rel: this.relaciones){
				Node n = rel.getEndNode();
			}
			
		}catch(Exception e){
			
		}		
		
		return null;
	}
	
	
	
	private static enum TipoRelacion implements RelationshipType { KNOWS }
	
	public void crearDB(){			
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
	
	
	
	
	
	
	
	public static void main(String[] args) {}

}
